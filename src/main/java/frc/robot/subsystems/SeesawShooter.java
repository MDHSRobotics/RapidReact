package frc.robot.subsystems;
import java.util.*;
import static frc.robot.RobotManager.isReal;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.brains.ShooterBrain;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.utils.*;
import static frc.robot.subsystems.Devices.talonSrxSeeSawShooter;

//Shooter subsystem for shooting ball with single wheel through seesaw mechanic 
public class SeesawShooter extends SubsystemBase{
    // Encoder constants
    private static final boolean SENSOR_PHASE = true;
    private static final boolean MOTOR_INVERT = false;

    //Positive constants 
    private static final double GEAR_RATIO = 4.0; // Gear ratio bewteen Input Shaft : Output Shaft of a gearbox

    public SeesawShooter(){
        Logger.setup("Constructing Subsystem: Shooter...");
        if (isReal) {
            // Configure devices
            PIDValues pidSeeSaw = new PIDValues(0.00835, 0.0, 0.0, 0.0);
            TalonUtils.configureBaseTalon(talonSrxSeeSawShooter, MOTOR_INVERT);
        }
        
    }

    public void shoot(){
        talonSrxSeeSawShooter.set(1.0);
    }

    public void stopShoot(){
        talonSrxSeeSawShooter.stopMotor();
    }

}

        