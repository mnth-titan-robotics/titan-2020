package frc.robot;

import edu.wpi.first.wpilibj.Victor;

public class DriveSystem {
    private double _driveCmd;
    private double _turnCmd;
    //Initialization of variables
    private Victor _motorFL;
    private Victor _motorFR;
    private Victor _motorRL;
    private Victor _motorRR;

    //MOTOR_CHANNEL_FL, MOTOR_CHANNEL_FR, ...
    //MOTOR_INVERTED_FL, MOTOR_INVERTED_FR, ...
    public DriveSystem() {
        this._motorFL = new Victor(RobotConstants.MOTOR_CHANNEL_FL);
        this._motorFR = new Victor(RobotConstants.MOTOR_CHANNEL_FR);
        this._motorRL = new Victor(RobotConstants.MOTOR_CHANNEL_RL);
        this._motorRR = new Victor(RobotConstants.MOTOR_CHANNEL_RR);
        
        this._motorFL.setInverted(RobotConstants.MOTOR_DRIVE_INVERT_L);
        this._motorFR.setInverted(RobotConstants.MOTOR_DRIVE_INVERT_R);
        this._motorRL.setInverted(RobotConstants.MOTOR_DRIVE_INVERT_L);
        this._motorRR.setInverted(RobotConstants.MOTOR_DRIVE_INVERT_R);
        this.reset();
    }
    public void reset() {
        RobotConstants.TURB = false;
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
        if(RobotConstants.TURB = false){
            double leftTrn = Util.limit(this._driveCmd - this._turnCmd,-0.7, 0.7);
            double rightTrn = Util.limit(this._driveCmd + this._turnCmd,-0.7, 0.7);
    
            this._motorFL.set(leftTrn);
            this._motorFR.set(rightTrn);
            this._motorRL.set(leftTrn);
            this._motorRR.set(rightTrn);
        }
        else{
            if(RobotConstants.TURB = true){
                double leftTrn = Util.limit(this._driveCmd - this._turnCmd, -0.7, 0.7);
                double rightTrn = Util.limit(this._driveCmd + this._turnCmd, -0.7, 0.7);
    
                this._motorFL.set(leftTrn);
                this._motorFR.set(rightTrn);
                this._motorRL.set(leftTrn);
                this._motorRR.set(rightTrn);
            }
        }

    }
}
