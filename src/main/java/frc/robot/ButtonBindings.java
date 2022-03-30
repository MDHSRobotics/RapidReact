package frc.robot;

import frc.robot.consoles.Logger;

// Configures all the button->command bindings for the robot.
public class ButtonBindings {

    // Configure xbox buttons
    public static void configureXbox() {
        Logger.setup("Configure Buttons -> Xbox Controller...");

        // SwerveDrive
        BotControllers.xbox.btnStart.whenPressed(BotCommands.toggleDriverOrientation);
        BotControllers.xbox.btnB.whenPressed(BotCommands.driveBox);

        //Climb
        BotControllers.xbox.btnBumperLeft.whileHeld(BotCommands.raiseClawsRight);
        BotControllers.xbox.btnA.whileHeld(BotCommands.lowerClawsRight);
        BotControllers.xbox.btnBumperRight.whileHeld(BotCommands.raiseClawsLeft);
        BotControllers.xbox.btnY.whileHeld(BotCommands.lowerClawsLeft);
        BotControllers.xbox.btnBumperLeft.whenReleased(BotCommands.stopLeftClimber);
        BotControllers.xbox.btnBumperRight.whenReleased(BotCommands.stopRightClimber);
        BotControllers.xbox.btnA.whenReleased(BotCommands.stopRightClimber);
        BotControllers.xbox.btnY.whenReleased(BotCommands.stopLeftClimber);

        // Shoot
        BotControllers.xbox.btnX.whenPressed(BotCommands.togglePistons);

        // Pickup
        BotControllers.xbox.btnDpadUp.whileHeld(BotCommands.spinPickup);

        // Delivery
        BotControllers.xbox.btnDpadLeft.whileHeld(BotCommands.spinDelivery);

    }

    public static void configureJoystick() {
        // SwerveDrive
        BotControllers.jstick.jstickBtn7.whenPressed(BotCommands.toggleDriverOrientation);
        BotControllers.jstick.jstickBtn8.whenPressed(BotCommands.driveBox);

        //Climb
        BotControllers.jstick.jstickBtn5.whileHeld(BotCommands.raiseClawsRight);
        BotControllers.jstick.jstickBtn3.whileHeld(BotCommands.lowerClawsRight);
        BotControllers.jstick.jstickBtn6.whileHeld(BotCommands.raiseClawsLeft);
        BotControllers.jstick.jstickBtn4.whileHeld(BotCommands.lowerClawsLeft);
        BotControllers.jstick.jstickBtn5.whenReleased(BotCommands.stopLeftClimber);
        BotControllers.jstick.jstickBtn3.whenReleased(BotCommands.stopRightClimber);
        BotControllers.jstick.jstickBtn6.whenReleased(BotCommands.stopRightClimber);
        BotControllers.jstick.jstickBtn4.whenReleased(BotCommands.stopLeftClimber);

        // Shoot
        BotControllers.jstick.jstickBtn1.whenPressed(BotCommands.togglePistons);

        // Pickup
        BotControllers.jstick.jstickBtn9.whileHeld(BotCommands.spinPickup);

        // Delivery
        BotControllers.jstick.jstickBtn10.whileHeld(BotCommands.spinDelivery);
    }

}
