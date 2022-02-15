package frc.robot.commands.PickUp;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;

import frc.robot.subsystems.PickerUpper;


public class StopPickup extends CommandBase {

    private PickerUpper m_pickup;

    public StopPickup(PickerUpper pickup) {
        Logger.setup("Constructing Command: StopPickup...");

        // Add given subsystem requirements
        m_pickup = pickup;
        addRequirements(m_pickup);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StopPickup...");

    }

    //real code
    @Override
    public void execute() {
       m_pickup.stopPickup();
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
            Logger.ending("Interrupting Command: StopPickup...");
        } else {
            Logger.ending("Ending Command: StopPickup...");
        }
    }

}
