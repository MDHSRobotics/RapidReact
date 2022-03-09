
package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Climber;

public class LowerClaws extends CommandBase {

    private Climber m_climber; 

    public LowerClaws(Climber climber) {
        Logger.setup("Constructing Command: LowerArms...");

        // Add given subsystem requirements
        m_climber = climber;
        addRequirements(m_climber);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: LowerArms...");
    }

    @Override
    public void execute() {
        m_climber.lowerClaws();
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
            Logger.ending("Interrupting Command: LowerArms...");
        } else {
            Logger.ending("Ending Command: LowerArms...");
        }
        m_climber.stop();
    }

}
