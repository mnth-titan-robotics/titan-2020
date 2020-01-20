package frc.robot;

import edu.wpi.first.wpilibj.Talon;

public class DriveSystem {
    private double _driveCmd;
    private double _turnCmd;

    private Talon _motorFL;
    private Talon _motorFR;
    private Talon _motorRL;
    private Talon _motorRR;

    /**
     * Default constructor
     * 
     * Instantiates the motor Talon objects with their correct channels and inversion state based
     * on constants contained in the RobotConstants class, e.g. -
     * 
     *      MOTOR_CHANNEL_FL, MOTOR_CHANNEL_FR, ...
     *      MOTOR_INVERTED_FL, MOTOR_INVERTED_FR, ...
     * 
     * Also sets the commands to 0.0 by default.
     */
    public DriveSystem() {

    }

    /**
     * Sets the commands to 0.0 and makes sure all motors are also set to 0.0.
     */
    public void reset() {

    }

    /**
     * Updates the drive and turn commands used to command the motors based on an external input.
     * 
     * @param drive desired forward/backward command for the robot in the range [-1.0, 1.0]
     * @param turn desired left/right command for the robot in the range [-1.0, 1.0]
     */
    public void setCommands(double drive, double turn) {

    }

    /**
     * Commands the motors based on the most recently provided drive and turn commands. The
     * output for each motor on the robot are as follows:
     * 
     *      left side: (drive - turn)
     *      right side: (drive + turn)
     * 
     *      s.t. - all motor commands are in the range [-1.0, 1.0]
     *             drive is positive in the forward direction
     *             turn is positive in the CCW direction
     * 
     * It is encouraged that you re-derive the equations to convince yourself that they are true.
     */
    public void update() {

    }
}
