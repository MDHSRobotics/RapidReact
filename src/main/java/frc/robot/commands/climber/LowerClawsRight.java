
package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.RightClimber;

public class LowerClawsRight extends CommandBase {

    private RightClimber m_rightClimber; 

    public LowerClawsRight(RightClimber climber) {
        Logger.setup("Constructing Command: LowerArms...");

        // Add given subsystem requirements
        m_rightClimber = climber;
        addRequirements(m_rightClimber);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: LowerArms...");
    }

    @Override
    public void execute() {
        m_rightClimber.lowerClawsRight();
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
   }

}
