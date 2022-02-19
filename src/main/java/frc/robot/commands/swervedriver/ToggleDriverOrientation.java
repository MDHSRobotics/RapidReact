
package frc.robot.commands.swervedriver;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.SwerveDriver;

// This command switches the orientation of the robot.
public class ToggleDriverOrientation extends CommandBase {

    private SwerveDriver m_swerveDriver;

    public ToggleDriverOrientation(SwerveDriver swerveDriver) {
        Logger.setup("Constructing Command: ToggleDriverOrientation...");

        // Add given subsystem requirements
        m_swerveDriver = swerveDriver;
        addRequirements(m_swerveDriver);
    }

    @Override
    public void initialize() {
        Logger.setup("Initializing Command: ToggleDriverOrientation...");
    }

    @Override
    public void execute() {
        m_swerveDriver.ToggleOrientation();
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
            Logger.ending("Interrupting Command: ToggleDriverOrientation...");
        } else {
            Logger.ending("Ending Command: ToggleDriverOrientation...");
        }
        m_swerveDriver.stopModules();
    }

}
