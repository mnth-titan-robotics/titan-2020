package frc.robot;

import edu.wpi.first.wpilibj.Talon;
public class MaxCalc {
    public static double limit(double final,double min,double max)
    {
        if(value >= max)
        {
            return max;
        }
        if(value <= min)
        {
            return min;
        }
        return value;
    }
}
public class DriveSystem {
    private double _driveCmd;
    private double _turnCmd;

    private Talon _motorFL;
    private Talon _motorFR;
    private Talon _motorRL;
    private Talon _motorRR;

    //MOTOR_CHANNEL_FL, MOTOR_CHANNEL_FR, ...
    //MOTOR_INVERTED_FL, MOTOR_INVERTED_FR, ...

    public DriveSystem() {
        this._motorFL = new Talon(RobotConstants.MOTOR_CHANNEL_FL);
        this._motorFR = new Talon(RobotConstants.MOTOR_CHANNEL_FR);
        this._motorRL = new Talon(RobotConstants.MOTOR_INVERTED_FL);
        this._motorRR = new Talon(RobotConstants.MOTOR_INVERTED_FR);

        this.reset();
    }
    public void reset() {
        this.setCommands(0.0, 0.0);
    }

     //@param drive desired forward/backward command for the robot in the range [-1.0, 1.0]
     //@param turn desired left/right command for the robot in the range [-1.0, 1.0]

    public void setCommands(double drive, double turn) {
        this._drive = drive;
        this._turn = turn;
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
     */
    public void update() {
        // It is encouraged that you re-derive the equations to convince yourself that they are true.
        double leftTrn = MaxCalc(this._drive + this._turn,-1.0, 1.0);
        double rightTrn = MaxCalc(this._drive - this._turn,-1.0, 1.0);

        this._motorFL.set(left);
        this._motorFR.set(left);
        this._motorRL.set(right);
        this._motorRR.set(right);
    }
}
