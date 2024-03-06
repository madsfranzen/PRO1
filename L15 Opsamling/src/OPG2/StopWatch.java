package OPG2;

import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class StopWatch {
    private LocalTime startTime;
    private LocalTime endTime;

    public StopWatch() {
    }

    public void start() {
        startTime = LocalTime.now();
    }

    public void stop() {
        endTime = LocalTime.now();
    }

    public Long elapsedTime() {
        Long elapsedTime = ChronoUnit.SECONDS.between(startTime, endTime);
        return elapsedTime;
    }
}
