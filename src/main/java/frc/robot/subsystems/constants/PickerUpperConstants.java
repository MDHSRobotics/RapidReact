package frc.robot.subsystems.constants;

import frc.robot.subsystems.utils.PIDValues;

public class PickerUpperConstants {

    public static final double GEAR_RATIO = 4.0;
    public static final double GRABBER_ANGLE = 45;
    public static final double ARM_ANGLE = 90;
    public static final PIDValues PID_GRABBER_VALUES = new PIDValues(0.5, 0.0, 0.0, 0.0);
    public static final PIDValues PID_ARM_VALUES = new PIDValues(0.5, 0.0, 0.0, 0.0);
    public static final double kGrabberRampTime = 0.5; // units are tphms
    public static final double kArmRampTime = 0.5; // units are tphms
}
