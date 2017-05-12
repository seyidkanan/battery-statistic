/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.kanan.batterystat.database;

import az.kanan.batterystat.model.Battery;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Kanan
 */
public interface Query {

    List<Battery> getTrackedInfo(Date startDate, Date endDate);

    void insertNewTrack(Battery baterry);

}
