
package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Climber;

public class RaiseClaws extends CommandBase {

    private Climber m_climber; 

    public RaiseClaws(Climber climber) {
        Logger.setup("Constructing Command: RaiseArms...");

        // Add given subsystem requirements
        m_climber = climber;
        addRequirements(m_climber);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: RaiseArms...");
    }

    @Override
    public void execute() {
        m_climber.raiseClaws();
    }

    // This command continues until interrupted
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
        m_climber.stop();
    }

}
