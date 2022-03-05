package frc.robot;

import frc.robot.commands.deliverer.*;
import frc.robot.commands.gate.*;
import frc.robot.commands.pickerupper.*;
import frc.robot.commands.climber.*;
import frc.robot.commands.sensors.TurnOffLed;
import frc.robot.commands.sensors.TurnOnLed;
import frc.robot.commands.shooter.*;
import frc.robot.consoles.Logger;
import frc.robot.commands.swervedriver.*;
import frc.robot.commands.auto.*;


// Contains singleton instances of all the commands on the robot.
public class BotCommands {

	// SwerveDrive
    public static SwerveDrive swerveDrive;
    public static ResetModulePositions resetModulePositions;
    public static SwerveRotateModule1 swerveRotateModule1;
    public static ToggleDriverOrientation toggleDriverOrientation;
    public static DriveBox driveBox;

    // Pickup
    public static StopPickup stopPickup;
    public static ToggleGrabber toggleGrabber;
    public static ToggleArms toggleArms;


    // Delivery
    public static SpinDelivery spinDelivery;
    public static StopDelivery stopDelivery;

    //Climber
    public static StopClimber stopClimber;
    public static RaiseArms raiseArms;
    public static LowerArms lowerArms;

    // Gate
    public static ToggleGate toggleGate;
    public static FeedGate feedGate;

    // Shoot
    public static Shoot shoot;
    public static StopShoot stopShoot;
    public static ResetShoot resetShoot;
    public static FeedPistons feedPistons;
    public static TogglePistons togglePistons;

    // Limelight
    public static TurnOffLed turnOffLed;
    public static TurnOnLed turnOnLed;

    // Autonomous
    public static AutoModeOne autoCommandOne;
    public static AutoModeTwo autoCommandTwo;
    public static AutoModeThree autoCommandThree;


    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

        // Pickup
        stopPickup = new StopPickup(BotSubsystems.pickerupper);
        toggleGrabber = new ToggleGrabber(BotSubsystems.pickerupper);
        toggleArms = new ToggleArms(BotSubsystems.pickerupper);

        // SwerveDriver
        swerveDrive = new SwerveDrive(BotSubsystems.swerveDriver, BotControllers.xbox);
        resetModulePositions = new ResetModulePositions(BotSubsystems.swerveDriver);
        swerveRotateModule1 = new SwerveRotateModule1(BotSubsystems.swerveDriver);
        toggleDriverOrientation = new ToggleDriverOrientation(BotSubsystems.swerveDriver);
        driveBox = new DriveBox();

        // Delivery
        spinDelivery = new SpinDelivery(BotSubsystems.delivery);
        stopDelivery = new StopDelivery(BotSubsystems.delivery);

        //climber
        stopClimber = new StopClimber(BotSubsystems.climber);
        raiseArms = new RaiseArms(BotSubsystems.climber);
        lowerArms = new LowerArms(BotSubsystems.climber);

        // Gate
        toggleGate = new ToggleGate(BotSubsystems.gate);
        feedGate = new FeedGate(BotSubsystems.gate);

        // Shooter
        shoot = new Shoot(BotSubsystems.shooter);
        stopShoot = new StopShoot(BotSubsystems.shooter);
        resetShoot = new ResetShoot(BotSubsystems.shooter);
        feedPistons = new FeedPistons(BotSubsystems.pistonShooter);
        togglePistons = new TogglePistons(BotSubsystems.pistonShooter);

        // Limelight
        turnOnLed = new TurnOnLed();
        turnOffLed = new TurnOffLed();

        // Autonomous
        autoCommandOne = new AutoModeOne();
        autoCommandTwo = new AutoModeTwo();
        autoCommandThree = new AutoModeThree();
    }

}
