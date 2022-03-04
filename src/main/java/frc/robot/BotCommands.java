package frc.robot;

import frc.robot.commands.deliverer.*;
import frc.robot.commands.gate.*;
import frc.robot.commands.pickupper.*;
import frc.robot.commands.climber.*;
import frc.robot.commands.sensors.TurnOffLed;
import frc.robot.commands.sensors.TurnOnLed;
import frc.robot.commands.shooter.*;
import frc.robot.consoles.Logger;
import frc.robot.commands.swervedriver.*;




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

    // Limelight
    public static TurnOffLed turnOffLed;
    public static TurnOnLed turnOnLed;

    // Pathweaver


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

        // Limelight
        turnOnLed = new TurnOnLed();
        turnOffLed = new TurnOffLed();
    }

}
