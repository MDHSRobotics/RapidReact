package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.constants.ClimberConstants;
import frc.robot.subsystems.utils.TalonUtils;
import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.talonSrxClimberLeftMaster;
import static frc.robot.subsystems.Devices.talonSrxClimberLeftFollower;


public class LeftClimber extends SubsystemBase {

   public LeftClimber() {
        Logger.setup("Constructing Subsystem: Climb...");
        talonSrxClimberLeftFollower.follow(talonSrxClimberLeftMaster);
        TalonUtils.configureBaseTalon(talonSrxClimberLeftMaster, false);
        TalonUtils.configureBaseTalon(talonSrxClimberLeftFollower, true);
        talonSrxClimberLeftMaster.configOpenloopRamp(ClimberConstants.kClimberRampTime);
   }

   @Override
   public void periodic() {
       // This method will be called once per scheduler run
   }

   // Stop the Pickup
   public void stop() {
       talonSrxClimberLeftMaster.stopMotor();

   }

   // Spin the Pickup
   public void raiseClawsLeft() {
        talonSrxClimberLeftMaster.set(-0.8);
    }

   public void lowerClawsLeft() {
     talonSrxClimberLeftMaster.set(0.8);
    }
}
