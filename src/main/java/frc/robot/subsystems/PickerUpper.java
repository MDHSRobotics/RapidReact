package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.subsystems.utils.TalonUtils;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.subsystems.constants.PickerUpperConstants;
import frc.robot.subsystems.utils.EncoderTranslator;

import frc.robot.consoles.Logger;
import static frc.robot.subsystems.Devices.*;

import static frc.robot.RobotManager.isReal;

// Lighter subsystem, for turning lights on and off.
public class PickerUpper extends SubsystemBase {

    //Encoder Constants
    private boolean isGrabberToggled = false;
    private boolean isArmsToggled = false;

    private EncoderTranslator m_encoderTranslator = new EncoderTranslator("TalonSRX", 0, PickerUpperConstants.GEAR_RATIO);
    private final int GRABBER_ANGLE_IN_TICKS;
    private final int ARM_ANGLE_IN_TICKS;

    public PickerUpper() {
        Logger.setup("Constructing Subsystem: PickerUpper...");

        if (isReal) {
            //TODO: Get PID values.
            TalonUtils.configureTalonWithEncoder(talonSrxPickupGrabber, true, true, PickerUpperConstants.PID_GRABBER_VALUES);
            TalonUtils.configureTalonWithEncoder(talonSrxPickupLeft, true, true, PickerUpperConstants.PID_ARM_VALUES);
            TalonUtils.configureTalonWithEncoder(talonSrxPickupRight, true, true, PickerUpperConstants.PID_ARM_VALUES);
        }

        GRABBER_ANGLE_IN_TICKS = m_encoderTranslator.degrees_to_ticks(PickerUpperConstants.GRABBER_ANGLE);
        ARM_ANGLE_IN_TICKS = m_encoderTranslator.degrees_to_ticks(PickerUpperConstants.ARM_ANGLE);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    //moves the arms horizontally
    public void toggleGrabber() {

        if (!isGrabberToggled) {
            isGrabberToggled = true;
            talonSrxPickupGrabber.set(ControlMode.Position, GRABBER_ANGLE_IN_TICKS);
        } else {
            isGrabberToggled = false;
            talonSrxPickupGrabber.set(ControlMode.Position, -GRABBER_ANGLE_IN_TICKS);
        }
    }

    //moves the arms vertically
    public void toggleArms() {

        if (!isArmsToggled) {
            isArmsToggled = true;
            talonSrxPickupLeft.set(ControlMode.Position, ARM_ANGLE_IN_TICKS);
            talonSrxPickupRight.set(ControlMode.Position, ARM_ANGLE_IN_TICKS);
        } else {
            isArmsToggled = false;
            talonSrxPickupLeft.set(ControlMode.Position, -ARM_ANGLE_IN_TICKS);
            talonSrxPickupRight.set(ControlMode.Position, -ARM_ANGLE_IN_TICKS);
        }
    }

    public void stopPickup() {
        talonSrxPickupLeft.stopMotor();
        talonSrxPickupRight.stopMotor();
        talonSrxPickupGrabber.stopMotor();
    }

}
