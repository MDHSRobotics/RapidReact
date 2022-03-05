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

                // lower pickup arms
                 new ToggleArms(BotSubsystems.pickerupper),

                // drive back to ball
                new MoveAwayFromStart(),

                // grab ball
                new ToggleGrabber(BotSubsystems.pickerupper),

                // lift ball
                new ToggleArms(BotSubsystems.pickerupper),

                // drop ball
                new ToggleGrabber(BotSubsystems.pickerupper),
      
                // move back to shoot
                new MoveToStart(),

                // shoot
                new TogglePistons(BotSubsystems.pistonShooter)
            );
    }

}