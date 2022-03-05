package frc.robot;

import frc.robot.commands.lighter.*;
import frc.robot.commands.pickerupper.*;
import frc.robot.commands.shooter.*;
import frc.robot.commands.swervedriver.*;
import frc.robot.commands.auto.*;
import frc.robot.consoles.Logger;

// Contains singleton instances of all the commands on the robot.
public class BotCommands {

	// SwerveDriver
    public static SwerveDrive swerveDrive;
    public static ToggleDriverOrientation toggleDriverOrientation;
    public static DriveBox driveBox;

    // PickerUpper
    public static StopPickup stopPickup;
    public static ToggleGrabber toggleGrabber;
    public static ToggleArms toggleArms;

    // Shooter
    public static FeedPistons feedPistons;
    public static TogglePistons togglePistons;

    // Lighter
    public static CycleLights cycleLights;
    public static LightByDistance lightByDistance;

    // Autonomous
    public static AutoModeOne autoCommandOne;
    public static AutoModeTwo autoCommandTwo;
    public static AutoModeThree autoCommandThree;

    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

        // SwerveDriver
        swerveDrive = new SwerveDrive(BotSubsystems.swerveDriver, BotControllers.xbox);
        toggleDriverOrientation = new ToggleDriverOrientation(BotSubsystems.swerveDriver);
        driveBox = new DriveBox();

        // Pickup
        stopPickup = new StopPickup(BotSubsystems.pickerupper);
        toggleGrabber = new ToggleGrabber(BotSubsystems.pickerupper);
        toggleArms = new ToggleArms(BotSubsystems.pickerupper);

        // Shooter
        feedPistons = new FeedPistons(BotSubsystems.pistonShooter);
        togglePistons = new TogglePistons(BotSubsystems.pistonShooter);

        // Lighter
        cycleLights = new CycleLights(BotSubsystems.lighter);
        lightByDistance = new LightByDistance(BotSubsystems.lighter);

        // Autonomous
        autoCommandOne = new AutoModeOne();
        autoCommandTwo = new AutoModeTwo();
        autoCommandThree = new AutoModeThree();
    }

}
