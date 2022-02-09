package frc.robot.commands.PickUp;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
//import frc.robot.subsystems.Lighter;
import frc.robot.subsystems.PickerUpper;


public class CloseClaw extends CommandBase {

    private PickerUpper m_pickup;

    // TODO: Make these constructor parameters. Use overloading for these default values.

    public CloseClaw(PickerUpper pickup) {
        Logger.setup("Constructing Command: CloseClaw...");

        // Add given subsystem requirements
        m_pickup = pickup;
        addRequirements(m_pickup);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: CloseClaw...");

    }

    //real code
    @Override
    public void execute() {
       m_pickup.closeHorizontal();
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
            Logger.ending("Interrupting Command: CloseClaw...");
        } else {
            Logger.ending("Ending Command: CloseClaw...");
        }
    }

}
