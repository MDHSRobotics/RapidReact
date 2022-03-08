package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotSubsystems;
import frc.robot.commands.swervedriver.TimedSwerve;
import frc.robot.subsystems.constants.AutoConstants;
import edu.wpi.first.math.util.*;

public class MoveToStart extends SequentialCommandGroup {
    
    public MoveToStart () {
        double driveSpeedMPS = (AutoConstants.radiusOfBalltoCenterMeters - AutoConstants.optimalShootingDistanceMeters)
                / (AutoConstants.timePerCommand - 0.5);
        double extraMoveDistance = Units.feetToMeters(2) / (AutoConstants.timePerCommand - 0.5);
        
        addCommands(
                // drive foward to shoot location
                new TimedSwerve(BotSubsystems.swerveDriver, -extraMoveDistance, 0.0, 0.0, AutoConstants.timePerCommand),
                new TimedSwerve(BotSubsystems.swerveDriver, extraMoveDistance + driveSpeedMPS, 0.0, 0.0,
                        AutoConstants.timePerCommand));
    }

}