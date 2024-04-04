package ro.unibuc.hello.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class AppointmentInterval {
    private String id;
    @Min(value = 0)
    @Max(value = 23)
    private int hour;
    @Min(value = 0)
    @Max(value = 59)
    private int minute;

    public AppointmentInterval() {
    }

    public AppointmentInterval(String id, int hour, int minute) {
        this.id = id;
        this.hour = hour;
        this.minute = minute;
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
