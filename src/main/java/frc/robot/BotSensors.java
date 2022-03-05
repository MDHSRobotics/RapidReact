
package frc.robot;

import static frc.robot.RobotManager.isReal;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2.LinkType;
import edu.wpi.first.wpilibj.AnalogInput;

import frc.robot.consoles.Logger;
import frc.robot.sensors.DistanceSensor;
import frc.robot.sensors.Gyro;
import frc.robot.sensors.Pixy;

// This class contains singleton instances of id mapped sensors.
public class BotSensors {

    // Attitude and Heading Reference Systems
    public static final AHRS gyro = new AHRS(SPI.Port.kMXP);

    // Analog Inputs
    public static final AnalogInput distanceSensorFront = new AnalogInput(0); // pins 3, 6 and 7 from MB1013 to analog input 0
    public static final AnalogInput distanceSensorTop = new AnalogInput(1); // pins 3, 6 and 7 from MB1013 to analog input 1

    // Pixy
    public static final Pixy2 pixy = Pixy2.createInstance(LinkType.SPI);

    // This initialization is called in RobotManager at startup.
    public static void initializeSensors() {
        Logger.setup("Initializing BotSensors...");
        if (isReal) {
            DistanceSensor.initializeDistanceSensor(distanceSensorFront);
            DistanceSensor.initializeDistanceSensor(distanceSensorTop);
            Gyro.initializeGyro(gyro);
            Pixy.initializePixy(pixy);

        } else {
            Logger.setup("Skipping initializion of sensors in Simulation mode...");
        }
    }

}
