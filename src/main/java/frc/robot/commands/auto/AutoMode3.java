package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotSubsystems;
import frc.robot.commands.shooter.TogglePistons;

public class AutoMode3 extends SequentialCommandGroup {

    public AutoMode3() {

            addCommands(
                // shoot pre-loaded ball
                new TogglePistons(BotSubsystems.pistonShooter),

                // turn around to face ball
                new TurnAround(),

                // drive back to ball
                new MoveToAndFromStart(),

                // rotate 90 degrees clockwise
                new RotateClockwise90Deg(),

                // swerve to the left
                new SwerveLeft(),

                // turn around to face goal
                new TurnAround(),

                // move back to shoot
                new MoveToAndFromStart(),

                // shoot
                new TogglePistons(BotSubsystems.pistonShooter)
            );
    }

}