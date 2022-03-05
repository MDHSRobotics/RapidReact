package frc.robot.commands.lighter;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.BotSensors;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.Lighter;

import frc.robot.sensors.DistanceSensor;

// This command toggles the "Lighter" lights from certain sensor states
public class LightByDistance extends CommandBase {

    private Lighter m_lighter;

    public LightByDistance(Lighter lighter) {
        Logger.setup("Constructing Command: LightByDistance...");

        // Add given subsystem requirements
        m_lighter = lighter;
        addRequirements(m_lighter);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: LightByDistance...");
    }

    @Override
    public void execute() {
        double heading = BotSensors.gyro.getAngle();
        double frontDistance = DistanceSensor.getDistanceInMeters(BotSensors.distanceSensorFront);
        double topDistance = DistanceSensor.getDistanceInMeters(BotSensors.distanceSensorTop);
        m_lighter.setLightsForAim(heading, frontDistance, topDistance);
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
            Logger.ending("Interrupting Command: LightByDistance...");
        } else {
            Logger.ending("Ending Command: LightByDistance...");
        }

        Logger.action("LightByDistance -> Turning off both lights");
        m_lighter.turnOffBoth();
    }

}