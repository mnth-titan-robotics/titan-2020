package frc.robot;

//Recycled Class from 2019 to prevent false values being inputed into the motor controller.
public class MaxCalc {
    public static double limit(double value, double min, double max)
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