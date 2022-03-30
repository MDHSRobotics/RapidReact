package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotSubsystems;
import frc.robot.commands.shooter.TogglePistons;

public class AutoMode2 extends SequentialCommandGroup {

    public AutoMode2() {

            addCommands(

                // shoot pre-loaded ball
                new TogglePistons(BotSubsystems.pistonShooter),


                // turn around to face ball
                new TurnAround(),

                // drive backward
                new MoveToAndFromStart(),

                // rotate 90 degrees counter-clockwise
                new RotateCounterClock90Deg(),

                // swerve to the right
                new SwerveRight(),

                // turn around to face goal
                new TurnAround(),

                // move back to shoot
                new MoveToAndFromStart(),

                // shoot
                new TogglePistons(BotSubsystems.pistonShooter)
            );
    }

}