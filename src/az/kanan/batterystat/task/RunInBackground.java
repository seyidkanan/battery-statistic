package az.kanan.batterystat.task;

public class RunInBackground implements Runnable {

    @Override
    public void run() {
        Schedulers schedulers = new Schedulers();
        schedulers.start();
    }

}
