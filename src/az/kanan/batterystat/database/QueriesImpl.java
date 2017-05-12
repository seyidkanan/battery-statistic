/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.kanan.batterystat.database;

import az.kanan.batterystat.model.Battery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QueriesImpl implements Query {

    ConnectionDB connectionDB = new ConnectionDB();

    //select * from baterry_track where date BETWEEN '2017-05-12 06:54:49' AND '2017-05-12 06:59:13'
    @Override
    public List<Battery> getTrackedInfo(Date startDate, Date endDate) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select id,life,ACLineStatus,date from battery_track";
        if (startDate != null && endDate != null) {
            sql += " where date BETWEEN ? AND ?";
        }

        List<Battery> baterryTrackList = new ArrayList<>();
        try {
            c = connectionDB.getConnection();
            if (c.isClosed() == false) {
                ps = c.prepareStatement(sql);
                if (startDate != null && endDate != null) {
                    ps.setTimestamp(1, castFrom(startDate));
                    ps.setTimestamp(2, castFrom(endDate));
                }
                rs = ps.executeQuery();
                while (rs.next()) {
                    baterryTrackList.add(new Battery(rs.getLong("id"),
                            rs.getTimestamp("date"),
                            rs.getString("ACLineStatus"),
                            rs.getInt("life")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connectionDB.closeConnection(c, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(QueriesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return baterryTrackList;

    }

    @Override
    public void insertNewTrack(Battery baterry) {
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "insert into battery_track(life,ACLineStatus,date)\n"
                + "value(?,?,now())";
        c = connectionDB.getConnection();
        try {
            if (!c.isClosed()) {
                ps = c.prepareStatement(sql);
                ps.setInt(1, baterry.getBatteryLife());
                ps.setString(2, baterry.getmACLineStatus());
                ps.executeUpdate();
            } else {
                System.out.println("Connection is null");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connectionDB.closeConnection(c, ps, null);
            } catch (Exception e) {
            }
        }

    }

    private Timestamp castFrom(Date date) {
        return new Timestamp(date.getTime());
    }

}
