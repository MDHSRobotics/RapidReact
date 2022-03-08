
package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;
import java.util.Map;

import frc.robot.brains.AimBrain;

import frc.robot.consoles.ShuffleLogger;

// The Shuffleboard Aim tab.
public class AimTab {

    // Tab & Layouts
    private ShuffleboardTab m_tab;

    private ShuffleboardLayout m_distFrontLayout;
    private ShuffleboardLayout m_distTopLayout;
    private ShuffleboardLayout m_headingLayout;

    // Distance Sensor - Front
    private SimpleWidget m_frontDistanceMinWidget;
    private SimpleWidget m_frontDistanceMaxWidget;

    // Distance Sensor - Top
    private SimpleWidget m_topDistanceMinWidget;
    private SimpleWidget m_topDistanceMaxWidget;

    // Gyro - Heading
    private SimpleWidget nwHeadingMinWidget;
    private SimpleWidget nwHeadingMaxWidget;
    private SimpleWidget neHeadingMinWidget;
    private SimpleWidget neHeadingMaxWidget;
    private SimpleWidget swHeadingMinWidget;
    private SimpleWidget swHeadingMaxWidget;
    private SimpleWidget seHeadingMinWidget;
    private SimpleWidget seHeadingMaxWidget;

    // Constructor
    public AimTab() {
        ShuffleLogger.logTrivial("Constructing AimTab...");

        m_tab = Shuffleboard.getTab("Aim");

        m_distFrontLayout = m_tab.getLayout("Front Distance Sensor", BuiltInLayouts.kGrid);
        m_distFrontLayout.withPosition(0, 1);
        m_distFrontLayout.withSize(3, 1);
        m_distFrontLayout.withProperties(Map.of("Number of columns", 2));
        m_distFrontLayout.withProperties(Map.of("Number of rows", 2));
        m_distFrontLayout.withProperties(Map.of("Label position", "LEFT"));

        m_distTopLayout = m_tab.getLayout("Top Distance Sensor", BuiltInLayouts.kGrid);
        m_distTopLayout.withPosition(0, 2);
        m_distTopLayout.withSize(3, 1);
        m_distTopLayout.withProperties(Map.of("Number of columns", 2));
        m_distTopLayout.withProperties(Map.of("Number of rows", 2));
        m_distTopLayout.withProperties(Map.of("Label position", "LEFT"));

        m_headingLayout = m_tab.getLayout("Gyro Heading", BuiltInLayouts.kGrid);
        m_headingLayout.withPosition(0, 2);
        m_headingLayout.withSize(3, 1);
        m_headingLayout.withProperties(Map.of("Number of columns", 2));
        m_headingLayout.withProperties(Map.of("Number of rows", 2));
        m_headingLayout.withProperties(Map.of("Label position", "LEFT"));
    }

    // Create Brain Widgets
    public void preInitialize() {

        // Distance Sensor - Front
        m_frontDistanceMinWidget = m_distFrontLayout.add("Front Distance Min", AimBrain.frontDistanceMinDefault);
        AimBrain.frontDistanceMinEntry = m_frontDistanceMinWidget.getEntry();
        m_frontDistanceMinWidget.withWidget(BuiltInWidgets.kTextView);

        m_frontDistanceMaxWidget = m_distFrontLayout.add("Front Distance Max", AimBrain.frontDistanceMaxDefault);
        AimBrain.frontDistanceMaxEntry = m_frontDistanceMaxWidget.getEntry();
        m_frontDistanceMaxWidget.withWidget(BuiltInWidgets.kTextView);

        // Distance Sensor - Top
        m_topDistanceMinWidget = m_distTopLayout.add("Top Distance Min", AimBrain.topDistanceMinDefault);
        AimBrain.topDistanceMinEntry = m_topDistanceMinWidget.getEntry();
        m_topDistanceMinWidget.withWidget(BuiltInWidgets.kTextView);

        m_topDistanceMaxWidget = m_distTopLayout.add("Top Distance Max", AimBrain.topDistanceMaxDefault);
        AimBrain.topDistanceMaxEntry = m_topDistanceMaxWidget.getEntry();
        m_topDistanceMaxWidget.withWidget(BuiltInWidgets.kTextView);

        // Gyro - Heading
        nwHeadingMinWidget = m_headingLayout.add("NW Heading Min", AimBrain.nwHeadingMinDefault);
        AimBrain.nwHeadingMinEntry = nwHeadingMinWidget.getEntry();
        nwHeadingMinWidget.withWidget(BuiltInWidgets.kTextView);

        nwHeadingMaxWidget = m_headingLayout.add("NW Heading Max", AimBrain.nwHeadingMaxDefault);
        AimBrain.nwHeadingMaxEntry = nwHeadingMaxWidget.getEntry();
        nwHeadingMaxWidget.withWidget(BuiltInWidgets.kTextView);

        neHeadingMinWidget = m_headingLayout.add("NE Heading Min", AimBrain.neHeadingMinDefault);
        AimBrain.neHeadingMinEntry = neHeadingMinWidget.getEntry();
        neHeadingMinWidget.withWidget(BuiltInWidgets.kTextView);

        neHeadingMaxWidget = m_headingLayout.add("NE Heading Max", AimBrain.neHeadingMaxDefault);
        AimBrain.neHeadingMaxEntry = neHeadingMaxWidget.getEntry();
        neHeadingMaxWidget.withWidget(BuiltInWidgets.kTextView);

        swHeadingMinWidget = m_headingLayout.add("SW Heading Min", AimBrain.swHeadingMinDefault);
        AimBrain.swHeadingMinEntry = swHeadingMinWidget.getEntry();
        swHeadingMinWidget.withWidget(BuiltInWidgets.kTextView);

        swHeadingMaxWidget = m_headingLayout.add("SW Heading Max", AimBrain.swHeadingMaxDefault);
        AimBrain.swHeadingMaxEntry = swHeadingMaxWidget.getEntry();
        swHeadingMaxWidget.withWidget(BuiltInWidgets.kTextView);

        seHeadingMinWidget = m_headingLayout.add("SE Heading Min", AimBrain.seHeadingMinDefault);
        AimBrain.seHeadingMinEntry = seHeadingMinWidget.getEntry();
        seHeadingMinWidget.withWidget(BuiltInWidgets.kTextView);

        seHeadingMaxWidget = m_headingLayout.add("SE Heading Max", AimBrain.seHeadingMaxDefault);
        AimBrain.seHeadingMaxEntry = seHeadingMaxWidget.getEntry();
        seHeadingMaxWidget.withWidget(BuiltInWidgets.kTextView);
    }

    // Create all other Widgets
    public void initialize() {
    }

    // Configure all Widgets
    public void configure() {
    }

    // This will be called in the robotPeriodic
    public void update() {
    }

}
