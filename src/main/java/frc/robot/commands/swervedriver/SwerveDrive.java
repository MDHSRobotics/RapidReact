
package frc.robot.commands.swervedriver;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.oi.controllers.JoystickPositionAccessible;
//import frc.robot.oi.controllers.XboxPositionAccessible;
import frc.robot.oi.movements.SwerveMovement;
import frc.robot.subsystems.SwerveDriver;
import frc.robot.subsystems.constants.SwerveConstants;
import frc.robot.subsystems.constants.SwerveConstants.OIConstants;


public class SwerveDrive extends CommandBase {

    private final SwerveDriver m_swerveDriver;
    private final JoystickPositionAccessible m_controller;
    //private final XboxPositionAccessible m_controller;
    private final SlewRateLimiter m_xLimiter, m_yLimiter, m_turningLimiter;

    public SwerveDrive (SwerveDriver swerveDriver, JoystickPositionAccessible controller) {
        Logger.setup("Constructing Command: SwerveDrive...");

        m_swerveDriver = swerveDriver;
        m_controller = controller;
        m_xLimiter = new SlewRateLimiter(SwerveConstants.kTeleDriveMaxAccelerationUnitsPerSecond);
        m_yLimiter = new SlewRateLimiter(SwerveConstants.kTeleDriveMaxAccelerationUnitsPerSecond);
        m_turningLimiter = new SlewRateLimiter(SwerveConstants.kTeleDriveMaxAngularAccelerationUnitsPerSecond);

        addRequirements(m_swerveDriver);
    }

    // public SwerveDrive (SwerveDriver swerveDriver, XboxPositionAccessible xboxontroller) {
    //     Logger.setup("Constructing Command: SwerveDrive...");

    //     m_swerveDriver = swerveDriver;
    //     m_controller = controller;
    //     m_xLimiter = new SlewRateLimiter(SwerveConstants.kTeleDriveMaxAccelerationUnitsPerSecond);
    //     m_yLimiter = new SlewRateLimiter(SwerveConstants.kTeleDriveMaxAccelerationUnitsPerSecond);
    //     m_turningLimiter = new SlewRateLimiter(SwerveConstants.kTeleDriveMaxAngularAccelerationUnitsPerSecond);

    //     addRequirements(m_swerveDriver);
    // }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: SwerveDrive...");
    }

    @Override
    public void execute() {
        // 1. Get real-time joystick inputs
        SwerveMovement joystickMovement = SwerveMovement.getMovement(m_controller, false);
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
        double xSpeed3 = m_xLimiter.calculate(xSpeed2) * SwerveConstants.kTeleDriveMaxSpeedMetersPerSecond;
        double ySpeed3 = m_yLimiter.calculate(ySpeed2) * SwerveConstants.kTeleDriveMaxSpeedMetersPerSecond;
        double turningSpeed3 = m_turningLimiter.calculate(turningSpeed2) * SwerveConstants.kTeleDriveMaxAngularSpeedRadiansPerSecond;

        SmartDashboard.putString("08: Chassis velocity", String.format("X = %.2f; Y = %.2f, Turn = %.2f", xSpeed3, ySpeed3, turningSpeed3));

        // 5. Output each module states to wheels
        m_swerveDriver.setChassisSpeed(xSpeed3, -ySpeed3, turningSpeed3);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: SwerveDrive...");
        } else {
            Logger.ending("Ending Command: SwerveDrive...");
        }
        m_swerveDriver.stopModules();
    }

}
