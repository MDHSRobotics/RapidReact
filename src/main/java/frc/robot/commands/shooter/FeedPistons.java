package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.PistonShooter;

// This command stops the PistonShooter.
public class FeedPistons extends CommandBase {

    private PistonShooter m_pistonShooter;

    public FeedPistons(PistonShooter pistonShooter) {
        Logger.setup("Constructing Command: FeedPistons...");

        // Add given subsystem requirements
        m_pistonShooter = pistonShooter;
        addRequirements(m_pistonShooter);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: FeedPistons...");
    }

    @Override
    public void execute() {
        
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
            Logger.ending("Interrupting Command: FeedPistons...");
        } else {
            Logger.ending("Ending Command: FeedPistons...");
        }
    }

}
