package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.talonSrxClimberRight;
import static frc.robot.subsystems.Devices.talonSrxClimberLeft;


public class Climber extends SubsystemBase {
   
   public Climber() {
        Logger.setup("Constructing Subsystem: Climb...");
   }

   @Override
   public void periodic() {
       // This method will be called once per scheduler run
   }

   // Stop the Pickup
   public void stop() {
       talonSrxClimberRight.stopMotor();
       talonSrxClimberLeft.stopMotor();

   }

   // Spin the Pickup
   public void raiseArms() {
       talonSrxClimberRight.set(0.3);
       talonSrxClimberLeft.set(-0.3);
   }

   public void lowerArms() {
        talonSrxClimberRight.set(-0.3);
        talonSrxClimberLeft.set(0.3);
   }
}
