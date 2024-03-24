package ro.unibuc.hello.data;

import org.springframework.data.annotation.Id;

public class AppointmentIntervalEntity {
    @Id
    public String id;
    public int hour;
    public int minute;

    public AppointmentIntervalEntity() {
    }

    public AppointmentIntervalEntity(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public String toString() {
        return String.format(
                "IntervalHour[id='%s', hour='%d', minute='%d']",
                id, hour, minute);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
