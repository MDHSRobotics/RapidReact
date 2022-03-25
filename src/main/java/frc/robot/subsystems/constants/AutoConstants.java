package frc.robot.subsystems.constants;

import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;

public final class AutoConstants {
    public static final double kMaxSpeedMetersPerSecond = 3;
    public static final double kMaxAccelerationMetersPerSecondSquared = 3;

    //Pid constants for trajectory following
    //TODO validate the pid constants
    public static final double kPXController = 1.5;
    public static final double kPYController = 1.5;
    public static final double kPThetaController = 3;

    //Profile for trajectory following
    public static final double kMaxAngularSpeedRadiansPerSecond = //
                    SwerveConstants.kPhysicalMaxAngularSpeedRadiansPerSecond / 10;
    public static final double kMaxAngularAccelerationRadiansPerSecondSquared = Math.PI / 4;

    public static final TrapezoidProfile.Constraints kThetaControllerConstraints = //
                new TrapezoidProfile.Constraints(
                        kMaxAngularSpeedRadiansPerSecond,
                        kMaxAngularAccelerationRadiansPerSecondSquared);

    // TODO find the actual shooting distance
    public static final double optimalShootingDistanceMeters = Units.feetToMeters(2.0);
    public static final double radiusOfBalltoCenterMeters = Units.feetToMeters(12.75);
    public static final double timePerCommand = 4.0;
    public static final double robotOffsetDistance = Units.inchesToMeters(22);
    public static final double angleFromBallToLineBetweenPentagons = Math.asin((7.375 + 22.47) / 153);
    public static final double startingAngleFromLineBetweenPentagons = 22.5;
}
