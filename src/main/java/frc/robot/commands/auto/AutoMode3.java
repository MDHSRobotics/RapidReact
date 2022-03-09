package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotSubsystems;
import frc.robot.commands.pickerupper.*;
import frc.robot.commands.shooter.TogglePistons;

public class AutoMode3 extends SequentialCommandGroup {

    public AutoMode3() {

            addCommands(
                // lower pickup arms
                new LowerArms(BotSubsystems.pickerupper),

                // shoot pre-loaded ball
                new TogglePistons(BotSubsystems.pistonShooter),

                // retract pistons
                new TogglePistons(BotSubsystems.pistonShooter),

                // lift arm
                new RaiseArms(BotSubsystems.pickerupper),

                // turn around to face ball
                new TurnAround(),

                // drive back to ball
                new MoveToAndFromStart(),

                // rotate 90 degrees clockwise
                new RotateClockwise90Deg(),

                // lower pickup arms
                new LowerArms(BotSubsystems.pickerupper),

                // swerve to the left
                new SwerveLeft(),

                // grab ball
                new GrabBall(BotSubsystems.pickerupper),

                // lift ball
                new RaiseArms(BotSubsystems.pickerupper),

                // drop ball
                new DropBall(BotSubsystems.pickerupper),

                // lower pickup arms
                new LowerArms(BotSubsystems.pickerupper),

                // turn around to face goal
                new TurnAround(),

                // move back to shoot
                new MoveToAndFromStart(),

                // shoot
                new TogglePistons(BotSubsystems.pistonShooter),

                // retract pistons
                new TogglePistons(BotSubsystems.pistonShooter)
            );
    }

}