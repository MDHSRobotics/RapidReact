package frc.robot.subsystems;

import frc.robot.devices.*;

import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.wpilibj.Servo;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

// This class contains singleton (static) instances of id mapped subsystem components.
// If a device is not connected at initialization, it should be set to null.
// IMPORTANT: Only ONE subsystem should control any given device.
// Device instances are package-private (neither private nor public) so they can only be used by subsystems.
public class Devices {

    //////////////////////
    // Device Instances //
    //////////////////////

    // Shooter
    public static DevTalonSRX talonSrxShooterBottomWheel = new DevTalonSRX("talonSrxShooterBottomWheel", 17);
    public static DevTalonSRX talonSrxShooterTopWheel = new DevTalonSRX("talonSrxShooterTopWheel", 40);

    // Pickup
    public static DevTalonSRX talonSrxPickupRight = new DevTalonSRX("talonSrxPickupRight", 10);
    public static DevTalonSRX talonSrxPickupLeft = new DevTalonSRX("talonSrxPickupLeft", 4);
    public static DevTalonSRX talonSrxPickupGrabber = new DevTalonSRX("talonSrxPickupGrabber", 0);

    // Delivery
    public static DevTalonSRX talonSrxDeliveryRight = new DevTalonSRX("talonSrxDeliveryRight", 16);
    public static DevTalonSRX talonSrxDeliveryLeft = new DevTalonSRX("talonSrxDeliveryLeft", 7);

    //Climb
    public static DevTalonSRX talonSrxClimberRight = new DevTalonSRX("talonSrxClimberRight", 5);
    public static DevTalonSRX talonSrxClimberLeft = new DevTalonSRX("talonSrxClimberLeft", 0);


    // Sensors
    public static Servo servoGate = new Servo(1);

    // Pneumatics
    public static Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
    public static Solenoid solenoidLeft = new Solenoid(PneumaticsModuleType.CTREPCM, 2);
    public static Solenoid solenoidRight = new Solenoid(PneumaticsModuleType.CTREPCM, 3);

    // SwerveModule
    public static DevTalonFX talonFxSwerveDriveFL = new DevTalonFX("talonFxSwerveDriveWheelFrontLeft", 28);
    public static DevTalonFX talonFxSwerveDriveFR = new DevTalonFX("talonFxSwerveDriveWheelFrontRight", 26);
    public static DevTalonFX talonFxSwerveDriveRL = new DevTalonFX("talonFxSwerveDriveWheelRearLeft", 31);
    public static DevTalonFX talonFxSwerveDriveRR = new DevTalonFX("talonFxSwerveDriveWheelRearRight", 25);
    public static DevTalonFX talonFxSwerveTurnFL = new DevTalonFX("talonFxSwerveTurnWheelFrontLeft", 30);
    public static DevTalonFX talonFxSwerveTurnFR = new DevTalonFX("talonFxSwerveTurnWheelFrontRight", 32);
    public static DevTalonFX talonFxSwerveTurnRL = new DevTalonFX("talonFxSwerveTurnWheelRearLeft", 27);
    public static DevTalonFX talonFxSwerveTurnRR = new DevTalonFX("talonFxSwerveTurnWheelRearRight", 29);

    public static CANCoder canCoderFR = new CANCoder(4);
    public static CANCoder canCoderFL = new CANCoder(2);
    public static CANCoder canCoderRR = new CANCoder(3);
    public static CANCoder canCoderRL = new CANCoder(1);
}
