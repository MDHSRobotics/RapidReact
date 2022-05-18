package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.sparkMaxOne;;

public class SparkMaxTester extends SubsystemBase {

    public SparkMaxTester() {
         Logger.setup("Constructing Subsystem: Pickup...");
    }

    public void sparkMaxDrive() {
        sparkMaxOne.set(0.5);
    }

}
