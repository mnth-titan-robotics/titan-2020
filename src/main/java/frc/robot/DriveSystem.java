package frc.robot;

import edu.wpi.first.wpilibj.Talon;

public class DriveSystem {
    private double _driveCmd;
    private double _turnCmd;
    //Initialization of variables
    private Talon _motorFL;
    private Talon _motorFR;
    private Talon _motorRL;
    private Talon _motorRR;

    //MOTOR_CHANNEL_FL, MOTOR_CHANNEL_FR, ...
    //MOTOR_INVERTED_FL, MOTOR_INVERTED_FR, ...
    public DriveSystem() {
        this._motorFL = new Talon(RobotConstants.MOTOR_CHANNEL_FL);
        this._motorFR = new Talon(RobotConstants.MOTOR_CHANNEL_FR);
        this._motorRL = new Talon(RobotConstants.MOTOR_CHANNEL_RL);
        this._motorRR = new Talon(RobotConstants.MOTOR_CHANNEL_RR);
        
        this._motorFL.setInverted(RobotConstants.MOTOR_DRIVE_INVERT_L);
        this._motorFR.setInverted(RobotConstants.MOTOR_DRIVE_INVERT_R);
        this._motorRL.setInverted(RobotConstants.MOTOR_DRIVE_INVERT_L);
        this._motorRR.setInverted(RobotConstants.MOTOR_DRIVE_INVERT_R);
        this.reset();
    }
    public void reset() {
        this.setCommands(0.0, 0.0);
    }

     //@param drive desired forward/backward command for the robot in the range [-1.0, 1.0]
     //@param turn desired left/right command for the robot in the range [-1.0, 1.0]

    public void setCommands(double driveCmd, double turnCmd) {
        this._driveCmd = driveCmd;
        this._turnCmd = turnCmd;
    }
    //left is drive - turn
    //right is drive + turn
    public void update() {
        double leftTrn = Util.limit(this._driveCmd - this._turnCmd,-1.0, 1.0);
        double rightTrn = Util.limit(this._driveCmd + this._turnCmd,-1.0, 1.0);

        this._motorFL.set(leftTrn);
        this._motorFR.set(rightTrn);
        this._motorRL.set(leftTrn);
        this._motorRR.set(rightTrn);
    }
}
