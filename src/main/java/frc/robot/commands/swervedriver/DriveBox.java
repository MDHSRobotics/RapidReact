package frc.robot.commands.swervedriver;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotSubsystems;
import frc.robot.subsystems.constants.SwerveConstants;

public class DriveBox extends SequentialCommandGroup {
    static final double driveSpeed = SwerveConstants.kPhysicalMaxSpeedMetersPerSecond * 0.75;

    static final double duration = 1.0;

    public DriveBox() {
            addCommands(
                new TimedSwerve(BotSubsystems.swerveDriver, driveSpeed, 0.0, 0.0, duration),
                new TimedSwerve(BotSubsystems.swerveDriver, 0.0, driveSpeed, 0.0, duration),
                new TimedSwerve(BotSubsystems.swerveDriver, -driveSpeed, 0.0, 0.0, duration),
                new TimedSwerve(BotSubsystems.swerveDriver, 0.0, -driveSpeed, 0.0, duration)
            );
    }

}