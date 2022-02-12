
package frc.robot.commands.swervedriver;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.oi.controllers.XboxPositionAccessible;
import frc.robot.oi.movements.SwerveMovement;
import frc.robot.subsystems.SwerveDriver;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import frc.robot.subsystems.constants.SwerveConstants;
import frc.robot.subsystems.constants.SwerveConstants.OIConstants;


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
        SwerveMovement move = SwerveMovement.getMovement(controller, false);
        double xSpeed = move.forwardBackwardSpeed;
        double ySpeed = move.sideToSideSpeed;
        double turningSpeed = move.rotationSpeed;

        // 2. Apply deadband
        xSpeed = Math.abs(xSpeed) > OIConstants.kDeadband ? xSpeed : 0.0;
        ySpeed = Math.abs(ySpeed) > OIConstants.kDeadband ? ySpeed : 0.0;
        turningSpeed = Math.abs(turningSpeed) > OIConstants.kDeadband ? turningSpeed : 0.0;

        // 3. Make the driving smoother
        xSpeed = xLimiter.calculate(xSpeed) * SwerveConstants.kTeleDriveMaxSpeedMetersPerSecond;
        ySpeed = yLimiter.calculate(ySpeed) * SwerveConstants.kTeleDriveMaxSpeedMetersPerSecond;
        turningSpeed = turningLimiter.calculate(turningSpeed)
                * SwerveConstants.kTeleDriveMaxAngularSpeedRadiansPerSecond;

        // 4. Construct desired chassis speeds
        ChassisSpeeds chassisSpeeds;
        if (fieldOrientedFunction) {
            // Relative to field
            chassisSpeeds = ChassisSpeeds.fromFieldRelativeSpeeds(
                    xSpeed, ySpeed, turningSpeed, swerveDriver.getRotation2d());
        } else {
            // Relative to robot
            chassisSpeeds = new ChassisSpeeds(xSpeed, ySpeed, turningSpeed);
        }

        // 5. Convert chassis speeds to individual module states
        SwerveModuleState[] moduleStates = SwerveConstants.kDriveKinematics.toSwerveModuleStates(chassisSpeeds);

        // 6. Output each module states to wheels
        swerveDriver.setModuleStates(moduleStates);
    }

    @Override
    public void end(boolean interrupted) {
        swerveDriver.stopModules();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
