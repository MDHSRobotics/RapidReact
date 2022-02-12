package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PistonShooter extends SubsystemBase{

    private Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
    private Solenoid solenoidLeft = new Solenoid(PneumaticsModuleType.CTREPCM, 2);
    private Solenoid solenoidRight = new Solenoid(PneumaticsModuleType.CTREPCM, 3);

    public PistonShooter() {
        solenoidLeft.set(false);
        solenoidLeft.setPulseDuration(0.01);
        solenoidLeft.startPulse();

        solenoidRight.set(false);
        solenoidRight.setPulseDuration(0.01);
        solenoidRight.startPulse();
    }

    public void togglePistons() {
        solenoidLeft.toggle();
        solenoidRight.toggle(); 
    }

    public void feedPistons() {
        pcmCompressor.enableAnalog(60, 60);
    }


}

