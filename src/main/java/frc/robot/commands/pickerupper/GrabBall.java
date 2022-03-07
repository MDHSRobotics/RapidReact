package frc.robot.commands.pickerupper;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.PickerUpper;


public class GrabBall extends CommandBase {

    private PickerUpper m_pickup;

    public GrabBall(PickerUpper pickup) {
        Logger.setup("Constructing Command: GrabBall...");

        // Add given subsystem requirements
        m_pickup = pickup;
        addRequirements(m_pickup);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: GrabBall...");

        m_pickup.grabBall();
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
            Logger.ending("Interrupting Command: GrabBall...");
        } else {
            Logger.ending("Ending Command: GrabBall...");
        }
    }

}
