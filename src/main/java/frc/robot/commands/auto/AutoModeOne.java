package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotSubsystems;
import frc.robot.commands.pickerupper.*;
import frc.robot.commands.shooter.Shoot;
import frc.robot.commands.shooter.TogglePistons;
import frc.robot.commands.swervedriver.TimedSwerve;
import frc.robot.subsystems.constants.AutoConstants;
import edu.wpi.first.math.util.*;

public class AutoModeOne extends SequentialCommandGroup {
    /**
     * @param optimalShootingDistance The optimized desired shooting distance in feet
     * @param timePerCommand time in seconds for each movement command to set its velocity
    **/
    public AutoModeOne() {
        double driveSpeedMPS = (AutoConstants.radiusOfBalltoCenterMeters - AutoConstants.optimalShootingDistanceMeters) / (AutoConstants.timePerCommand - 0.5);
        double extraMoveDistance = Units.feetToMeters(2) / (AutoConstants.timePerCommand - 0.5);
            addCommands(
                // shoot pre-loaded ball
                new TogglePistons(BotSubsystems.pistonShooter),

                // lower pickup arms

                // drive back to ball
                new TimedSwerve(BotSubsystems.swerveDriver, -driveSpeedMPS, 0.0, 0.0, AutoConstants.timePerCommand),

                // pickup ball
                // new SpinPickup(m_pickup),

                // load ball

                // drive foward to shoot location
                new TimedSwerve(BotSubsystems.swerveDriver, -extraMoveDistance, 0.0, 0.0, AutoConstants.timePerCommand),
                new TimedSwerve(BotSubsystems.swerveDriver, extraMoveDistance + driveSpeedMPS, 0.0, 0.0, AutoConstants.timePerCommand),

                // shoot
                new TogglePistons(BotSubsystems.pistonShooter)
            );
    }

}