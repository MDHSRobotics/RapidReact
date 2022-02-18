
package frc.robot.commands.sensors;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.sensors.Pixy;

public class DetectNearestBall extends CommandBase {

    public DetectNearestBall() {
        Logger.setup("Constructing Command: DetectNearestBall...");

    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: DetectNearestBall...");
    }

    @Override
    public void execute() {
        Pixy.detectNearestBall();
    }

    // This command continues until interrupted
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: DetectNearestBall...");
        } else {
            Logger.ending("Ending Command: DetectNearestBall...");
        }
    }

}