
package frc.robot.commands.sparkmaxtester;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.SparkMaxTester;

public class Test extends CommandBase {

    private SparkMaxTester m_sparkMaxTester;

    public Test(SparkMaxTester sparkMaxTester) {
        Logger.setup("Constructing Command: SpinPickup...");

        // Add given subsystem requirements
        m_sparkMaxTester = sparkMaxTester;
        addRequirements(m_sparkMaxTester);

    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: SpinPickupAndConveyor...");
    }

    @Override
    public void execute() {
        m_sparkMaxTester.sparkMaxDrive();
    }

    // This command continues until interrupted
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: SpinPickupAndConveyor...");
        } else {
            Logger.ending("Ending Command: SpinPickupAndConveyor...");
        }
    }

}