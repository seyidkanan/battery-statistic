package az.kanan.batterystat.task;

import java.util.Date;
import java.util.Timer;

public class Schedulers {

    long delay = 5 * 60 * 1000; //delay in milliseconds//delay is 5 min
    LoopTask task = new LoopTask();
    Timer timer = new Timer("TaskName");

    public void start() {
        timer.cancel();
        timer = new Timer("TaskName");
        Date executionDate = new Date();
        timer.scheduleAtFixedRate(task, executionDate, delay);
    }

}
