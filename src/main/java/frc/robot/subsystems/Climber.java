package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.talonFxClimberRight;
import static frc.robot.subsystems.Devices.talonFxClimberLeft;


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
       talonFxClimberRight.stopMotor();
       talonFxClimberLeft.stopMotor();

   }

   // Spin the Pickup
   public void raiseArms() {
       talonFxClimberRight.set(0.5);
       talonFxClimberLeft.set(-0.5);
   }

   public void lowerArms() {
        talonFxClimberRight.set(-0.5);
        talonFxClimberLeft.set(0.5);
   }
}
