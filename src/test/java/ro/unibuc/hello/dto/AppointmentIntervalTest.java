package ro.unibuc.hello.dto;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AppointmentIntervalTest {
    AppointmentInterval myAppointmentInterval = new AppointmentInterval("1", 5, 33);

    @Test
    public void test_Patient()
    {
        Assertions.assertSame("1", myAppointmentInterval.getId());
        Assertions.assertSame(5, myAppointmentInterval.getHour());
        Assertions.assertSame(33, myAppointmentInterval.getMinute());
    }
}
