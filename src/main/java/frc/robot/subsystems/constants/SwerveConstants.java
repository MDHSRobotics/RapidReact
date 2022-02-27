package frc.robot.subsystems.constants;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

public final class SwerveConstants {
    public static final double kGearRatioTurning = 12.8;
    public static final double kGearRatioDriving = 8.16;
    public static final double kPTurning = 0.5;
    public static final double kWheelDiameterMeters = Units.inchesToMeters(4.0);
    public static final double kPhysicalMaxSpeedMetersPerSecond = 8.0;
    public static final double kPhysicalMaxAngularSpeedRadiansPerSecond = 2.0 * 2.0 * Math.PI;

    // TODO check measurements
    public static final double kTrackWidth = Units.inchesToMeters(25.0);
    // Distance between right and left wheels
    public static final double kWheelBase = Units.inchesToMeters(25.0);
    // Distance between front and back wheels
    public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
            new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
            new Translation2d(kWheelBase / 2, kTrackWidth / 2),
            new Translation2d(-kWheelBase / 2, -kTrackWidth / 2),
            new Translation2d(-kWheelBase / 2, kTrackWidth / 2));

    // TODO double check reverse booleans
    public static final boolean kFrontLeftTurningEncoderReversed = true;
    public static final boolean kRearLeftTurningEncoderReversed = true;
    public static final boolean kFrontRightTurningEncoderReversed = true;
    public static final boolean kRearRightTurningEncoderReversed = true;

    public static final boolean kFrontLeftDriveEncoderReversed = true;
    public static final boolean kRearLeftDriveEncoderReversed = true;
    public static final boolean kFrontRightDriveEncoderReversed = true;
    public static final boolean kRearRightDriveEncoderReversed = true;

    // TODO implement once we get the absolute encoders
    public static final int kFrontLeftDriveAbsoluteEncoderPort = 0;
    public static final int kRearLeftDriveAbsoluteEncoderPort = 2;
    public static final int kFrontRightDriveAbsoluteEncoderPort = 1;
    public static final int kRearRightDriveAbsoluteEncoderPort = 3;

    public static final boolean kFrontLeftDriveAbsoluteEncoderReversed = false;
    public static final boolean kRearLeftDriveAbsoluteEncoderReversed = true;
    public static final boolean kFrontRightDriveAbsoluteEncoderReversed = false;
    public static final boolean kRearRightDriveAbsoluteEncoderReversed = true;

    public static final double kFrontLeftDriveAbsoluteEncoderOffsetRad = -0.254;
    public static final double kRearLeftDriveAbsoluteEncoderOffsetRad = -1.252;
    public static final double kFrontRightDriveAbsoluteEncoderOffsetRad = -1.816;
    public static final double kRearRightDriveAbsoluteEncoderOffsetRad = -4.811;

    public static final double kTeleDriveMaxSpeedMetersPerSecond = kPhysicalMaxSpeedMetersPerSecond / 4.;
        public static final double kTeleDriveMaxAngularSpeedRadiansPerSecond = //
                kPhysicalMaxAngularSpeedRadiansPerSecond / 4.;
        public static final double kTeleDriveMaxAccelerationUnitsPerSecond = 3.;
        public static final double kTeleDriveMaxAngularAccelerationUnitsPerSecond = 3.;

    public static final class OIConstants {

        public static final double kDeadband = 0.05;
    }
}
