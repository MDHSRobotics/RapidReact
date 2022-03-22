
package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.RightClimber;

public class RaiseClawsRight extends CommandBase {

    private RightClimber m_rightClimber; 

    public RaiseClawsRight(RightClimber climber) {
        Logger.setup("Constructing Command: RaiseArms...");

        // Add given subsystem requirements
        m_rightClimber = climber;
        addRequirements(m_rightClimber);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: RaiseArms...");
    }

    @Override
    public void execute() {
        m_rightClimber.raiseClawsRight();
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
        }

}
