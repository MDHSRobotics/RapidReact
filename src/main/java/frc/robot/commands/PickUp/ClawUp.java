
package frc.robot.commands.PickUp;

import edu.wpi.first.wpilibj2.command.CommandBase;


import frc.robot.consoles.Logger;

import frc.robot.subsystems.PickerUpper;

//import frc.robot.subsystems.Lighter;


public class ClawUp extends CommandBase {

    private PickerUpper m_pickup;

    // TODO: Make these constructor parameters. Use overloading for these default values.

    public ClawUp(PickerUpper pickup) {
        Logger.setup("Constructing Command: ClawUp...");

        // Add given subsystem requirements
        m_pickup = pickup;
        addRequirements(m_pickup);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ClawUp...");

    }

    //real code
    @Override
    public void execute() {
       m_pickup.armsUp();
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
            Logger.ending("Interrupting Command: ClawUp...");
        } else {
            Logger.ending("Ending Command: ClawUp...");
        }
    }

}
