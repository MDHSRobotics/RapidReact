
package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Climber;

public class StopClimber extends CommandBase {

    private Climber m_climber; 

    public StopClimber(Climber climber) {
        Logger.setup("Constructing Command: StopClimber...");

        // Add given subsystem requirements
        m_climber = climber;
        addRequirements(m_climber);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StopClimber...");
    }

    @Override
    public void execute() {
        m_climber.stop();
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
            Logger.ending("Interrupting Command: StopClimber...");
        } else {
            Logger.ending("Ending Command: StopClimber...");
        }
        m_climber.stop();
    }

}
