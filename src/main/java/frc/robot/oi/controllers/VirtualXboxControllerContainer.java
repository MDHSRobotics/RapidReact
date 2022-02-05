
package frc.robot.oi.controllers;

import frc.robot.oi.controllers.DPadButton.Direction;
import frc.robot.oi.positions.ThumbstickPosition;
import frc.robot.oi.positions.TriggerAxisPosition;

// This class contains a virtual xbox controller and properties for all its virtual buttons.
public class VirtualXboxControllerContainer implements XboxPositionAccessible {

    public VirtualXboxController xbox;
    public VirtualButton btnA;
    public VirtualButton btnB;
    public VirtualButton btnX;
    public VirtualButton btnY;
    public VirtualButton btnBumperLeft;
    public VirtualButton btnBumperRight;
    public VirtualButton btnBack;
    public VirtualButton btnStart;
    public VirtualButton btnStickLeft;
    public VirtualButton btnStickRight;
    public DPad btnDpad;
    public DPadButton btnDpadUp;
    public DPadButton btnDpadDown;
    public DPadButton btnDpadLeft;
    public DPadButton btnDpadRight;
    public DPadButton btnDpadUpLeft;
    public DPadButton btnDpadUpRight;
    public DPadButton btnDpadDownLeft;
    public DPadButton btnDpadDownRight;

    public VirtualXboxControllerContainer() {
        xbox = new VirtualXboxController();
        btnA = new VirtualButton();
        btnB = new VirtualButton();
        btnX = new VirtualButton();
        btnY = new VirtualButton();
        btnBumperLeft = new VirtualButton();
        btnBumperRight = new VirtualButton();
        btnBack = new VirtualButton();
        btnStart = new VirtualButton();
        btnStickLeft = new VirtualButton();
        btnStickRight = new VirtualButton();
        btnDpad = new DPad(xbox);
        btnDpadUp = new DPadButton(xbox, Direction.UP);
        btnDpadDown = new DPadButton(xbox, Direction.DOWN);
        btnDpadLeft = new DPadButton(xbox, Direction.LEFT);
        btnDpadRight = new DPadButton(xbox, Direction.RIGHT);
        btnDpadUpLeft = new DPadButton(xbox, Direction.UP_LEFT);
        btnDpadUpRight = new DPadButton(xbox, Direction.UP_RIGHT);
        btnDpadDownLeft = new DPadButton(xbox, Direction.DOWN_LEFT);
        btnDpadDownRight = new DPadButton(xbox, Direction.DOWN_RIGHT);
    }

    public void reset() {
        xbox.resetInputs();
        btnA.active = false;
        btnB.active = false;
        btnX.active = false;
        btnY.active = false;
        btnBumperLeft.active = false;
        btnBumperRight.active = false;
        btnBack.active = false;
        btnStart.active = false;
        btnStickLeft.active = false;
        btnStickRight.active = false;
    }

    // Gets the raw virtual xbox thumbstick positions
    public ThumbstickPosition getThumbstickPositions(boolean isYleftFlipped) {
        double yLeft = xbox.getLeftY(); // Forward & backward, flipped
        double xLeft = xbox.getLeftX(); // Strafe
        double yRight = xbox.getRightY(); // Forward & backward, flipped
        double xRight = xbox.getRightX(); // Rotate

        ThumbstickPosition pos = new ThumbstickPosition(yLeft, xLeft, yRight, xRight);
        return pos;
    }

    // Gets the raw virtual xbox trigger positions
    public TriggerAxisPosition getTriggerAxisPositions() {
        double leftTriggerAxis = xbox.getLeftTriggerAxis();
        double rightTriggerAxis = xbox.getRightTriggerAxis();

        TriggerAxisPosition pos = new TriggerAxisPosition(leftTriggerAxis, rightTriggerAxis);
        return pos;
    }

}
