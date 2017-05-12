package az.kanan.batterystat.model;

import java.util.Date;

public class Battery {

    private long id;
    private Date date;
    private String mACLineStatus;
    private int batteryLife;

    public Battery() {
    }

    public Battery(long id, Date date, String ACLineStatus, int batteryLife) {
        this.id = id;
        this.date = date;
        this.mACLineStatus = ACLineStatus;
        this.batteryLife = batteryLife;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getmACLineStatus() {
        return mACLineStatus;
    }

    public void setmACLineStatus(String aCLineStatus) {
        this.mACLineStatus = aCLineStatus;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    @Override
    public String toString() {
        return "Baterry{" + "id=" + id + ", date=" + date + ", aCLineStatus=" + mACLineStatus + ", batteryLife=" + batteryLife + '}';
    }
}
