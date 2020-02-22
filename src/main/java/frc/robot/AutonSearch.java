//Near the middle is around 300 - 350 pixels
package frc.robot;


public class AutonSearch {
    public static double middle(double balx, double cmd)
    {
        cmd = 0.0;
        if(balx < RobotConstants.XLOWER)
        {
            cmd = RobotConstants.XLOWER - balx;
            return cmd;
        }
        else if(balx > RobotConstants.XUPPER)
        {
            cmd = RobotConstants.XUPPER - balx;
            return cmd;
        }
        return cmd;
    }

    public static double interpret(double cmd, double turncmd)
    {
        turncmd = 0.0;
        if(cmd < 0.0)
        {
            turncmd = -0.1;
            return turncmd;
        }
        else if(cmd > 0.0)
        {
            turncmd = 0.1;
            return turncmd;
        }
        return turncmd;
    }
}