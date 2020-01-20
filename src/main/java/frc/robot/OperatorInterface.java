package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OperatorInterface {
    private double _driveCmd;
    private double _turnCmd;

    private Joystick _pilotJoy;
    private Joystick _copilotJoy;

    /**
     * Default constructor
     * 
     * Instantiates the Joystick objects with their correct channels based on constants contained
     * in the RobotConstants class, e.g. - 
     * 
     *      JOYSTICK_PORT_PILOT, JOYSTICK_PORT_COPILOT, ...
     * 
     * Also sets the default state of each variable to 0.0 or false, depending on the type.
     */
    public OperatorInterface() {

    }

    /**
     * Sets all variables back to their default state.
     */
    public void reset() {

    }

    /**
     * Returns the desired drive command for the robot, based on the most recent reading from the
     * joystick.
     * 
     * @return desired forward/backward command for the robot
     */
    public double getDriveCmd() {
        return 0.0;
    }

    /**
     * Returns the desired turn command for the robot, based on the most recent reading from the
     * joystick.
     * 
     * @return desired left/right turn command for the robot
     */
    public double getTurnCmd() {
        return 0.0;
    }

    /**
     * Updates the member variables of this class based on the input(s) they are associated with on
     * the joysticks.
     */
    public void update() {
        // For now, just worry about updating the drive and turn commands. Keep in mind that we
        // will be using the following conventions:
        //
        //      forward is positive for drive commands
        //      CCW is positive for turn commands
        //
        // The joysticks we will be using are as follows (both on the pilot controller):
        //
        //      drive - left stick y-axis
        //      turn - right stick x-axis
        //
        // You may need to do some tinkering (or look at last year's code) to reference the correct
        // axes.
    }
}
