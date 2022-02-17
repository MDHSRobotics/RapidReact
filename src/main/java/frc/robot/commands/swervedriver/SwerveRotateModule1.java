
package frc.robot.commands.swervedriver;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SwerveDriver;
import frc.robot.consoles.Logger;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import frc.robot.subsystems.constants.SwerveConstants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class SwerveRotateModule1 extends CommandBase {

    private final SwerveDriver m_swerveDriver;

    public SwerveRotateModule1 (SwerveDriver swerveDriver) {
        m_swerveDriver = swerveDriver;
        addRequirements(swerveDriver);
    }

    @Override
    public void initialize() {
        Logger.setup("Initializing SwerveRotateModule1");
    }

    @Override
    public void execute() {
        Logger.info("Executing rotate");
        //m_swerveDriver.setModuleStates(moduleStates);
    }

    @Override
    public void end(boolean interrupted) {
        m_swerveDriver.stopModules();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
