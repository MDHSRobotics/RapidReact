package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.PistonShooter;

// This command stops the PistonShooter.
public class TogglePistons extends CommandBase {

    private PistonShooter m_pistonShooter;
    private double m_msPassed;

    public TogglePistons(PistonShooter pistonShooter) {
        Logger.setup("Constructing Command: TogglePistons...");

        // Add given subsystem requirements
        m_pistonShooter = pistonShooter;
        addRequirements(m_pistonShooter);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: TogglePistons...");

        m_msPassed = 0;
        m_pistonShooter.shootPistons();
    }

    @Override
    public void execute() {
        m_msPassed += 200;
    }

    // This command continues until interrupted
    @Override
    public boolean isFinished() {
        if (m_msPassed >= 5000) {
            m_pistonShooter.retractPistons();
            return true;
        } else {
            return false;
        }
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
