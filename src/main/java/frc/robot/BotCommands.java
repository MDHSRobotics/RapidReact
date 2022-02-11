
package frc.robot;

import frc.robot.commands.deliverer.*;
import frc.robot.commands.gate.*;
import frc.robot.commands.PickUp.*;
import frc.robot.commands.sensors.TurnOffLed;
import frc.robot.commands.sensors.TurnOnLed;
import frc.robot.commands.shooter.*;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.PickerUpper;
import frc.robot.commands.swervedriver.*;




// Contains singleton instances of all the commands on the robot.
public class BotCommands {

	// SwerveDrive
    public static SwerveDrive swerveDrive;
    public static RotateSwerveWheelsToStart rotateSwerveWheelsToStart;
    public static ResetModulePositions resetModulePositions;

    // Pickup
    public static PickerUpper PickUp;
    public static ClawDown clawdown;
    public static ClawUp clawup;
    public static CloseClaw closeclaw;
    public static OpenClaw openclaw;
    public static StopHorizontalClaw stophorizontalclaw;
    public static StopVerticalClaw stopverticalclaw;


    // Delivery
    public static SpinDelivery spinDelivery;
    public static StopDelivery stopDelivery;

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
        clawdown = new ClawDown(BotSubsystems.pickerupper);
        clawup = new ClawUp(BotSubsystems.pickerupper);
        closeclaw = new CloseClaw(BotSubsystems.pickerupper);
        openclaw = new OpenClaw(BotSubsystems.pickerupper);
        stophorizontalclaw = new StopHorizontalClaw(BotSubsystems.pickerupper);
        stopverticalclaw = new StopVerticalClaw(BotSubsystems.pickerupper);

        // SwerveDriver
        swerveDrive = new SwerveDrive(BotSubsystems.swerveDriver, BotControllers.xbox);
        rotateSwerveWheelsToStart = new RotateSwerveWheelsToStart(BotSubsystems.swerveDriver);
        resetModulePositions = new ResetModulePositions(BotSubsystems.swerveDriver);

        // Delivery
        spinDelivery = new SpinDelivery(BotSubsystems.delivery);
        stopDelivery = new StopDelivery(BotSubsystems.delivery);

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
