package frc.robot.commands.pickerupper;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;

import frc.robot.subsystems.PickerUpper;


public class ToggleArms extends CommandBase {

    private PickerUpper m_pickup;

    public ToggleArms(PickerUpper pickup) {
        Logger.setup("Constructing Command: ToggleArms...");

        // Add given subsystem requirements
        m_pickup = pickup;
        addRequirements(m_pickup);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ToggleArms...");

    }

    //real code
    @Override
    public void execute() {
       m_pickup.toggleArms();
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
            Logger.ending("Interrupting Command: ToggleArms...");
        } else {
            Logger.ending("Ending Command: ToggleArms...");
        }
    }

}
