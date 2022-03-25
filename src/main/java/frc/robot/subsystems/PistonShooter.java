package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.subsystems.Devices.*;

public class PistonShooter extends SubsystemBase{

    public PistonShooter() {
        pcmCompressor.enableDigital();
        //pcmCompressor.disable();
        solenoidLeft.set(false);
        solenoidRight.set(false);
    }

    public void shootPistons() {
        solenoidLeft.set(true);
        solenoidRight.set(true);
    }

    public void retractPistons() {
        solenoidLeft.set(false);
        solenoidRight.set(false);
    }
}

