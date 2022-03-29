package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.talonSrxPickup;

public class Pickup extends SubsystemBase {

    public Pickup() {
         Logger.setup("Constructing Subsystem: Pickup...");
    }

    public void stopPickup() {
        talonSrxPickup.stopMotor();
    }

    public void spinPickup() {
        talonSrxPickup.set(0.5);
    }

}
