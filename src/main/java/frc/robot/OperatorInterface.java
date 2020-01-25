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
        this._pilotJoy = new Joystick(RobotConstants.JOYSTICK_PORT_PILOT);
        this._copilotJoy = new Joystick(RobotConstants.JOYSTICK_PORT_COPILOT);

        this.reset();
    }

    /**
     * Sets all variables back to their default state.
     */
    public void reset() {
        this._driveCmd = 0.0;
        this._turnCmd = 0.0;
    }

    /**
     * Returns the desired drive command for the robot, based on the most recent reading from the
     * joystick.
     * 
     * @return desired forward/backward command for the robot
     */
    public double getDriveCmd() {
        return this._driveCmd;
    }

    /**
     * Returns the desired turn command for the robot, based on the most recent reading from the
     * joystick.
     * 
     * @return desired left/right turn command for the robot
     */
    public double getTurnCmd() {
        return this._turnCmd;
    }

    /**
     * Updates the member variables of this class based on the input(s) they are associated with on
     * the joysticks.
     */
    public void update() {
        if(Math.abs(-this._pilotJoy.getRawAxis(RobotConstants.AXIS_DRIVE)) < RobotConstants.DeadBand){
            this._driveCmd = (0.0);
        }
        else{
            this._driveCmd = -this._pilotJoy.getRawAxis(RobotConstants.AXIS_DRIVE);
        }
        if(Math.abs(-this._pilotJoy.getRawAxis(RobotConstants.AXIS_TURN)) < RobotConstants.DeadBand){
            this._turnCmd = (0.0);
        }
        else{
            this._driveCmd = -this._pilotJoy.getRawAxis(RobotConstants.AXIS_TURN);
        }
    }

        //We will be inverting the RawAxis to set a standard for how the robot drives:
        //By default forward on the joystick is negative, and we want that to be positive, same with left and right. We want them reversed

        //      forward is positive for drive commands
        //      CCW is positive for turn commands
        // The joysticks we will be using are as follows (both on the pilot controller):
        //      drive - left stick y-axis
        //      turn - right stick x-axis
}