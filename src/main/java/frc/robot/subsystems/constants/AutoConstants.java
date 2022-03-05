package frc.robot.subsystems.constants;

import edu.wpi.first.math.util.Units;

public final class AutoConstants {
    public static final double kMaxSpeedMetersPerSecond = 3;
    public static final double kMaxAccelerationMetersPerSecondSquared = 3;

    // TODO find the actual shooting distance
    public static final double optimalShootingDistanceMeters = Units.feetToMeters(2.0);
    public static final double radiusOfBalltoCenterMeters = Units.feetToMeters(12.75);
    public static final double timePerCommand = 1.;
}
