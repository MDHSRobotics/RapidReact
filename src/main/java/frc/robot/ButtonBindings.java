package frc.robot;

import frc.robot.consoles.Logger;

// Configures all the button->command bindings for the robot.
public class ButtonBindings {

    // Configure xbox buttons
    public static void configureXbox() {
        Logger.setup("Configure Buttons -> Xbox Controller...");

        // SwerveDrive
        BotControllers.xbox.btnStart.whenPressed(BotCommands.toggleDriverOrientation);
        BotControllers.xbox.btnA.whenPressed(BotCommands.driveBox);

        // Pickup
        BotControllers.xbox.btnX.whileHeld(BotCommands.toggleGrabber);
        BotControllers.xbox.btnY.whileHeld(BotCommands.toggleArms);

        // Shoot
        BotControllers.xbox.btnDpadUp.whileHeld(BotCommands.togglePistons);
    }

}
