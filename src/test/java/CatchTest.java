import cn.guan.SpeedUtil;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

public class CatchTest {

    private static final String MESSAGE_SHOULD_BE_THE_SAME = "Should be the same.";

    @BeforeAll
    static void initAll() {
        System.out.println("==Tests  Begin==");
    }

    @BeforeEach
    void init() {
    }

    @Test
    public void completeALapTimeTest(){
        BigDecimal expected = new BigDecimal(12.000000).setScale(6);
        BigDecimal perimeter  = new BigDecimal(800);
        BigDecimal speed = new BigDecimal(200);
        BigDecimal distanceRest = new BigDecimal(100);
        BigDecimal breakTime = BigDecimal.ONE;
        BigDecimal completeALapTime = SpeedUtil.getCompleteALapTime(perimeter, speed, distanceRest, breakTime);
        Assertions.assertEquals(expected, completeALapTime, MESSAGE_SHOULD_BE_THE_SAME);

        BigDecimal completeALapTime2 = SpeedUtil.getCompleteALapTime(perimeter, speed, distanceRest, new BigDecimal(2));
        BigDecimal expected1 = new BigDecimal(20.000000).setScale(6);
        Assertions.assertEquals(expected1, completeALapTime2, MESSAGE_SHOULD_BE_THE_SAME);
    }

    /**
     * test the average speed
     */
    @Test
    public void averageSpeedTest(){
        BigDecimal distance  = new BigDecimal(800);
        BigDecimal speed = new BigDecimal(200);
        BigDecimal expected = new BigDecimal(4.000000).setScale(6);
        BigDecimal averageSpeed = SpeedUtil.getAverageSpeed(distance, speed);
        Assertions.assertEquals(expected, averageSpeed, MESSAGE_SHOULD_BE_THE_SAME);
    }

    /**
     * test the speed difference
     */
    @Test
    public void speedDifferenceTest(){
        BigDecimal speed1  = new BigDecimal(800);
        BigDecimal speed2 = new BigDecimal(200);
        BigDecimal expected = new BigDecimal(600.000000).setScale(6);

        BigDecimal difference = SpeedUtil.getSpeedDifference(speed1, speed2);
        Assertions.assertEquals(expected, difference, MESSAGE_SHOULD_BE_THE_SAME);

        BigDecimal difference1 = SpeedUtil.getSpeedDifference(speed2, speed1);
        Assertions.assertEquals(expected, difference1, MESSAGE_SHOULD_BE_THE_SAME);
    }

    @Test
    public void getAllTimeTest(){
        BigDecimal distance  = new BigDecimal(800);
        Integer numberOfEncounters = 0;
        BigDecimal speedDifference  = new BigDecimal(20);
        BigDecimal expected = new BigDecimal(40.00).setScale(2);

        BigDecimal difference = SpeedUtil.getAllTime(distance, numberOfEncounters,speedDifference);
        Assertions.assertEquals(expected, difference, MESSAGE_SHOULD_BE_THE_SAME);

        BigDecimal distance1  = new BigDecimal(900);
        Integer numberOfEncounters1 = 2;
        BigDecimal speedDifference1  = new BigDecimal(45);
        BigDecimal expected1 = new BigDecimal(40.00).setScale(2);

        BigDecimal difference1 = SpeedUtil.getAllTime(distance1, numberOfEncounters1,speedDifference1);
        Assertions.assertEquals(expected1, difference1, MESSAGE_SHOULD_BE_THE_SAME);
    }

    @AfterEach
    void destroy() {
    }

    @AfterAll
    static void destroyedAll() {
        System.out.println("--==Tests Destroyed==--");
    }

}
