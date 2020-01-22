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
        this._motorRL = new Talon(RobotConstants.MOTOR_INVERTED_FL);
        this._motorRR = new Talon(RobotConstants.MOTOR_INVERTED_RR);

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
    //left is drive + turn
    //right is drive - turn
    public void update() {
        double leftTrn = MaxCalc.limit(this._driveCmd + this._turnCmd,-1.0, 1.0);
        double rightTrn = MaxCalc.limit(this._driveCmd - this._turnCmd,-1.0, 1.0);

        this._motorFL.set(leftTrn);
        this._motorFR.set(leftTrn);
        this._motorRL.set(rightTrn);
        this._motorRR.set(rightTrn);
    }
}
