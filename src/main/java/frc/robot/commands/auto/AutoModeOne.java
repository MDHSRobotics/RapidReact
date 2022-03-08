package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotSubsystems;
import frc.robot.commands.pickerupper.*;
import frc.robot.commands.shooter.TogglePistons;

public class AutoModeOne extends SequentialCommandGroup {

    public AutoModeOne() {

            addCommands(
                // shoot pre-loaded ball
                new TogglePistons(BotSubsystems.pistonShooter),

                // retract pistons
                new TogglePistons(BotSubsystems.pistonShooter),

                // turn around to face ball
                new TurnAround(),

                // lower pickup arms
                new LowerArms(BotSubsystems.pickerupper),

                // drive back to ball
                new MoveAwayFromStart(),

                // grab ball
                new GrabBall(BotSubsystems.pickerupper),

                // lift ball
                new RaiseArms(BotSubsystems.pickerupper),

                // drop ball
                new DropBall(BotSubsystems.pickerupper),

                // lower arms
                new LowerArms(BotSubsystems.pickerupper),

                // turn around to face goal
                new TurnAround(),
      
                // move back to shoot
                new MoveToStart(),

                // shoot
                new TogglePistons(BotSubsystems.pistonShooter),

                // retract pistons
                new TogglePistons(BotSubsystems.pistonShooter)
            );
    }

}