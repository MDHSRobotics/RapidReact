package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.*;

// Contains singleton instances of all the subsystems on the robot.
public class BotSubsystems {

    public static RightClimber rightClimber;
    public static LeftClimber leftClimber;
    public static SwerveDriver swerveDriver;
    public static PistonShooter pistonShooter;
    public static Lighter lighter;

    // Initialize all robot subsystems
    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        swerveDriver = new SwerveDriver();
        rightClimber = new RightClimber();
        leftClimber = new LeftClimber();
        pistonShooter = new PistonShooter();
        lighter = new Lighter();
    }

    // Set all the subsystem "teleop" default commands
    public static void setTeleopDefaultCommands() {

        // SwerveDriver
        Logger.setup("SwerveDriver Teleop Default Command -> SwerveDrive...");
        swerveDriver.setDefaultCommand(BotCommands.swerveDrive);

        // Climber
        Logger.setup("PickerUpper Teleop Default Command -> RightClimber...");
        rightClimber.setDefaultCommand(BotCommands.stopRightClimber);

        Logger.setup("PickerUpper Teleop Default Command -> LeftClimber...");
        leftClimber.setDefaultCommand(BotCommands.stopLeftClimber);

        // Piston Shooter
        Logger.setup("PistonShooter Teleop Default Command -> FeedPistons ...");
        pistonShooter.setDefaultCommand(BotCommands.feedPistons);

        // Lighter
        Logger.setup("Lighter Teleop Default Command -> LightByDistance ...");
        lighter.setDefaultCommand(BotCommands.lightByDistance);

    }

}
