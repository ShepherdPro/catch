package cn.guan;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class MainEntity {

    private static final Logger logger = LoggerFactory.getLogger(MainEntity.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        logger.info("-------------------------------------");
        logger.info("--- == This is a RUNNING CATCH TEST== --");
        logger.info("-------------------------------------");

        BigDecimal perimeter = new BigDecimal(800);
        Integer numberOfEncounters = 1;
        BigDecimal speedA = new BigDecimal(40);
        BigDecimal speedB = new BigDecimal(60);
        BigDecimal distanceRest = new BigDecimal(200);
        BigDecimal breakTime = new BigDecimal(2);

        BigDecimal timeOfLapA = SpeedUtil.getCompleteALapTime(perimeter, speedA, distanceRest, breakTime);
        logger.info("Time Of Lap A is:"+timeOfLapA);
        BigDecimal timeOfLapB = SpeedUtil.getCompleteALapTime(perimeter, speedB, distanceRest, breakTime);
        logger.info("Time Of Lap B is:"+timeOfLapB);

        BigDecimal averageSpeedA = SpeedUtil.getAverageSpeed(perimeter, timeOfLapA);
        logger.info("Average speed of A is:"+averageSpeedA);
        BigDecimal averageSpeedB = SpeedUtil.getAverageSpeed(perimeter, timeOfLapB);
        logger.info("Average speed of B is:"+averageSpeedB);

        BigDecimal difference = SpeedUtil.getSpeedDifference(averageSpeedA, averageSpeedB);
        logger.info("Speed difference is:"+difference);
        BigDecimal time = SpeedUtil.getAllTime(perimeter, numberOfEncounters, difference);
        logger.info("The time it takes B to catch up with A on the first lap is :"+time);
    }

}
