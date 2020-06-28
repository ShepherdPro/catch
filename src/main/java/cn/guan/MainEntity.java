package cn.guan;

import java.math.BigDecimal;

public class MainEntity {

    public static void main(String[] args) {
        BigDecimal perimeter = new BigDecimal(800);
        Integer numberOfEncounters = 1;
        BigDecimal speedA = new BigDecimal(40);
        BigDecimal speedB = new BigDecimal(60);
        BigDecimal distanceRest = new BigDecimal(200);
        BigDecimal breakTime = new BigDecimal(2);

        BigDecimal timeOfLapA = SpeedUtil.getCompleteALapTime(perimeter, speedA, distanceRest, breakTime);
        BigDecimal timeOfLapB = SpeedUtil.getCompleteALapTime(perimeter, speedB, distanceRest, breakTime);

        BigDecimal averageSpeedA = SpeedUtil.getAverageSpeed(perimeter, timeOfLapA);
        BigDecimal averageSpeedB = SpeedUtil.getAverageSpeed(perimeter, timeOfLapB);

        BigDecimal difference = SpeedUtil.getSpeedDifference(averageSpeedA, averageSpeedB);
        BigDecimal time = SpeedUtil.getAllTime(perimeter, numberOfEncounters, difference);
        System.out.println(" the two runners first meet time is :" + time.toString());
    }

}
