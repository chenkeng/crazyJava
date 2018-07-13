

/**
 * Description:
 * 利嫋: <a href="http://www.crazyit.org">決髄Java選男</a><br>
 * Copyright (C), 2001-2018, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class CarSpeedMeter extends SpeedMeter
{
    private double radius;
    public CarSpeedMeter(double radius)
    {
        this.radius = radius;
    }
    public double calGirth(){
        return radius * 2 * Math.PI;
    }
    public static void main(String[] args)
    {
        CarSpeedMeter csm = new CarSpeedMeter(0.34);
        csm.setTurnRate(15);
        System.out.println(csm.getSpeed());
    }
}

