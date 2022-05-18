package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.*;

// Contains singleton instances of all the subsystems on the robot.
public class BotSubsystems {

    public static RightClimber rightClimber;
    public static LeftClimber leftClimber;
    public static SwerveDriver swerveDriver;
    public static PistonShooter pistonShooter;
    public static Delivery delivery;
    public static Pickup pickup;
    public static Lighter lighter;
    public static SparkMaxTester sparkMaxTester;

    // Initialize all robot subsystems
    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        swerveDriver = new SwerveDriver();
        rightClimber = new RightClimber();
        leftClimber = new LeftClimber();
        pistonShooter = new PistonShooter();
        pickup = new Pickup();
        delivery = new Delivery();
        lighter = new Lighter();
        sparkMaxTester = new SparkMaxTester();
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

        // Pickup
        Logger.setup("PistonShooter Teleop Default Command -> StopPickup ...");
        pickup.setDefaultCommand(BotCommands.stopPickup);

        // Delivery
        Logger.setup("PistonShooter Teleop Default Command -> StopDelivery ...");
        delivery.setDefaultCommand(BotCommands.stopDelivery);

        // Lighter
        Logger.setup("Lighter Teleop Default Command -> LightByDistance ...");
        lighter.setDefaultCommand(BotCommands.lightByDistance);

    }

}
