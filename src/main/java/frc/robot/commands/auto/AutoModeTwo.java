package frc.robot.commands.auto;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotSubsystems;
import frc.robot.commands.shooter.Shoot;
import frc.robot.commands.swervedriver.TimedSwerve;
import frc.robot.subsystems.PickerUpper;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.SwerveDriver;

public class AutoModeTwo extends SequentialCommandGroup {
    
    public AutoModeTwo() {
        /* double radiusOfBalltoCenterMeters = Units.feetToMeters(12.75);
        double osdMeters = Units.feetToMeters(osd);
        double driveSpeedMPS = (radiusOfBalltoCenterMeters - osdMeters) / (timePerCommand - 0.5);
        double extraMoveDistance = Units.feetToMeters(2) / (timePerCommand - 0.5);
        double turnDistanceMeters = Units.feetToMeters(0.390);
        double turnDistanceVelocity = turnDistanceMeters / (timePerCommand - 0.5);
        double rotationInDegrees = 33.5; //we want this to move counter-clockwise
            addCommands(
                new Shoot(m_shooter),
                new TimedSwerve(m_SwerveDriver, 0.0, -turnDistanceVelocity, -rotationInDegrees, timePerCommand),
                new TimedSwerve(m_SwerveDriver, -driveSpeedMPS, 0.0, 0.0, timePerCommand),
                new SpinPickup(m_pickup),
                new TimedSwerve(m_SwerveDriver, -extraMoveDistance, 0.0, 0.0, timePerCommand),
                new TimedSwerve(m_SwerveDriver, extraMoveDistance + driveSpeedMPS, 0.0, 0.0, timePerCommand),
                new Shoot(m_shooter)
            ); */
    }

}