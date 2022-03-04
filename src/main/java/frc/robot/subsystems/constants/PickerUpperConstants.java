package frc.robot.subsystems.constants;

import frc.robot.subsystems.utils.EncoderUtils;
import frc.robot.subsystems.utils.PIDValues;

public class PickerUpperConstants {
    public static final double GEAR_RATIO = 4.0;
    public static final double GRABBER_ANGLE = 45;
    public static final double ARM_ANGLE = 90;
    public static final int GRABBER_ANGLE_IN_TICKS = EncoderUtils.translateAngleToTicks(GRABBER_ANGLE, GEAR_RATIO);
    public static final int ARM_ANGLE_IN_TICKS = EncoderUtils.translateAngleToTicks(ARM_ANGLE, GEAR_RATIO);
    public static final PIDValues PID_GRABBER_VALUES = new PIDValues(0.5, 0.0, 0.0, 0.0);
    public static final PIDValues PID_ARM_VALUES = new PIDValues(0.5, 0.0, 0.0, 0.0);

}
