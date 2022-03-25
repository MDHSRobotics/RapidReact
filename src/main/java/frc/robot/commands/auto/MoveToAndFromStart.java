package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotSubsystems;
import frc.robot.commands.swervedriver.TimedSwerve;
import frc.robot.subsystems.constants.AutoConstants;
import frc.robot.subsystems.constants.SwerveConstants;

public class MoveToAndFromStart extends SequentialCommandGroup {

    public MoveToAndFromStart () {
        double driveSpeedMPS = 0.3; //(AutoConstants.radiusOfBalltoCenterMeters - AutoConstants.optimalShootingDistanceMeters - AutoConstants.robotOffsetDistance) / (AutoConstants.timePerCommand - SwerveConstants.kDriveRampTime);

        addCommands(
                // drive to ball
                new TimedSwerve(BotSubsystems.swerveDriver, -driveSpeedMPS, 0.0, 0.0, AutoConstants.timePerCommand));
    }

}