package frc.robot;

import edu.wpi.first.wpilibj.Victor;

public class Intake {
    private double _upCmd;
    private double _downCmd;

    private Victor _motorUL;
    private Victor _motorUR;

    public Intake() {
        this._motorUL = new Victor(RobotConstants.MOTOR_CHANNEL_UL);
        this._motorUR = new Victor(RobotConstants.MOTOR_CHANNEL_UR);

        this._motorUL.setInverted(RobotConstants.MOTOR_VERT_INVERT_L);
        this._motorUR.setInverted(RobotConstants.MOTOR_VERT_INVERT_R);
    }
    public void reset() {
        this.setCommands(0.0, 0.0);
    }
    public void setCommands(double upCmd, double downCmd) {
        this._upCmd = upCmd;
        this._downCmd = downCmd;
    }
    public void update() {
        double upTrn = Util.limit(this._upCmd - this._downCmd,-1.0, 1.0);
        double downTrn = Util.limit(this._upCmd + this._downCmd,-1.0, 1.0);

        this._motorUL.set(upTrn);
        this._motorUR.set(downTrn);
    }
}