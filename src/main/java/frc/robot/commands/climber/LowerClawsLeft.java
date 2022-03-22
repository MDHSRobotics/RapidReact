
package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.LeftClimber;

public class LowerClawsLeft extends CommandBase {

    private LeftClimber m_leftClimber; 

    public LowerClawsLeft(LeftClimber climber) {
        Logger.setup("Constructing Command: LowerArms...");

        // Add given subsystem requirements
        m_leftClimber = climber;
        addRequirements(m_leftClimber);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: LowerArms...");
    }

    @Override
    public void execute() {
        m_leftClimber.lowerClawsLeft();
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
