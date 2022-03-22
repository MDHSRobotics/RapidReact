package frc.robot;

import frc.robot.commands.lighter.*;
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


    //Climber
    public static RaiseClawsRight raiseClawsRight;
    public static LowerClawsRight lowerClawsRight;
    public static RaiseClawsLeft raiseClawsLeft;
    public static LowerClawsLeft lowerClawsLeft;
    public static StopRightClimber stopRightClimber;
    public static StopLeftClimber stopLeftClimber;

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


        // Climber
        raiseClawsRight = new RaiseClawsRight(BotSubsystems.rightClimber);
        lowerClawsRight = new LowerClawsRight(BotSubsystems.rightClimber);  
        raiseClawsLeft = new RaiseClawsLeft(BotSubsystems.leftClimber);
        lowerClawsLeft = new LowerClawsLeft(BotSubsystems.leftClimber);
        stopRightClimber = new StopRightClimber(BotSubsystems.rightClimber);
        stopLeftClimber = new StopLeftClimber(BotSubsystems.leftClimber);

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
