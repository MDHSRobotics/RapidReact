
package frc.robot.commands.swervedriver;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.consoles.Logger;
import frc.robot.oi.controllers.XboxPositionAccessible;
import frc.robot.oi.movements.SwerveMovement;
import frc.robot.subsystems.SwerveDriver;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import frc.robot.subsystems.constants.SwerveConstants;
import frc.robot.subsystems.constants.SwerveConstants.OIConstants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class SwerveDrive extends CommandBase {

    private final SwerveDriver swerveDriver;
    private final XboxPositionAccessible controller;
    private final boolean fieldOrientedFunction = false;
    private final SlewRateLimiter xLimiter, yLimiter, turningLimiter;

    public SwerveDrive (SwerveDriver swerveDriver,
        XboxPositionAccessible controller) {
        this.swerveDriver = swerveDriver;
        this.controller = controller;
        this.xLimiter = new SlewRateLimiter(SwerveConstants.kTeleDriveMaxAccelerationUnitsPerSecond);
        this.yLimiter = new SlewRateLimiter(SwerveConstants.kTeleDriveMaxAccelerationUnitsPerSecond);
        this.turningLimiter = new SlewRateLimiter(SwerveConstants.kTeleDriveMaxAngularAccelerationUnitsPerSecond);
        addRequirements(swerveDriver);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        // 1. Get real-time joystick inputs
        SwerveMovement joystickMovement = SwerveMovement.getMovement(controller, false);
        double xSpeed1 = joystickMovement.forwardBackwardSpeed;
        double ySpeed1 = joystickMovement.sideToSideSpeed;
        double turningSpeed1 = joystickMovement.rotationSpeed;

        SmartDashboard.putString("10: Joystick input", String.format("X = %.2f; Y = %.2f, Turn = %.2f", xSpeed1, ySpeed1, turningSpeed1));

        // 2. Apply deadband
        double xSpeed2 = Math.abs(xSpeed1) > OIConstants.kDeadband ? xSpeed1 : 0.0;
        double ySpeed2 = Math.abs(ySpeed1) > OIConstants.kDeadband ? ySpeed1 : 0.0;
        double turningSpeed2 = Math.abs(turningSpeed1) > OIConstants.kDeadband ? turningSpeed1 : 0.0;

        SmartDashboard.putString("09: Apply deadpan", String.format("X = %.2f; Y = %.2f, Turn = %.2f", xSpeed2, ySpeed2, turningSpeed2));

        // 3. Make the driving smoother
        double xSpeed3 = xLimiter.calculate(xSpeed2) * SwerveConstants.kTeleDriveMaxSpeedMetersPerSecond;
        double ySpeed3 = yLimiter.calculate(ySpeed2) * SwerveConstants.kTeleDriveMaxSpeedMetersPerSecond;
        double turningSpeed3 = turningLimiter.calculate(turningSpeed2)
                * SwerveConstants.kTeleDriveMaxAngularSpeedRadiansPerSecond;

        SmartDashboard.putString("08: Chassis velocity", String.format("X = %.2f; Y = %.2f, Turn = %.2f", xSpeed3, ySpeed3, turningSpeed3));

        // 5. Output each module states to wheels
        swerveDriver.setChassisSpeed(xSpeed3, ySpeed3, turningSpeed3);
    }

    @Override
    public boolean isFinished() {
        return false;
    }


    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: ResetModulePositions...");
        } else {
            Logger.ending("Ending Command: ResetModulePositions...");
        }
        swerveDriver.stopModules();
    }
}
