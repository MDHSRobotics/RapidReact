package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.constants.ClimberConstants;
import frc.robot.subsystems.utils.TalonUtils;
import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.talonSrxClimberRightMaster;
import static frc.robot.subsystems.Devices.talonSrxClimberRightFollower;

public class RightClimber extends SubsystemBase {

   public RightClimber() {
        Logger.setup("Constructing Subsystem: Climb...");
        talonSrxClimberRightFollower.follow(talonSrxClimberRightMaster);
        TalonUtils.configureBaseTalon(talonSrxClimberRightMaster, false);
        TalonUtils.configureBaseTalon(talonSrxClimberRightFollower, true);
        talonSrxClimberRightMaster.configOpenloopRamp(ClimberConstants.kClimberRampTime);
   }

   @Override
   public void periodic() {
       // This method will be called once per scheduler run
   }

   // Stop the Pickup
   public void stop() {
       talonSrxClimberRightMaster.stopMotor();
   }

   // Spin the Pickup
   public void raiseClawsRight() {
       talonSrxClimberRightMaster.set(-0.8);
   }

   public void lowerClawsRight() {
        talonSrxClimberRightMaster.set(0.8);
   }
}
