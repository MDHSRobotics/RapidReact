package frc.robot.commands.pickup;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;

import frc.robot.subsystems.PickerUpper;


public class ToggleGrabber extends CommandBase {

    private PickerUpper m_pickup;

    public ToggleGrabber(PickerUpper pickup) {
        Logger.setup("Constructing Command: ToggleGrabber...");

        // Add given subsystem requirements
        m_pickup = pickup;
        addRequirements(m_pickup);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ToggleGrabber...");

    }

    //real code
    @Override
    public void execute() {
       m_pickup.toggleGrabber();
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
            Logger.ending("Interrupting Command: ToggleGrabber...");
        } else {
            Logger.ending("Ending Command: ToggleGrabber...");
        }
    }

}
