
package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;

// This class contains all the shared NetworkTableEntries for the Swerve Drive Subsystem,
// their default values, and methods for retrieving their current values.
public class SwerveDriverBrain {

    //----------------//
    // Default Values //
    //----------------//

    public final static double defaultDrivePower = 0.;
    public final static double defaultTicks = 0.;
    public final static double defaultVelocity = 0.;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry entryDrivePowerFL;
    public static NetworkTableEntry entryDrivePowerFR;
    public static NetworkTableEntry entryDrivePowerRL;
    public static NetworkTableEntry entryDrivePowerRR;

    public static NetworkTableEntry entryTurningPowerFL;
    public static NetworkTableEntry entryTurningPowerFR;
    public static NetworkTableEntry entryTurningPowerRL;
    public static NetworkTableEntry entryTurningPowerRR;  

    public static NetworkTableEntry entryDriveEncoderTicksFL;
    public static NetworkTableEntry entryDriveEncoderTicksFR;
    public static NetworkTableEntry entryDriveEncoderTicksRL;
    public static NetworkTableEntry entryDriveEncoderTicksRR;

    public static NetworkTableEntry entryDriveEncoderMpsFL;
    public static NetworkTableEntry entryDriveEncoderMpsFR;
    public static NetworkTableEntry entryDriveEncoderMpsRL;
    public static NetworkTableEntry entryDriveEncoderMpsRR;

    public static NetworkTableEntry entryTurningEncoderTicksFL;
    public static NetworkTableEntry entryTurningEncoderTicksFR;
    public static NetworkTableEntry entryTurningEncoderTicksRL;
    public static NetworkTableEntry entryTurningEncoderTicksRR;

    public static NetworkTableEntry entryTurningEncoderMpsFL;
    public static NetworkTableEntry entryTurningEncoderMpsFR;
    public static NetworkTableEntry entryTurningEncoderMpsRL;
    public static NetworkTableEntry entryTurningEncoderMpsRR;

    //---------//
    // Setters //
    //---------//

    public static void setModuleDrivePower(String moduleName, double value) {

        switch (moduleName) {
            case "Front Left":
                entryDrivePowerFL.setDouble(value);
                break;
            case "Front Right":
                //entryDrivePowerFR.setDouble(value);
                break;
            case "Rear Left":
                //entryDrivePowerRL.setDouble(value);
                break;
            case "Rear Right":
                //entryDrivePowerRR.setDouble(value);
                break;

            default:
                throw new java.lang.Error(String.format("Unknown module name %s", moduleName));
        }
    }

    public static void setModuleTurningPower(String moduleName, double value) {

        switch (moduleName) {
            case "Front Left":
                entryTurningPowerFL.setDouble(value);
                break;
            case "Front Right":
                //entryTurningPowerFR.setDouble(value);
                break;
            case "Rear Left":
                //entryTurningPowerRL.setDouble(value);
                break;
            case "Rear Right":
                //entryTurningPowerRR.setDouble(value);
                break;

            default:
                throw new java.lang.Error(String.format("Unknown module name %s", moduleName));
        }   
    }


    public static void setModuleEncoderReadings(String moduleName, double [] encoderSettings) {

        switch (moduleName) {
            case "Front Left":
                entryDriveEncoderTicksFL.setDouble(encoderSettings[0]);
                entryDriveEncoderMpsFL.setDouble(encoderSettings[1]);
                entryTurningEncoderTicksFL.setDouble(encoderSettings[2]);
                entryTurningEncoderMpsFL.setDouble(encoderSettings[3]);
                break;
            case "Front Right":
                //entryDriveEncoderTicksFR.setDouble(encoderSettings[0]);
                //entryDriveEncoderMpsFR.setDouble(encoderSettings[1]);
                break;
            case "Rear Left":
                //entryDriveEncoderTicksRL.setDouble(encoderSettings[0]);
                //entryDriveEncoderMpsRL.setDouble(encoderSettings[1]);
                break;
            case "Rear Right":
                //entryDriveEncoderTicksRR.setDouble(encoderSettings[0]);
                //entryDriveEncoderMpsRR.setDouble(encoderSettings[1]);
                break;

            default:
                throw new java.lang.Error(String.format("Unknown module name %s", moduleName));
        }

    }

    
    //---------//
    // Getters //
    //---------//
}
