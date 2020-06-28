package cn.guan;
/**
 * Speed util
 * @author Tiangang.guan
 */
import java.math.BigDecimal;

public class SpeedUtil {

    private static final String DIVIDEND_MESSAGE = " Dividend cannot be null or zero .";

    private static final String DISTANCE_MESSAGE = " the distance is less than the speed and cannot complete a lap.";

    /**
     * Get the time for a person to complete a lap (including intermediate breaks)
     *
     * @param perimeter    total perimeter
     * @param speed        speed
     * @param distanceRest distance to rest
     * @param breakTime    break time
     */
    public static BigDecimal getCompleteALapTime(BigDecimal perimeter,
                                                 BigDecimal speed,
                                                 BigDecimal distanceRest,
                                                 BigDecimal breakTime
    ) {
        BigDecimal noRestTime = perimeter.divide(speed, 6, BigDecimal.ROUND_HALF_DOWN);
        BigDecimal restTime = BigDecimal.ZERO;
        if (null != distanceRest && !BigDecimal.ZERO.equals(distanceRest)) {
            restTime = perimeter.divide(distanceRest, 6, BigDecimal.ROUND_HALF_DOWN).multiply(breakTime).setScale(6, BigDecimal.ROUND_DOWN);
        }
        return noRestTime.add(restTime).setScale(6, BigDecimal.ROUND_DOWN);
    }

    /**
     * Get average speed
     *
     * @param distance total distance
     * @param time     run of time
     * @return average speed
     */
    public static BigDecimal getAverageSpeed(BigDecimal distance, BigDecimal time) {
        if (BigDecimal.ZERO.equals(time))
            throw new IllegalArgumentException("Time value cannot be null, zero and negative");
        return distance.divide(time, 6, BigDecimal.ROUND_HALF_DOWN);
    }

    /**
     * Get the  speed difference
     *
     * @param speedA The A speed
     * @param speedB The B speed
     * @return speed difference
     */
    public static BigDecimal getSpeedDifference(BigDecimal speedA, BigDecimal speedB) {
        return speedA.subtract(speedB).abs().setScale(6, BigDecimal.ROUND_DOWN);
    }

    /**
     * Get the total time of meeting
     *
     * @param distance
     * @param numberOfEncounters number of encounters
     * @param speedDifference    speed difference
     */
    public static BigDecimal getAllTime(BigDecimal distance,
                                        Integer numberOfEncounters, BigDecimal speedDifference) {
        if (null == numberOfEncounters  || 0 == numberOfEncounters) {
            numberOfEncounters = 1;
        }
        if (null == speedDifference || BigDecimal.ZERO.equals(speedDifference))
            throw new IllegalArgumentException(DIVIDEND_MESSAGE);
        if(distance.compareTo(speedDifference) < 0){
            throw new IllegalArgumentException(DISTANCE_MESSAGE);
        }
        BigDecimal encounters = distance.multiply(new BigDecimal(numberOfEncounters));
        return encounters.divide(speedDifference, 2, BigDecimal.ROUND_HALF_DOWN);
    }

}
