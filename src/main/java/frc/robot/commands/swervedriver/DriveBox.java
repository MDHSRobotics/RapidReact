package frc.robot.commands.swervedriver;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.BotSubsystems;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.constants.SwerveConstants;


public class DriveBox extends SequentialCommandGroup {
    static final double driveSpeed = SwerveConstants.kPhysicalMaxSpeedMetersPerSecond * 0.25;

    static final double duration = 0.5;

    public DriveBox() {
        Logger.setup("Constructing SequentialCommandGroup: DriveBox...");

        addCommands(
            new TimedSwerve(BotSubsystems.swerveDriver, driveSpeed, 0.0, 0.0, duration),
            new TimedSwerve(BotSubsystems.swerveDriver, 0.0, driveSpeed, 0.0, duration),
            new TimedSwerve(BotSubsystems.swerveDriver, -driveSpeed, 0.0, 0.0, duration),
            new TimedSwerve(BotSubsystems.swerveDriver, 0.0, -driveSpeed, 0.0, duration)
        );
    }

}