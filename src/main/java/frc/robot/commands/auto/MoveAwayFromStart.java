package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotSubsystems;
import frc.robot.commands.swervedriver.TimedSwerve;
import frc.robot.subsystems.constants.AutoConstants;

public class MoveAwayFromStart extends SequentialCommandGroup {
    
    public MoveAwayFromStart () {
        double driveSpeedMPS = (AutoConstants.radiusOfBalltoCenterMeters - AutoConstants.optimalShootingDistanceMeters)
                / (AutoConstants.timePerCommand - 0.5);
        
        addCommands(
                // drive back to ball
                new TimedSwerve(BotSubsystems.swerveDriver, -driveSpeedMPS, 0.0, 0.0, AutoConstants.timePerCommand));
    }

}