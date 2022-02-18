package frc.robot.devices;

import edu.wpi.first.wpilibj.AnalogInput;
import frc.robot.subsystems.utils.EncoderTranslator;
import edu.wpi.first.math.controller.PIDController;
import frc.robot.subsystems.constants.SwerveConstants;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.util.sendable.SendableRegistry;
import frc.robot.brains.SwerveDriverBrain;

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

        // Group the contents of the module together in SmartDashboard
        SendableRegistry.setName(driveMotor, "Module " + m_name, "Drive Motor");
        SendableRegistry.setName(turningMotor, "Module " + m_name, "Turning Motor");
    }

    public double getDrivePositionMeters() {
        double ticks = driveMotor.getSelectedSensorPosition();
        double positionInMeters = m_encoderTranslate.ticks_to_distance(ticks, SwerveConstants.kWheelDiameterMeters,
                            SwerveConstants.kGearRatioDriving);
        return positionInMeters;
    }

    public double getTurningPositionRadians() {
        double turnTicks = turningMotor.getSelectedSensorPosition();
        double turnRadians = m_encoderTranslate.ticks_to_radians(turnTicks, SwerveConstants.kGearRatioTurning);
        return turnRadians;
    }

    public double getDriveVelocityMPS() {
        double driveVelocityTPHMS = driveMotor.getSelectedSensorVelocity();
        double driveVelocityMPS = m_encoderTranslate.ticksPerDecisecond_to_velocity(driveVelocityTPHMS, SwerveConstants.kWheelDiameterMeters);
        return driveVelocityMPS;
    }

    public double getTurningVelocityRadiansPS() {
        double turningVelocityTPHMS = turningMotor.getSelectedSensorVelocity();
        double turningVelocityRPS = m_encoderTranslate.ticksPerDecisecond_to_RadiansPerSecond(turningVelocityTPHMS);
        return turningVelocityRPS;
    }

    public double getAbsoluteEncoderRadians() {
        double angle = absoluteEncoder.getVoltage() / RobotController.getVoltage5V();
        angle *= 2.0 * Math.PI;
        angle -= absoluteEncoderOffsetRad;
        return angle * (absoluteEncoderReversed ? -1.0 : 1.0);
    }

    // Get array of encoder readings:
    // [0] - drive motor (ticks)
    // [1] - drive motor position (meters)
    // [2] - turning motor (ticks)
    // [3] - turning motor angle (degrees)
    public double [] getEncoderReadings() {
        double [] readings = new double[4];

        readings[0] = driveMotor.getSelectedSensorPosition();
        readings[1] = getDrivePositionMeters();
        readings[2] = turningMotor.getSelectedSensorPosition();
        readings[3] = getTurningPositionRadians() / Math.PI * 180.;

        return readings;
    }

    public void resetEncoders() {
        driveMotor.setSelectedSensorPosition(0.0);

        // TODO get the actual absolute encoder position
        double initialAbsoluteEncoderPosition = 0.0;
        turningMotor.setSelectedSensorPosition(initialAbsoluteEncoderPosition);
    }

    public SwerveModuleState getState() {
        return new SwerveModuleState(getDriveVelocityMPS(), new Rotation2d(getTurningPositionRadians()));
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
        double turningPower = turningPidController.calculate(getTurningPositionRadians(), state.angle.getRadians());

        driveMotor.set(drivePower);
        turningMotor.set(turningPower);
        SmartDashboard.putString("Swerve Power: " + m_name,
                                 String.format("Drive = %.2f; Turning = %.2f", drivePower, turningPower));
        SwerveDriverBrain.setModuleDrivePower(m_name, drivePower);
        SwerveDriverBrain.setModuleTurningPower(m_name, turningPower);
    }

    public void stop() {
        driveMotor.set(0);
        turningMotor.set(0);

        SwerveDriverBrain.setModuleDrivePower(m_name, 0.);
        SwerveDriverBrain.setModuleTurningPower(m_name, 0.);
    }

    public void setShuffleboardBrain() {
        SwerveDriverBrain.setModuleEncoderReadings(m_name, getEncoderReadings());
    }
}
