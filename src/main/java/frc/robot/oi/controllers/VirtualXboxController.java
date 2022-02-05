
package frc.robot.oi.controllers;

import edu.wpi.first.wpilibj.GenericHID;
import frc.robot.oi.controllers.DPadButton.Direction;

// A virtual xbox controller for simulating analog inputs.
public class VirtualXboxController extends GenericHID {

    public double xLeft;
    public double yLeft;
    public double xRight;
    public double yRight;
    public boolean dpadActive;
    public Direction dpadDirection;
    public double triggerAxisLeft;
    public double triggerAxisRight;

    public VirtualXboxController() {
        this(-1);
    }

    private VirtualXboxController(int port) {
        super(port);
        resetInputs();
    }

    public void resetInputs() {
        xLeft = 0.0;
        yLeft = 0.0;
        xRight = 0.0;
        yRight = 0.0;
        dpadActive = false;
        dpadDirection = Direction.UP;
        triggerAxisLeft = 0.0;
        triggerAxisRight = 0.0;
    }

    
    public double getLeftX() {
        return xLeft;
    }

    public double getLeftY() {
        return yLeft;
    }

    public double getRightX() {
        return xRight;
    }

    public double getRightY() {
        return yRight;
    }

    @Override
    public int getPOV(int pov) {
        if (!dpadActive) return -1;
        return dpadDirection.degrees;
    }

    public double getLeftTriggerAxis() {
        return triggerAxisLeft;
    }

    public double getRightTriggerAxis() {
        return triggerAxisRight;
            
    }

}
