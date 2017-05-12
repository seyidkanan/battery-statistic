/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.kanan.batterystat.database;

/**
 *
 * @author Kanan
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDB {

    public Connection getConnection() {
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/baterry_stat?useSSL=false", "login", "password");
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return myConn;
    }

    public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException {
        if (con.isClosed() == false) {
            con.close();
        }
        if (ps.isClosed() == false) {
            ps.close();
        }
        if (rs.isClosed() == false) {
            rs.close();
        }
    }

}
