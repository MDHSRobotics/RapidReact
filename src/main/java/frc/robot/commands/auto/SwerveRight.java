package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotSubsystems;
import frc.robot.commands.swervedriver.TimedSwerve;
import frc.robot.subsystems.constants.AutoConstants;
import frc.robot.subsystems.constants.SwerveConstants;
import edu.wpi.first.math.util.*;

public class SwerveRight extends SequentialCommandGroup {
    double rotationInDegrees = 33.37; //we want the robot to rotate counter-clockwise
    double turnArcLengthMeters = Units.feetToMeters(2 * Math.PI * AutoConstants.radiusOfBalltoCenterMeters * (rotationInDegrees / 360));
    double turnDistanceVelocity = turnArcLengthMeters / (AutoConstants.timePerCommand - SwerveConstants.kDriveRampTime);

    public SwerveRight () {
        addCommands(
            // swerve counter-clockwise to ball
            new TimedSwerve(BotSubsystems.swerveDriver, -turnDistanceVelocity, 0.0, -rotationInDegrees / (AutoConstants.timePerCommand - SwerveConstants.kDriveRampTime), AutoConstants.timePerCommand));
    }
}
