package frc.robot.commands.pickerupper;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;

import frc.robot.subsystems.PickerUpper;


public class RaiseArms extends CommandBase {

    private PickerUpper m_pickup;

    public RaiseArms(PickerUpper pickup) {
        Logger.setup("Constructing Command: RaiseArms...");

        // Add given subsystem requirements
        m_pickup = pickup;
        addRequirements(m_pickup);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: RaiseArms...");

        m_pickup.raiseArms();
    }

    //real code
    @Override
    public void execute() {

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
            Logger.ending("Interrupting Command: RaiseArms...");
        } else {
            Logger.ending("Ending Command: RaiseArms...");
        }
    }

}
