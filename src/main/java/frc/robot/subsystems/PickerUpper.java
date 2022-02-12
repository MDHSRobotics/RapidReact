package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import static frc.robot.subsystems.Devices.*;

// Lighter subsystem, for turning lights on and off. 
public class PickerUpper extends SubsystemBase {

    private boolean isGrabberToggled = false;
    private boolean isArmsToggled = false;

    public PickerUpper() {
        Logger.setup("Constructing Subsystem: PickerUpper...");
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run 
    }

    //moves the arms horizontally 
    public void toggleGrabber() {
        if (!isGrabberToggled) {
            isGrabberToggled = true;
            talonFxPickupGrabber.set(0.5);
        } else {
            isGrabberToggled = false;
            talonFxPickupGrabber.set(-0.5);
        }
    } 

    //moves the arms vertically 
    public void toggleArms() {
        if (!isArmsToggled) {
            isArmsToggled = true;
            talonFxPickupLeft.set(0.5);
            talonFxPickupRight.set(0.5);
        } else {
            isArmsToggled = false;
            talonFxPickupLeft.set(0.5);
            talonFxPickupRight.set(0.5);
        }
    }

    public void stopPickup() {
        talonFxPickupLeft.stopMotor();
        talonFxPickupRight.stopMotor();
        talonFxPickupGrabber.stopMotor();
    }

}
