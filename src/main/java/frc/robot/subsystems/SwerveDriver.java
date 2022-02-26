package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.consoles.Logger;
import frc.robot.devices.DevSwerveModule;
import frc.robot.subsystems.constants.SwerveConstants;
import edu.wpi.first.math.kinematics.ChassisSpeeds;

public class SwerveDriver extends SubsystemBase {
    private final DevSwerveModule frontLeft = new DevSwerveModule(
        "Front Left",
        Devices.talonFxSwerveDriveFL,
        Devices.talonFxSwerveTurnFL,
        SwerveConstants.kFrontLeftDriveEncoderReversed,
        SwerveConstants.kFrontLeftTurningEncoderReversed,
        SwerveConstants.kFrontLeftDriveAbsoluteEncoderPort,
        SwerveConstants.kFrontLeftDriveAbsoluteEncoderOffsetRad,
        SwerveConstants.kFrontLeftDriveAbsoluteEncoderReversed);


    // Switch between robot and field relative control
    public boolean fieldRelative = false;

    private final DevSwerveModule frontRight = new DevSwerveModule(
        "Front Right",
        Devices.talonFxSwerveDriveFR,
        Devices.talonFxSwerveTurnFR,
        SwerveConstants.kFrontRightDriveEncoderReversed,
        SwerveConstants.kFrontRightTurningEncoderReversed,
        SwerveConstants.kFrontRightDriveAbsoluteEncoderPort,
        SwerveConstants.kFrontRightDriveAbsoluteEncoderOffsetRad,
        SwerveConstants.kFrontRightDriveAbsoluteEncoderReversed);

    private final DevSwerveModule rearLeft = new DevSwerveModule(
        "Rear Left",
        Devices.talonFxSwerveDriveRL,
        Devices.talonFxSwerveTurnRL,
        SwerveConstants.kRearLeftDriveEncoderReversed,
        SwerveConstants.kRearLeftTurningEncoderReversed,
        SwerveConstants.kRearLeftDriveAbsoluteEncoderPort,
        SwerveConstants.kRearLeftDriveAbsoluteEncoderOffsetRad,
        SwerveConstants.kRearLeftDriveAbsoluteEncoderReversed);

    private final DevSwerveModule rearRight = new DevSwerveModule(
        "Rear Right",
        Devices.talonFxSwerveDriveRR,
        Devices.talonFxSwerveTurnRR,
        SwerveConstants.kRearRightDriveEncoderReversed,
        SwerveConstants.kRearRightTurningEncoderReversed,
        SwerveConstants.kRearRightDriveAbsoluteEncoderPort,
        SwerveConstants.kRearRightDriveAbsoluteEncoderOffsetRad,
        SwerveConstants.kRearRightDriveAbsoluteEncoderReversed);

    private final AHRS gyro = new AHRS(SPI.Port.kMXP);
    private final SwerveDriveOdometry odometer = new SwerveDriveOdometry(SwerveConstants.kDriveKinematics,
            new Rotation2d(0));

    public SwerveDriver() {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                zeroHeading();
            } catch (Exception e) {
            }
        }).start();
    }

    public void ToggleOrientation() {
        if (fieldRelative) {
            fieldRelative = false;
        } else {
            fieldRelative = true;
        }
    }

    public void zeroHeading() {
        gyro.reset();
    }

    public double getHeading() {
        return Math.IEEEremainder(gyro.getAngle(), 360);
    }

    // Returns the current rotation2D
    public Rotation2d getRotation2d() {
        return Rotation2d.fromDegrees(getHeading());
    }

    public Pose2d getPose() {
        return odometer.getPoseMeters();
    }

    public void resetOdometry(Pose2d pose) {
        odometer.resetPosition(pose, getRotation2d());
    }

    @Override
    public void periodic() {
        SwerveModuleState moduleStateFL = frontLeft.getState();
        SwerveModuleState moduleStateFR = frontRight.getState();
        SwerveModuleState moduleStateRL = rearLeft.getState();
        SwerveModuleState moduleStateRR = rearRight.getState();

        odometer.update(getRotation2d(), moduleStateFL, moduleStateFR, moduleStateRL, moduleStateRR);

        // Update SmartDashboard
        SmartDashboard.putNumber("Robot Heading", getHeading());
        SmartDashboard.putString("Robot Location", getPose().getTranslation().toString());

        // Update Shuffleboard
        frontLeft.setShuffleboardBrain();
        frontRight.setShuffleboardBrain();
        rearLeft.setShuffleboardBrain();
        rearRight.setShuffleboardBrain();
    }

    public void stopModules() {
        frontLeft.stop();
        frontRight.stop();
        rearLeft.stop();
        rearRight.stop();
    }

    private void setModuleStates(SwerveModuleState[] desiredStates) {
        SmartDashboard.putString("05: Front Left Desired State", desiredStates[0].toString());
        SmartDashboard.putString("05: Front Right Desired State", desiredStates[1].toString());
        SmartDashboard.putString("05: Rear Left Desired State", desiredStates[2].toString());
        SmartDashboard.putString("05: Rear Right Desired State", desiredStates[3].toString());

        SwerveDriveKinematics.desaturateWheelSpeeds(desiredStates, SwerveConstants.kPhysicalMaxSpeedMetersPerSecond);

        frontLeft.setDesiredState(desiredStates[0]);
        frontRight.setDesiredState(desiredStates[1]);
        rearLeft.setDesiredState(desiredStates[2]);
        rearRight.setDesiredState(desiredStates[3]);
    }

    //Set chassis speed based on current toggle of field orientation
    public void setChassisSpeed(double xSpeed, double ySpeed, double turningSpeed) {
        setChassisSpeed(xSpeed, ySpeed, turningSpeed, fieldRelative);
    }

    //Set chassis speeds
    public void setChassisSpeed(double xSpeed, double ySpeed, double turningSpeed, boolean fieldOriented) {
        SmartDashboard.putString("07: xSpeed", "" + xSpeed);
        SmartDashboard.putString("07: ySpeed", "" + ySpeed);
        SmartDashboard.putString("07: turningSpeed", "" + turningSpeed);
        SmartDashboard.putString("07: fieldOriented", "" + fieldOriented);
        // Construct desired chassis speeds
        ChassisSpeeds chassisSpeeds;

        if (fieldOriented) {
            // Relative to field
            chassisSpeeds = ChassisSpeeds.fromFieldRelativeSpeeds(
                    xSpeed, ySpeed, turningSpeed, getRotation2d());
        } else {
            // Relative to robot
            chassisSpeeds = new ChassisSpeeds(xSpeed, ySpeed, turningSpeed);
        }

        SmartDashboard.putString("06: Chassis Speeeds", chassisSpeeds.toString());
        // Convert chassis speeds to individual module states
        SwerveModuleState[] moduleStates = SwerveConstants.kDriveKinematics.toSwerveModuleStates(chassisSpeeds);

        // Output each module states to wheels
        setModuleStates(moduleStates);
    }

}
