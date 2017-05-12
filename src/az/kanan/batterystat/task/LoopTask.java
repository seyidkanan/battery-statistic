/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.kanan.batterystat.task;

import az.kanan.batterystat.database.QueriesImpl;
import az.kanan.batterystat.model.Battery;
import az.kanan.batterystat.util.Kernel32;
import java.util.TimerTask;

/**
 *
 * @author Kanan
 */
public class LoopTask extends TimerTask {

    @Override
    public void run() {
        Kernel32.SYSTEM_POWER_STATUS batteryStatus = new Kernel32.SYSTEM_POWER_STATUS();
        Kernel32.INSTANCE.GetSystemPowerStatus(batteryStatus);

        QueriesImpl qImpl = new QueriesImpl();

        Battery baterry = new Battery();
        baterry.setBatteryLife(Integer.parseInt(batteryStatus.getBatteryLifePercent().replace("%", "")));
        baterry.setmACLineStatus(batteryStatus.getACLineStatusString());

        qImpl.insertNewTrack(baterry);
    }

}
