
package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;

// This class contains all the shared NetworkTableEntries for Aiming,
// their default values, and methods for retrieving their current values.
public class AimBrain {

    //----------------//
    // Default Values //
    //----------------//

    public static double frontDistanceMinDefault = .3;
    public static double frontDistanceMaxDefault = 1;
    public static double topDistanceMinDefault = .3;
    public static double topDistanceMaxDefault = 1;

    public static double nwHeadingMinDefault = -40;
    public static double nwHeadingMaxDefault = -50;
    public static double neHeadingMinDefault = 40;
    public static double neHeadingMaxDefault = 50;
    public static double swHeadingMinDefault = -130;
    public static double swHeadingMaxDefault = -140;
    public static double seHeadingMaxDefault = 130;
    public static double seHeadingMinDefault = 140;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry frontDistanceMinEntry;
    public static NetworkTableEntry frontDistanceMaxEntry;
    public static NetworkTableEntry topDistanceMinEntry;
    public static NetworkTableEntry topDistanceMaxEntry;

    public static NetworkTableEntry nwHeadingMinEntry;
    public static NetworkTableEntry nwHeadingMaxEntry;
    public static NetworkTableEntry neHeadingMinEntry;
    public static NetworkTableEntry neHeadingMaxEntry;
    public static NetworkTableEntry swHeadingMinEntry;
    public static NetworkTableEntry swHeadingMaxEntry;
    public static NetworkTableEntry seHeadingMinEntry;
    public static NetworkTableEntry seHeadingMaxEntry;

    //---------//
    // Setters //
    //---------//



    //---------//
    // Getters //
    //---------//

    public static double getFrontDistanceMin() {
        return frontDistanceMinEntry.getDouble(frontDistanceMinDefault);
    }

    public static double getFrontDistanceMax() {
        return frontDistanceMaxEntry.getDouble(frontDistanceMaxDefault);
    }

    public static double getTopDistanceMin() {
        return topDistanceMinEntry.getDouble(topDistanceMinDefault);
    }

    public static double getTopDistanceMax() {
        return topDistanceMaxEntry.getDouble(topDistanceMaxDefault);
    }

    public static double getNwHeadingMin() {
        return nwHeadingMinEntry.getDouble(nwHeadingMinDefault);
    }

    public static double getNwHeadingMax() {
        return nwHeadingMaxEntry.getDouble(nwHeadingMaxDefault);
    }

    public static double getNeHeadingMin() {
        return nwHeadingMinEntry.getDouble(nwHeadingMinDefault);
    }

    public static double getNeHeadingMax() {
        return neHeadingMaxEntry.getDouble(neHeadingMaxDefault);
    }

    public static double getSwHeadingMin() {
        return swHeadingMinEntry.getDouble(swHeadingMinDefault);
    }

    public static double getSwHeadingMax() {
        return swHeadingMaxEntry.getDouble(swHeadingMaxDefault);
    }

    public static double getSeHeadingMin() {
        return seHeadingMinEntry.getDouble(seHeadingMinDefault);
    }

    public static double getSeHeadingMax() {
        return seHeadingMaxEntry.getDouble(seHeadingMaxDefault);
    }

}
