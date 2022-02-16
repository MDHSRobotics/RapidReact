
package frc.robot.subsystems.utils;

import java.lang.Math;

// Utility methods to convert to/from encoder units

public class EncoderTranslator {

    // The amount of native ticks per revolution (TPR)
    final private int m_TPR;

    public EncoderTranslator(String encoderType) {

        if (encoderType.equals("TalonFX")) {
            // TalonFX motors have build-in encoders
            m_TPR = 2048;
        } 
        else if (encoderType.equals("TalonSRX")) {
            // TalonFX motors have build-in encoders
            m_TPR = 4096;
        }
        else {
            throw new java.lang.Error(String.format("EncoderTranslator was given unknown encoder type %s", encoderType));
        }
    }

    /** Computes an encoder tick count based on the desired motor rotation in degrees for a given gearbox ratio (MS : GS)
     * @param angleDegrees Desired angle to compute to ticks
     * @param gearRatio The gear ratio of the gearbox
     * @return Returns the angle computed to ticks
    */
    public int degrees_to_ticks(double angleDegrees, double gearRatio) {
        double rotationCountGS = angleDegrees / 360.0; // Amount of rotations on the gearbox shaft
        double rotationCountMS = rotationCountGS * gearRatio; // Amount of rotations on the motor shaft
        double rotationTicks = rotationCountMS * m_TPR; // Amount of ticks to rotate
        return (int) (rotationTicks);
    }

    /** Computes an encoder tick count based on the desired distance in inches for a given wheel diameter and gearbox ratio (MS : GS)
     * @param distanceInches The desired distance in inches
     * @param wheelDiameterInches The diameter of the wheel in inches
     * @param gearRatio The gear ratio of the gearbox
     * @return Returns the amount of ticks to move a certain distance
    */
    public int inches_to_ticks(double distanceInches, double wheelDiameterInches, double gearRatio) {
        double wheelCircumferenceInches = Math.PI * wheelDiameterInches;
        double rotationCountGS = distanceInches / wheelCircumferenceInches; // Amount of rotations on the gearbox shaft
        double rotationCountMS = rotationCountGS * gearRatio; // Amount of rotations on the motor shaft
        double rotationTicks = rotationCountMS * m_TPR; // Amount of ticks to rotate
        return (int) rotationTicks;
    }
    
    /** Converts ticks to inches ased on wheel diameter
     * @param rotationTicks The amount of ticks to rotate
     * @param wheelDiameterInches The diameter of the wheel in inches
     * @return Returns the distance in inches
    */
    public double ticks_to_inches(double rotationTicks, double wheelDiameterInches){
        double wheelCircumferenceInches = Math.PI * wheelDiameterInches;
        double distanceInches = (rotationTicks/m_TPR)*wheelCircumferenceInches;
        return distanceInches;
    }

    /**
     * Converts MPS (meters per second) to TPHMS (ticks per hundred millisecondse)
     * @param mps
     * @param wheelDiameterMeters
     * @return
     */
    public double metersPerSecond_to_ticksPerDecisecond(double mps, double wheelDiameterMeters) {

        // Take the MPS and dividing it by the cirfcumference to find the ratio. 
        // After finding the ratio,  multiply by the ticks per rotation to get ticks per second. 
        // Convert to per hundred milliseconds
        double wheelCircumferenceMeters = wheelDiameterMeters * Math.PI;
        double tphms = ((mps / wheelCircumferenceMeters) * m_TPR) / 10;
        return tphms;
    }

    /**
     * Converts TPHMS (ticks per hundred milliseconds) to MPS (meters per second)
     * @param tphms
     * @param wheelDiameterMeters
     * @return
     */
    public double ticksPerDecisecond_to_metersPerSecond(double tphms, double wheelDiameterMeters) {
        double wheelCircumferenceMeters = wheelDiameterMeters * Math.PI;
        double mps = ((tphms * wheelCircumferenceMeters) / m_TPR) * 10;
        return mps;
    }

