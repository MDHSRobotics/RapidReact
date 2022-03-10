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

        // Pickup
        BotControllers.xbox.btnDpadLeft.whileHeld(BotCommands.grabBall);
        BotControllers.xbox.btnDpadRight.whileHeld(BotCommands.dropBall);
        BotControllers.xbox.btnDpadUp.whileHeld(BotCommands.raiseArms);
        BotControllers.xbox.btnDpadDown.whileHeld(BotCommands.lowerArms);

        //Climb
        BotControllers.xbox.btnY.whileHeld(BotCommands.raiseClaws);
        BotControllers.xbox.btnA.whileHeld(BotCommands.lowerClaws);

        // Shoot
        BotControllers.xbox.btnX.whenPressed(BotCommands.togglePistons);
    }

}
