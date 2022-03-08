package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotSubsystems;
import frc.robot.commands.swervedriver.TimedSwerve;
import frc.robot.subsystems.constants.AutoConstants;

public class TurnAround extends SequentialCommandGroup {
    
    public TurnAround() {
        
        addCommands(
                // turn around 180 degrees 
                new TimedSwerve(BotSubsystems.swerveDriver, 0.0, 0.0, Math.PI, AutoConstants.timePerCommand)
        );
    }

}