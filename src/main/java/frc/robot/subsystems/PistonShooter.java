package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.subsystems.Devices.*;

public class PistonShooter extends SubsystemBase{

    public PistonShooter() {
        pcmCompressor.enableDigital();
        //pcmCompressor.disable();
        solenoidOne.set(false);
        solenoidTwo.set(false);
        solenoidThree.set(false);
    }

    public void shootPistons() {
        solenoidOne.set(true);
        solenoidTwo.set(true);
        solenoidThree.set(true);

    }

    public void retractPistons() { 
        solenoidOne.set(false);
        solenoidTwo.set(false);
        solenoidThree.set(false);

    }
}

