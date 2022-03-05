package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.brains.AimBrain;
import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.relayLighter;

// Lighter subsystem, for turning lights on and off.
public class Lighter extends SubsystemBase {

    public Lighter() {
        Logger.setup("Constructing Subsystem: Lighter...");
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void turnOnBoth() {
        relayLighter.set(Relay.Value.kOn);
    }

    public void turnOffBoth() {
        relayLighter.set(Relay.Value.kOff);
    }

    public void turnOnWhiteOnly() {
        relayLighter.set(Relay.Value.kForward);
    }

    public void turnOnRedOnly() {
        relayLighter.set(Relay.Value.kReverse);
    }

    public void setLightsForAim(double heading, double frontDistance, double topDistance) {
        double h = heading;
        double nwN = AimBrain.getNwHeadingMin();
        double nwX = AimBrain.getNwHeadingMax();
        double neN = AimBrain.getNeHeadingMin();
        double neX = AimBrain.getNeHeadingMax();
        double swN = AimBrain.getSwHeadingMin();
        double swX = AimBrain.getSwHeadingMax();
        double seN = AimBrain.getSeHeadingMin();
        double seX = AimBrain.getSeHeadingMax();
        boolean headingInRange = (h >= nwN && h <= nwX) ||
                                 (h >= neN && h <= neX) ||
                                 (h >= swN && h <= swX) ||
                                 (h >= seN && h <= seX);
        boolean frontInRange = (frontDistance >= AimBrain.getFrontDistanceMin() && frontDistance <= AimBrain.getFrontDistanceMax());

        if (frontInRange) {
            Logger.info("Lighter -> SetLightsForAim -> Distance: " + frontDistance + " -> Distance In Range!");
            if (headingInRange) {
                Logger.info("Lighter -> SetLightsForAim -> Heading: " + heading + " -> Heading In Range!");
                turnOnBoth();
            }
            else {
                turnOnRedOnly();
            }
        }
        else {
            turnOffBoth();
        }
    }

}