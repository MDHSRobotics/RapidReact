package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.subsystems.utils.EncoderUtils;
import frc.robot.subsystems.utils.PIDValues;
import frc.robot.subsystems.utils.TalonUtils;
import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.consoles.Logger;
import static frc.robot.subsystems.Devices.*;

import static frc.robot.RobotManager.isReal;

// Lighter subsystem, for turning lights on and off. 
public class PickerUpper extends SubsystemBase {

    //Encoder Constants
    private double GEAR_RATIO = 4.0;

    private int grabberAngle = 45;
    private int armAngle = 90;

    private boolean isGrabberToggled = false;
    private boolean isArmsToggled = false;

    public PickerUpper() {
        Logger.setup("Constructing Subsystem: PickerUpper...");

        if (isReal) {
            //TODO: Get PID values.
            PIDValues pidGrabber = new PIDValues(0.5, 0.0, 0.0, 0.0);
            PIDValues pidArm = new PIDValues(0.5, 0.0, 0.0, 0.0);
            
            TalonUtils.configureTalonWithEncoder(talonSrxPickupGrabber, true, true, pidGrabber);
            TalonUtils.configureTalonWithEncoder(talonSrxPickupLeft, true, true, pidArm);
            TalonUtils.configureTalonWithEncoder(talonSrxPickupRight, true, true, pidArm);
        }
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run 
    }

    //moves the arms horizontally 
    public void toggleGrabber() {
        int grabberAngleInTicks = EncoderUtils.translateAngleToTicks(grabberAngle, GEAR_RATIO);

        if (!isGrabberToggled) {
            isGrabberToggled = true;
            talonSrxPickupGrabber.set(ControlMode.Position, grabberAngleInTicks);
        } else {
            isGrabberToggled = false;
            talonSrxPickupGrabber.set(ControlMode.Position, -grabberAngleInTicks);
        }
    } 

    //moves the arms vertically 
    public void toggleArms() {
        int armAngleInTicks = EncoderUtils.translateAngleToTicks(armAngle, GEAR_RATIO);

        if (!isArmsToggled) {
            isArmsToggled = true;
            talonSrxPickupLeft.set(ControlMode.Position, armAngleInTicks);
            talonSrxPickupRight.set(ControlMode.Position, armAngleInTicks);        
        } else {
            isArmsToggled = false;
            talonSrxPickupLeft.set(ControlMode.Position, -armAngleInTicks);
            talonSrxPickupRight.set(ControlMode.Position, -armAngleInTicks);        
        }
    }

    public void stopPickup() {
        talonSrxPickupLeft.stopMotor();
        talonSrxPickupRight.stopMotor();
        talonSrxPickupGrabber.stopMotor();
    }

}
