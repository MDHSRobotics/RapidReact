package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotSubsystems;
import frc.robot.commands.shooter.TogglePistons;

public class AutoMode1 extends SequentialCommandGroup {

    public AutoMode1() {

            addCommands(
                // charge pistons\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
                //new WaitCommand(8),

                // lower pickup arms
                // new LowerArms(BotSubsystems.pickerupper, 0.6),

                // shoot pre-loaded ball
                new TogglePistons(BotSubsystems.pistonShooter),

                // lift arm
                // new RaiseArms(BotSubsystems.pickerupper, 0.6),

                // turn around to face ball
                //new TurnAround(),

                // lower pickup arms
                // new LowerArms(BotSubsystems.pickerupper, 0.6),

                // open grabber
                // new DropBall(BotSubsystems.pickerupper, 0.6),

                // drive back to ball
                //new MoveToAndFromStart()

                // grab ball
                // new GrabBall(BotSubsystems.pickerupper, 0.6),

                // lift ball
                // new RaiseArms(BotSubsystems.pickerupper, 0.6),

                // drop ball
                // new DropBall(BotSubsystems.pickerupper, 0.6),

                // lower pickup arms
                // new LowerArms(BotSubsystems.pickerupper, 0.6),

                // turn around to face goal
                // new TurnAround(),

                // move back to shoot
                new MoveToAndFromStart()

                // shoot
                // new TogglePistons(BotSubsystems.pistonShooter)
            );
    }

}