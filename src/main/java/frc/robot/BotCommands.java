package frc.robot;

import frc.robot.commands.lighter.*;
import frc.robot.commands.pickerupper.*;
import frc.robot.commands.shooter.*;
import frc.robot.commands.swervedriver.*;
import frc.robot.commands.auto.*;
import frc.robot.commands.climber.*;
import frc.robot.consoles.Logger;

// Contains singleton instances of all the commands on the robot.
public class BotCommands {

	// SwerveDriver
    public static SwerveDrive swerveDrive;
    public static ToggleDriverOrientation toggleDriverOrientation;
    public static DriveBox driveBox;

    // PickerUpper
    public static StopPickup stopPickup;
    public static GrabBall grabBall;
    public static DropBall dropBall;
    public static RaiseArms raiseArms;
    public static LowerArms lowerArms;

    //Climber
    public static RaiseClaws raiseClaws;
    public static LowerClaws lowerClaws;
    public static StopClimber stopClimber;

    // Shooter
    public static FeedPistons feedPistons;
    public static TogglePistons togglePistons;

    // Lighter
    public static CycleLights cycleLights;
    public static LightByDistance lightByDistance;

    // Autonomous
    public static AutoMode1 autoCommandOne;
    public static AutoMode2 autoCommandTwo;
    public static AutoMode3 autoCommandThree;
    public static AutoSwerveTrajectory autoSwerveTrajectory;

    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

        // SwerveDriver
        swerveDrive = new SwerveDrive(BotSubsystems.swerveDriver, BotControllers.xbox);
        toggleDriverOrientation = new ToggleDriverOrientation(BotSubsystems.swerveDriver);
        driveBox = new DriveBox();

        // Pickup
        stopPickup = new StopPickup(BotSubsystems.pickerupper);
        grabBall = new GrabBall(BotSubsystems.pickerupper);
        dropBall = new DropBall(BotSubsystems.pickerupper);
        raiseArms = new RaiseArms(BotSubsystems.pickerupper);
        lowerArms = new LowerArms(BotSubsystems.pickerupper);

        // Climber
        raiseClaws = new RaiseClaws(BotSubsystems.climber);
        lowerClaws = new LowerClaws(BotSubsystems.climber);
        stopClimber = new StopClimber(BotSubsystems.climber);

        // Shooter
        feedPistons = new FeedPistons(BotSubsystems.pistonShooter);
        togglePistons = new TogglePistons(BotSubsystems.pistonShooter);

        // Lighter
        cycleLights = new CycleLights(BotSubsystems.lighter);
        lightByDistance = new LightByDistance(BotSubsystems.lighter);

        // Autonomous
        autoCommandOne = new AutoMode1();
        autoCommandTwo = new AutoMode2();
        autoCommandThree = new AutoMode3();
        }

}
