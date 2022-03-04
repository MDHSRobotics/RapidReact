package frc.robot;

import frc.robot.consoles.Logger;

// Configures all the button->command bindings for the robot.
public class ButtonBindings {

    // Configure xbox buttons
    public static void configureXbox() {
        Logger.setup("Configure Buttons -> Xbox Controller...");

        //Shoot
        BotControllers.xbox.btnB.whenPressed(BotCommands.resetModulePositions);
        BotControllers.xbox.btnDpadUp.whileHeld(BotCommands.togglePistons);

        //SwerveDrive
        BotControllers.xbox.btnStart.whenPressed(BotCommands.toggleDriverOrientation);
        BotControllers.xbox.btnA.whenPressed(BotCommands.driveBox);

        //Climber
        BotControllers.xbox.btnX.whileHeld(BotCommands.raiseArms);
        BotControllers.xbox.btnY.whileHeld(BotCommands.lowerArms);

        //pickup
        BotControllers.xbox.btnX.whileHeld(BotCommands.toggleGrabber);
        BotControllers.xbox.btnY.whileHeld(BotCommands.toggleArms);
    }

}
