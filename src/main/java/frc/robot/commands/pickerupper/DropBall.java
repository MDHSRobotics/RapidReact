package frc.robot.commands.pickerupper;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.PickerUpper;


public class DropBall extends CommandBase {

    private PickerUpper m_pickup;
    private Timer m_timer;
    private double m_targetTime = 0;

    public DropBall(PickerUpper pickup) {
        Logger.setup("Constructing Command: DropBall...");

        // Add given subsystem requirements
        m_pickup = pickup;
        m_timer = new Timer();
        addRequirements(m_pickup);
    }

    //set target time to 0 if timed command not needed
    public DropBall(PickerUpper pickup, double timeInSeconds) {
        Logger.setup("Constructing Command: DropBall...");

        // Add given subsystem requirements
        m_pickup = pickup;
        m_timer = new Timer();
        m_targetTime = timeInSeconds;
        addRequirements(m_pickup);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: DropBall...");
        m_timer.reset();
        m_timer.start();
        
        m_pickup.dropBall();
    }

    //real code
    @Override
    public void execute() {

    }

    // This command continues until it cycles through the set number of cycles
    @Override
    public boolean isFinished() {
        double currentTime = m_timer.get();

        if (m_targetTime != 0) {
            if (currentTime > m_targetTime) {
                return true;
            } else {
                return false;
            }
        } 

        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: DropBall...");
        } else {
            Logger.ending("Ending Command: DropBall...");
        }
    }

}
