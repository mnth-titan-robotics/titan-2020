package frc.robot;


public class RobotConstants {
    //Drive System
    public static final int MOTOR_CHANNEL_FL = 1;
    public static final int MOTOR_CHANNEL_FR = 2;
    public static final int MOTOR_CHANNEL_RL = 3;
    public static final int MOTOR_CHANNEL_RR = 4;

    public static final boolean MOTOR_DRIVE_INVERT_L = false;
    public static final boolean MOTOR_DRIVE_INVERT_R = true;

    //Intake

    public static final int MOTOR_CHANNEL_UL = 7;
    public static final int MOTOR_CHANNEL_UR = 8;

    public static final boolean MOTOR_VERT_INVERT_UL = false;
    public static final boolean MOTOR_VERT_INVERT_UR = false;

    //Hang

    public static final int MOTOR_CHANNEL_U = 6;

    public static final boolean MOTOR_VERT_INVERT_U = false;

    public static final int AXIS_VERT = 2;


    //Operator Interface
    public static final int JOYSTICK_PORT_PILOT = 0;
    public static final int JOYSTICK_PORT_COPILOT = 1;

    public static final int AXIS_DRIVE = 1;
    public static final int AXIS_TURN = 4;

    public static final int AXIS_UPP = 1;
    public static final int AXIS_LOW = 5;

    public static final int AXIS_TURB = 3;
    public static boolean TURB = false;

    //DeadBand
    public static final double DEADBAND = 0.05;

    //Vision
    public static final double XLOWER = 300;
    public static final double XUPPER = 350;

}
    