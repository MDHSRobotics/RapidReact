package frc.robot.commands.pickerupper;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.PickerUpper;


public class DropBall extends CommandBase {

    private PickerUpper m_pickup;

    public DropBall(PickerUpper pickup) {
        Logger.setup("Constructing Command: DropBall...");

        // Add given subsystem requirements
        m_pickup = pickup;
        addRequirements(m_pickup);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: DropBall...");

        m_pickup.dropBall();
    }

    //real code
    @Override
    public void execute() {

    }

    // This command continues until it cycles through the set number of cycles
    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: DropBall...");
        } else {
            Logger.ending("Ending Command: DropBall...");
        }
    }

}
