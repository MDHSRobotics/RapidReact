package frc.robot.commands.swervedriver;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotSubsystems;
import frc.robot.commands.pickupper.SpinPickup;
import frc.robot.commands.shooter.Shoot;
import frc.robot.subsystems.Pickup;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.SwerveDriver;
import edu.wpi.first.math.util.*;

public class AutoShootModeOne extends SequentialCommandGroup {
    private static final SwerveDriver m_SwerveDriver = BotSubsystems.swerveDriver;
    private static final Shooter m_shooter = BotSubsystems.shooter;
    private static final Pickup m_pickup = BotSubsystems.pickup;

    /**
     * @param osd The optimized desired shooting distance in feet
     * @param timePerCommand time in seconds for each movement command to set its velocity
    **/
    public AutoShootModeOne(double osd, double timePerCommand) {
        double radiusOfBalltoCenterMeters = Units.feetToMeters(12.75);
        double osdMeters = Units.feetToMeters(osd);
        double driveSpeedMPS = (radiusOfBalltoCenterMeters - osdMeters) / (timePerCommand - 0.5);
        double extraMoveDistance = Units.feetToMeters(2) / (timePerCommand - 0.5);
            addCommands(
                new Shoot(m_shooter),
                new TimedSwerve(m_SwerveDriver, -driveSpeedMPS, 0.0, 0.0, timePerCommand),
                new SpinPickup(m_pickup),
                new TimedSwerve(m_SwerveDriver, -extraMoveDistance, 0.0, 0.0, timePerCommand),
                new TimedSwerve(m_SwerveDriver, extraMoveDistance + driveSpeedMPS, 0.0, 0.0, timePerCommand),
                new Shoot(m_shooter)
            );
    }

}