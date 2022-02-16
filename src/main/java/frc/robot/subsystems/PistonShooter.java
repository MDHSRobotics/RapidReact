package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.subsystems.Devices.*;

public class PistonShooter extends SubsystemBase{

    private boolean pistonState = false;

    public PistonShooter() {
        pcmCompressor.enableDigital();
        solenoidLeft.set(false);
        solenoidRight.set(false);
    }

    public void togglePistons() {
        if (pistonState) {
            solenoidLeft.set(false);
            solenoidRight.set(false);
        } else {
            solenoidLeft.set(true);
            solenoidRight.set(true);
        }

        pistonState = !pistonState;
    }
}