    /** Computes an encoder velocity tick count based on the desired velocity in feet per second for a given wheel diameter and gearbox ratio (MS : GS)
     * @param fps The velocity in feet per second
     * @param wheelDiameterInches The diameter of the wheel in inches
     * @param gearRatio The gear ratio of the gearbox
     * @return Returns ticksPerDecisecond
    */
    public int feetPerSecond_to_ticksPerDecisecond(double fps, double wheelDiameterInches, double gearRatio) {
        double wheelCircumferenceFeet = Math.PI * (wheelDiameterInches / 12.0);
        double rotationsPerSecondGS = fps / wheelCircumferenceFeet; // Amount of rotations per second on the gearbox shaft
        double rotationsPerSecondMS = rotationsPerSecondGS * gearRatio; // Amount of rotations per second on the motor shaft
        double ticksPerDecisecond = rotationsPerSecondMS * m_TPR / 10.0; // Amount of ticks per decisecond on the motor shaft
        return (int) ticksPerDecisecond;
    }

    /** Computes a velocity in feet per second based on the ticksPerDecisecond for a given wheelDiameter and gearboxration (MS: GS)
     * @param ticksPerDecisecond Amount of ticks per decisecond to rotate
     * @param wheelDiameterInches The diameter of the wheel in inches
     * @param gearRatio The gear ratio of the gearbox
     * @return Returns feet per second
     */
    public double ticksPerDecisecond_to_feetPerSecond(double ticksPerDecisecond, double wheelDiameterInches, double gearRatio){
        double rotationsPerSecondMS = ticksPerDecisecond / m_TPR * 10.0;
        double rotationsPerSecondGS = rotationsPerSecondMS / gearRatio;
        double wheelCircumferenceFeet = Math.PI * (wheelDiameterInches / 12.0);
        double fps = rotationsPerSecondGS * wheelCircumferenceFeet;
        return fps;
    }

    /** Computes an encoder velocity tick count based on the desired rotations per second and the gearbox ratio (MS : GS)
     * @param rps Amount of rps on the gearbox shaft
     * @param gearRatio The gear ratio of the gearbox
     * @return Returns ticksPerDecisecond as an int
    */
    public int rotationsPerSecond_to_ticksPerDecisecond(double rps, double gearRatio) {
        double rotationsPerDecisecondGS = rps / 10.0; // Amount of rpds on the gearbox shaft
        double rotationsPerDecisecondMS = rotationsPerDecisecondGS * gearRatio; // Amount of rpds on the motor shaft
        double ticksPerDecisecond = rotationsPerDecisecondMS * m_TPR; // Amount of ticks per decisecond to rotate
        return (int) ticksPerDecisecond;
    }

    /**Computes ticks to radians
     * @param ticks tick integer that is computed to radian value
     * @return Returns the desired radian value
    */
    public double ticks_to_radians(double ticks) {
        double radians = ticks / m_TPR * 2 * Math.PI;
        return radians;
    }

    /**Computes radians to ticks
     * @param radians radian value that is computed to a tick integer
     * @return Returns the desired tick integer
    */
    public int radians_to_ticks(double radians) {
        int ticks = (int) (radians * m_TPR / 2 / Math.PI);
        return ticks;
    }

    /**Computes ticks per hundred miliseconds to radians per second
     * @param ticksPDS tick per hundred milisecond
     * @return radiansPerSecond Returns the desired radians per second
    */
    public double ticksPerDecisecond_to_RadiansPerSecond(double ticksPDS) {
        double radiansPerSecond = (ticksPDS * 1000 * 2 * Math.PI) / (m_TPR * 100) ;
        return radiansPerSecond;
    }

    /**Computes MPS (meters per second) to radians per second
     * @param MPS meters persecond
     * @param wheelDiameterMeters
     * @return ticksPerDecisecond Returns the desired ticks per hundred milliseconds
    */
	public int metersPerSecond_to_ticksPerDecisecond(double mps, double wheelDiameterMeters, double gearRatio) {
        double wheelCircumferenceMeters = Math.PI * (wheelDiameterMeters);
        double rotationsPerSecondGS = mps / wheelCircumferenceMeters; // Amount of rotations per second on the gearbox shaft
        double rotationsPerSecondMS = rotationsPerSecondGS * gearRatio; // Amount of rotations per second on the motor shaft
        double ticksPerDecisecond = rotationsPerSecondMS * m_TPR / 10.0; // Amount of ticks per decisecond on the motor shaft
        return (int) ticksPerDecisecond;
	}
}
