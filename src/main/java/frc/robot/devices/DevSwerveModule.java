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
import frc.robot.consoles.Logger;

public class DevSwerveModule {

    private final String m_name;
    private final DevTalonFX m_driveMotor;
    private final DevTalonFX m_turningMotor;

    private final PIDController m_turningPidController;

    private final AnalogInput m_absoluteEncoder;
    private final boolean m_absoluteEncoderReversed;
    private final double m_absoluteEncoderOffsetRad;

    private final EncoderTranslator m_drivingEncoderTranslate;
    private final EncoderTranslator m_turningEncoderTranslate;

    public DevSwerveModule(String moduleName, DevTalonFX driveTalon, DevTalonFX steerTalon,
            boolean driveMotorReversed, boolean turningMotorReversed,
            int absoluteEncoderId, double absoluteEncoderOffset, boolean absoluteEncoderReversed) {

        m_absoluteEncoderOffsetRad = absoluteEncoderOffset;
        m_absoluteEncoderReversed = absoluteEncoderReversed;
        m_absoluteEncoder = new AnalogInput(absoluteEncoderId);

        m_name = moduleName;

        m_driveMotor = driveTalon;
        m_turningMotor = steerTalon;

        m_driveMotor.setInverted(driveMotorReversed);
        m_turningMotor.setInverted(turningMotorReversed);

        m_turningPidController = new PIDController(SwerveConstants.kPTurning, 0, 0);
        m_turningPidController.enableContinuousInput(-Math.PI, Math.PI);

        m_drivingEncoderTranslate = new EncoderTranslator("TalonFX",
                                                   SwerveConstants.kWheelDiameterMeters,
                                                   SwerveConstants.kGearRatioDriving);

        m_turningEncoderTranslate = new EncoderTranslator("TalonFX",
                                                   SwerveConstants.kWheelDiameterMeters,
                                                   SwerveConstants.kGearRatioTurning);


        resetEncoders();

        // Group the contents of the module together in SmartDashboard
        SendableRegistry.setName(m_driveMotor, "Module " + m_name, "Drive Motor");
        SendableRegistry.setName(m_turningMotor, "Module " + m_name, "Turning Motor");
    }

    public double getDrivePositionMeters() {
        double ticks = m_driveMotor.getSelectedSensorPosition();
        double positionInMeters = m_drivingEncoderTranslate.ticks_to_distance(ticks);
        return positionInMeters;
    }

    public double getTurningPositionRadians() {
        double turnTicks = m_turningMotor.getSelectedSensorPosition();
        double turnRadians = m_turningEncoderTranslate.ticks_to_radians(turnTicks);
        return turnRadians;
    }

    public double getDriveVelocityMPS() {
        double driveVelocityTPHMS = m_driveMotor.getSelectedSensorVelocity();
        double driveVelocityMPS = m_drivingEncoderTranslate.ticksPerDecisecond_to_velocity(driveVelocityTPHMS);
        return driveVelocityMPS;
    }

    public double getTurningVelocityRadiansPS() {
        double turningVelocityTPHMS = m_turningMotor.getSelectedSensorVelocity();
        double turningVelocityRPS = m_turningEncoderTranslate.ticksPerDecisecond_to_RadiansPerSecond(turningVelocityTPHMS);
        return turningVelocityRPS;
    }

    public double getAbsoluteEncoderRadians() {
        double angle = m_absoluteEncoder.getVoltage() / RobotController.getVoltage5V();
        angle *= 2.0 * Math.PI;
        angle -= m_absoluteEncoderOffsetRad;
        return angle * (m_absoluteEncoderReversed ? -1.0 : 1.0);
    }

    // Get array of encoder readings:
    // [0] - drive motor (ticks)
    // [1] - drive motor position (meters)
    // [2] - turning motor (ticks)
    // [3] - turning motor angle (degrees)
    public double [] getEncoderReadings() {
        double [] readings = new double[4];

        readings[0] = m_driveMotor.getSelectedSensorPosition();
        readings[1] = getDrivePositionMeters();
        readings[2] = m_turningMotor.getSelectedSensorPosition();
        readings[3] = getTurningPositionRadians() / Math.PI * 180.;

        return readings;
    }

    public void resetEncoders() {
        m_driveMotor.setSelectedSensorPosition(0.0);

        // TODO get the actual absolute encoder position
        double initialAbsoluteEncoderPosition = 0.0;
        m_turningMotor.setSelectedSensorPosition(initialAbsoluteEncoderPosition);
    }

    public SwerveModuleState getState() {
        return new SwerveModuleState(getDriveVelocityMPS(), new Rotation2d(getTurningPositionRadians()));
    }

    public void setDesiredState(SwerveModuleState state) {
        SmartDashboard.putString("04: Desaturated Desired State: " + m_name, state.toString());
        
        if (Math.abs(state.speedMetersPerSecond) < 0.001) {
            Logger.info("Desired State Speed less than .001 -> Stopping...");
            stop();

            SmartDashboard.putString("03: Swerve State: " + m_name, "STOPPED");
            SmartDashboard.putString("03: Swerve Power: " + m_name, "STOPPED");

            SmartDashboard.delete("02: Swerve Optimized State: " + m_name);
            SmartDashboard.delete("01: Swerve Power: " + m_name);

            return;
        }
        else {
            SmartDashboard.delete("03: Swerve State: " + m_name);
            SmartDashboard.delete("03: Swerve Power: " + m_name);
        }

        state = SwerveModuleState.optimize(state, getState().angle);
        SmartDashboard.putString("02: Swerve Optimized State: " + m_name, state.toString());

        double drivePower = state.speedMetersPerSecond / SwerveConstants.kPhysicalMaxSpeedMetersPerSecond;
        double turningPower = m_turningPidController.calculate(getTurningPositionRadians(), state.angle.getRadians());

        SmartDashboard.putString("01: Swerve Power: " + m_name, String.format("Drive = %.2f; Turning = %.2f", drivePower, turningPower));

        SwerveDriverBrain.setModuleDrivePower(m_name, drivePower);
        SwerveDriverBrain.setModuleTurningPower(m_name, turningPower);

        m_driveMotor.set(drivePower);
        m_turningMotor.set(turningPower);
    }

    public void stop() {
        m_driveMotor.set(0);
        m_turningMotor.set(0);

        SwerveDriverBrain.setModuleDrivePower(m_name, 0.);
        SwerveDriverBrain.setModuleTurningPower(m_name, 0.);
    }

    public void setShuffleboardBrain() {
        SwerveDriverBrain.setModuleEncoderReadings(m_name, getEncoderReadings());
    }
}
