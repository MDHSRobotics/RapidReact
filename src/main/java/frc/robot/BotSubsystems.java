package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.*;

// Contains singleton instances of all the subsystems on the robot.
public class BotSubsystems {

    public static PickerUpper pickerupper;
    public static SwerveDriver swerveDriver;
    public static PistonShooter pistonShooter;
    public static Lighter lighter;

    // Initialize all robot subsystems
    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        swerveDriver = new SwerveDriver();
        pickerupper = new PickerUpper();
        pistonShooter = new PistonShooter();
        lighter = new Lighter();
    }

    // Set all the subsystem "teleop" default commands
    public static void setTeleopDefaultCommands() {

        // SwerveDriver
        Logger.setup("SwerveDriver Teleop Default Command -> SwerveDrive...");
        swerveDriver.setDefaultCommand(BotCommands.swerveDrive);

        // Pickup
        Logger.setup("PickerUpper Teleop Default Command -> StopPickup...");
        pickerupper.setDefaultCommand(BotCommands.stopPickup);

        // Piston Shooter
        Logger.setup("PistonShooter Teleop Default Command -> FeedPistons ...");
        pistonShooter.setDefaultCommand(BotCommands.feedPistons);

        // Lighter
        Logger.setup("Lighter Teleop Default Command -> LightByDistance ...");
        lighter.setDefaultCommand(BotCommands.lightByDistance);

    }

}
