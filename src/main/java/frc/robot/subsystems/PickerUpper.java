package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Devices.*;

// Lighter subsystem, for turning lights on and off. 
public class PickerUpper extends SubsystemBase {

    public PickerUpper() {
        Logger.setup("Constructing Subsystem: PickerUpper...");
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run 
    }

    //moves the arms horizontally 
    public void openHorizontal() {
        Devices.talonPickup1.set(0.5);
    }

    public void closeHorizontal() {
        Devices.talonPickup1.set(-0.5);
    }

    public void stopHorizontal() {
        Devices.talonPickup1.stopMotor();
    }

    //moves the arms vertically 
    public void armsUp() {
        Devices.talonPickup2.set(0.5);
    }

    public void armsDown() {
        Devices.talonPickup2.set(-0.5);
    }

    public void verticalStop() {
        Devices.talonPickup2.stopMotor();
    }

}
