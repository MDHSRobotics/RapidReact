
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.talonSrxDeliveryRight;
import static frc.robot.subsystems.Devices.talonSrxDeliveryLeft;

public class Delivery extends SubsystemBase {

    public Delivery() {
         Logger.setup("Constructing Subsystem: Delivery...");
    }

    public void stopDelivery() {
        talonSrxDeliveryRight.stopMotor();
        talonSrxDeliveryLeft.stopMotor();
    }

    public void spinDelivery() {
        talonSrxDeliveryRight.set(0.5);
        talonSrxDeliveryLeft.set(-0.5);
    }

}
