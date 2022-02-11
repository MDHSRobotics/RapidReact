package frc.robot.commands.PickUp;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;

import frc.robot.subsystems.PickerUpper;


public class StopVerticalClaw extends CommandBase {

    private PickerUpper m_pickup;

    // TODO: Make these constructor parameters. Use overloading for these default values.

    public StopVerticalClaw(PickerUpper pickup) {
        Logger.setup("Constructing Command: StopVerticalClaw...");

        // Add given subsystem requirements
        m_pickup = pickup;
        addRequirements(m_pickup);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StopVerticalClaw...");

    }

    //real code
    @Override
    public void execute() {
       m_pickup.verticalStop();
    }

    // This command continues until it cycles through the set number of cycles
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: StopVerticalClaw...");
        } else {
            Logger.ending("Ending Command: StopVerticalClaw...");
        }
    }

}
