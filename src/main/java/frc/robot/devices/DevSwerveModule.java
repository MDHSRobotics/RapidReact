package frc.robot.devices;

import edu.wpi.first.wpilibj.AnalogInput;
import frc.robot.subsystems.utils.EncoderTranslator;
import edu.wpi.first.math.controller.PIDController;
import frc.robot.subsystems.constants.SwerveConstants;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.geometry.Rotation2d;

public class DevSwerveModule {

    private final String m_name;
    private final DevTalonFX driveMotor;
    private final DevTalonFX turningMotor;

    private final PIDController turningPidController;

    private final AnalogInput absoluteEncoder;
    private final boolean absoluteEncoderReversed;
    private final double absoluteEncoderOffsetRad;

    private final EncoderTranslator m_encoderTranslate;

    public DevSwerveModule(String moduleName, DevTalonFX driveTalon, DevTalonFX steerTalon,
            boolean driveMotorReversed, boolean turningMotorReversed,
            int absoluteEncoderId, double absoluteEncoderOffset, boolean absoluteEncoderReversed) {

        this.absoluteEncoderOffsetRad = absoluteEncoderOffset;
        this.absoluteEncoderReversed = absoluteEncoderReversed;
        absoluteEncoder = new AnalogInput(absoluteEncoderId);

        m_name = moduleName;

        driveMotor = driveTalon; 
        turningMotor = steerTalon;

        driveMotor.setInverted(driveMotorReversed);
        turningMotor.setInverted(turningMotorReversed);

        turningPidController = new PIDController(SwerveConstants.kPTurning, 0, 0);
        turningPidController.enableContinuousInput(-Math.PI, Math.PI);

        m_encoderTranslate = new EncoderTranslator("TalonFX"); 

        resetEncoders();
    }

    /*
    public double getDrivePosition() {
        int driveMotor.
        return driveEncoder.getPosition();
    }
    */

    public double getTurningPosition() {
        double turnTicks = turningMotor.getSelectedSensorPosition();
        double turnRadians = m_encoderTranslate.ticks_to_radians(turnTicks);
        return turnRadians;
    }

    public double getDriveVelocity() {
        double driveVelocityTPHMS = driveMotor.getSelectedSensorVelocity();
        double driveVelocityMPS = m_encoderTranslate.ticksPerDecisecond_to_metersPerSecond(driveVelocityTPHMS, SwerveConstants.kWheelDiameterMeters);
        return driveVelocityMPS;
    }

    public double getTurningVelocity() {
        double turningVelocityTPHMS = turningMotor.getSelectedSensorVelocity();
        double turningVelocityMPS = m_encoderTranslate.ticksPerDecisecond_to_RadiansPerSecond(turningVelocityTPHMS);
        return turningVelocityMPS;
    }

    public double getAbsoluteEncoderRad() {
        double angle = absoluteEncoder.getVoltage() / RobotController.getVoltage5V();
        angle *= 2.0 * Math.PI;
        angle -= absoluteEncoderOffsetRad;
        return angle * (absoluteEncoderReversed ? -1.0 : 1.0);
    }

    public void resetEncoders() {
        driveMotor.setSelectedSensorPosition(0.0);

        // TODO get the actual absolute encoder position
        double initialAbsoluteEncoderPosition = 0.0;
        turningMotor.setSelectedSensorPosition(initialAbsoluteEncoderPosition);
    }

    public SwerveModuleState getState() {
        return new SwerveModuleState(getDriveVelocity(), new Rotation2d(getTurningPosition()));
    }

    public void setDesiredState(SwerveModuleState state) {
        if (Math.abs(state.speedMetersPerSecond) < 0.001) {
            stop();

            SmartDashboard.putString("Swerve State: " + m_name, "STOPPED");
            SmartDashboard.putString("Swerve Power: " + m_name, "STOPPED");

            return;
        }
        state = SwerveModuleState.optimize(state, getState().angle);
        SmartDashboard.putString("Swerve State: " + m_name, state.toString());

        double drivePower = state.speedMetersPerSecond / SwerveConstants.kPhysicalMaxSpeedMetersPerSecond;
        double turningPower = turningPidController.calculate(getTurningPosition(), state.angle.getRadians());

        driveMotor.set(drivePower);
        turningMotor.set(turningPower);
        SmartDashboard.putString("Swerve Power: " + m_name,
                                 String.format("Drive = %.2f; Turning = %.2f", drivePower, turningPower));
    }

    public void stop() {
        driveMotor.set(0);
        turningMotor.set(0);
    }
}
