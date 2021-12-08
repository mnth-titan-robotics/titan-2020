package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OperatorInterface {
    private double _driveCmd;
    private double _turnCmd;
    private double _upCmd;
    private double _downCmd;
    private double _VertCmd;

    private double _upCmd;
    private double _downCmd;
    private double _VertCmd;


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
        this._upCmd = 0.0;
        this._downCmd = 0.0;
        this._VertCmd = 0.0;
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

    public double getUpCmd() {
        return this._upCmd;
    }

    public double getDownCmd() {
        return this._downCmd;
    }

    public double getVertCmd() {
        return this._VertCmd;
    }

    /**
     * Updates the member variables of this class based on the input(s) they are associated with on
     * the joysticks.
     */
    public void update() {
        this._driveCmd = -this._pilotJoy.getRawAxis(RobotConstants.AXIS_DRIVE);
        this._turnCmd = -this._pilotJoy.getRawAxis(RobotConstants.AXIS_TURN);
        this._upCmd = this._copilotJoy.getRawAxis(RobotConstants.AXIS_UPP);
        this._downCmd = this._copilotJoy.getRawAxis(RobotConstants.AXIS_LOW);
        this._VertCmd = this._copilotJoy.getRawAxis(RobotConstants.AXIS_VERT);

        if(Math.abs(this._pilotJoy.getRawAxis(RobotConstants.AXIS_TURB)) < 0.2){
            RobotConstants.TURB = false;
        }
        else{
            if(Math.abs(this._pilotJoy.getRawAxis(RobotConstants.AXIS_TURB)) > 0.2){
                RobotConstants.TURB = true;
            }  
        }

        //Hang mech
        if(Math.abs(this._VertCmd) < RobotConstants.DEADBAND){
            this._VertCmd = (-0.2);
        }
        if(Math.abs(this._VertCmd) > RobotConstants.DEADBAND){
            this._VertCmd = this._VertCmd;
        }

        if(Math.abs(this._driveCmd) < RobotConstants.DEADBAND){
            this._driveCmd = (0.0);
        }
        else{
            this._driveCmd = this._driveCmd;
        }
        if(Math.abs(this._turnCmd) < RobotConstants.DEADBAND){
            this._turnCmd = (0.0);
        }
        else{
            this._turnCmd = this._turnCmd;
        }
        if(Math.abs(this._upCmd) < RobotConstants.DEADBAND){
            this._upCmd = (0.0);
        }
        else{
            this._upCmd = this._upCmd;
        }
        if(Math.abs(this._downCmd) < RobotConstants.DEADBAND){
            this._downCmd = (0.0);
        }
        else{
            this._downCmd = this._downCmd;
        }
    }

        /** old hang code
        this._upCmd = this._copilotJoy.getRawButton(RobotConstants.AXIS_UPP);
        this._downCmd = this._copilotJoy.getRawButton(RobotConstants.AXIS_LOW);
        
        if(Math.abs(this._driveCmd) < RobotConstants.DEADBAND){
            this._driveCmd = (0.0);
        }
        else{
            this._driveCmd = this._driveCmd;
        }
        if(Math.abs(this._turnCmd) < RobotConstants.DEADBAND){
            this._turnCmd = (0.0);
        }
        else{
            this._turnCmd = this._turnCmd;
        }
    }
    old hang code*/


        //We will be inverting the RawAxis to set a standard for how the robot drives:
        //By default forward on the joystick is negative, and we want that to be positive, same with left and right. We want them reversed

        //      forward is positive for drive commands
        //      CCW is positive for turn commands
        // The joysticks we will be using are as follows (both on the pilot controller):
        //      drive - left stick y-axis
        //      turn - right stick x-axis
}