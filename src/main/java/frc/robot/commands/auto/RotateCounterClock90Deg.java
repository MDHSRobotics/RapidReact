package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotSubsystems;
import frc.robot.commands.swervedriver.TimedSwerve;
import frc.robot.subsystems.constants.AutoConstants;
import frc.robot.subsystems.constants.SwerveConstants;

public class RotateCounterClock90Deg extends SequentialCommandGroup {

    public RotateCounterClock90Deg() {

        addCommands(
                //rotate the robot (already facing backward) 90 degrees counter-clockwise
                new TimedSwerve(BotSubsystems.swerveDriver, 0.0, 0.0, (Math.PI / 4) / (AutoConstants.timePerCommand - SwerveConstants.kDriveRampTime), AutoConstants.timePerCommand));
    }

}