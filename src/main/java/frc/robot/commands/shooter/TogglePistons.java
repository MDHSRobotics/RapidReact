package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.PistonShooter;

// This command stops the PistonShooter.
public class TogglePistons extends CommandBase {

    private PistonShooter m_pistonShooter;

    public TogglePistons(PistonShooter pistonShooter) {
        Logger.setup("Constructing Command: TogglePistons...");

        // Add given subsystem requirements
        m_pistonShooter = pistonShooter;
        addRequirements(m_pistonShooter);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: TogglePistons...");
    }

    @Override
    public void execute() {
        m_pistonShooter.togglePistons();
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
            Logger.ending("Interrupting Command: TogglePistons...");
        } else {
            Logger.ending("Ending Command: TogglePistons...");
        }
    }

}
