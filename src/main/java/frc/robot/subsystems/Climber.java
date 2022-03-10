package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.talonSrxClimberRightMaster;
import static frc.robot.subsystems.Devices.talonSrxClimberRightFollower;
import static frc.robot.subsystems.Devices.talonSrxClimberLeftMaster;
import static frc.robot.subsystems.Devices.talonSrxClimberLeftFollower;


public class Climber extends SubsystemBase {

   public Climber() {
        Logger.setup("Constructing Subsystem: Climb...");
        talonSrxClimberRightFollower.follow(talonSrxClimberRightMaster);
        talonSrxClimberLeftFollower.follow(talonSrxClimberLeftMaster);
   }

   @Override
   public void periodic() {
       // This method will be called once per scheduler run
   }

   // Stop the Pickup
   public void stop() {
       talonSrxClimberRightMaster.stopMotor();
       talonSrxClimberLeftMaster.stopMotor();

   }

   // Spin the Pickup
   public void raiseClaws() {
       talonSrxClimberRightMaster.set(-0.6);
       talonSrxClimberLeftMaster.set(0.6);
   }

   public void lowerClaws() {
        talonSrxClimberRightMaster.set(0.6);
        talonSrxClimberLeftMaster.set(-0.6);
   }
}
