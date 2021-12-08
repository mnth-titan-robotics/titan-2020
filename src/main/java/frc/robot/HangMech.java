package frc.robot;

import edu.wpi.first.wpilibj.Victor;

public class HangMech {
    private double _VertCmd;

    private Victor _motorU;
    public HangMech() {
        this._motorU = new Victor(RobotConstants.MOTOR_CHANNEL_U);

        this._motorU.setInverted(RobotConstants.MOTOR_VERT_INVERT_U);
    }
    public void reset() {
        this.setCommands(0.0);
    }
    public void setCommands(double VertCmd) {
        this._VertCmd = VertCmd;
    }
    public void update() {
        double Trn = this._VertCmd;

        this._motorU.set(Trn);
    }
}