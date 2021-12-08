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

        this._motorUL.setInverted(RobotConstants.MOTOR_VERT_INVERT_UL);
        this._motorUR.setInverted(RobotConstants.MOTOR_VERT_INVERT_UR);

    }
    public void reset() {
        this.setCommands(0.0, 0.0);
    }
    public void setCommands(double upCmd, double downCmd) {
        this._upCmd = upCmd;
        this._downCmd = downCmd;
    }
    public void update() {
        double upTrn = this._upCmd;
        double downTrn = this._downCmd;

        this._motorUL.set(upTrn);
        this._motorUR.set(downTrn);
    }
}