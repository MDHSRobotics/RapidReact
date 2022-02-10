package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.subsystems.Devices.*;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class SwerveDriver extends SubsystemBase {

    // Control whether you want the thumbstick axes to be flipped in the opposite direction.
    public static final boolean isYFlipped = false;
    public static final boolean isXFlipped = false;
    public static final boolean isOmegaFlipped = false;

    // Drive using a vertical, horizontal, and rotational velocity
    public final double L = .47;
    public final double W = .47;
    public final double GEAR_RATIO = 12.8;
    public final int ticksperrotation = 2048;

    public void drive(double x1, double y1, double x2) {
        double r = Math.sqrt((L * L) + (W * W));
        y1 *= -1;

        double a = x1 - x2 * (L / r);
        double b = x1 + x2 * (L / r);
        double c = y1 - x2 * (W / r);
        double d = y1 + x2 * (W / r);

        double backRightSpeed = Math.sqrt((a * a) + (d * d));
        double backLeftSpeed = Math.sqrt((a * a) + (c * c));
        double frontRightSpeed = Math.sqrt((b * b) + (d * d));
        double frontLeftSpeed = Math.sqrt((b * b) + (c * c));

        double backRightAngle = Math.atan2(a, d) / Math.PI;
        double backLeftAngle = Math.atan2(a, c) / Math.PI;
        double frontRightAngle = Math.atan2(b, d) / Math.PI;
        double frontLeftAngle = Math.atan2(b, c) / Math.PI;

        int tickBackRightAngle = (int) (backRightAngle * ticksperrotation * GEAR_RATIO);
        int tickBackLeftAngle = (int) (backLeftAngle * ticksperrotation * GEAR_RATIO);
        int tickFrontRightAngle = (int) (frontRightAngle * ticksperrotation * GEAR_RATIO);
        int tickFrontLeftAngle = (int) (frontLeftAngle * ticksperrotation * GEAR_RATIO);

        talonFxSwerveDriveRR.set(backRightSpeed);
        talonFxSwerveDriveRL.set(backLeftSpeed);
        talonFxSwerveDriveFR.set(frontRightSpeed);
        talonFxSwerveDriveFL.set(frontLeftSpeed);

        talonFxSwerveTurnFL.set(ControlMode.Position, tickFrontLeftAngle);
        talonFxSwerveTurnFR.set(ControlMode.Position, tickFrontRightAngle);
        talonFxSwerveTurnRL.set(ControlMode.Position, tickBackLeftAngle);
        talonFxSwerveTurnRR.set(ControlMode.Position, tickBackRightAngle);
    }

    // Stop all the swerve modules
    public void stop() {
        Devices.frontLeftSwerveModule.stopModule();
        Devices.frontRightSwerveModule.stopModule();
        Devices.rearLeftSwerveModule.stopModule();
        Devices.rearRightSwerveModule.stopModule();
    }

    public void testMotors() {
        Devices.frontLeftSwerveModule.testModule();
        Devices.frontRightSwerveModule.testModule();
        Devices.rearLeftSwerveModule.testModule();
        Devices.rearRightSwerveModule.testModule();
    }
}