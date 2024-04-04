package ro.unibuc.hello.dto;

import org.assertj.core.api.LocalDateAssert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

public class AppointmentTest {
    Patient myPatient = new Patient("1", "Gigi");
    Doctor myDoctor = new Doctor("1", "Gabi", "Neurolog");
    AppointmentInterval myAppointmentInterval = new AppointmentInterval("1", 5, 33);
    LocalDate myDate = LocalDate.now().plusDays(20);
    Appointment myAppointment = new Appointment("1", myAppointmentInterval, myDoctor, myPatient, myDate);

    @Test
    public void test_Appointment() {
        Assertions.assertSame("1", myAppointment.getId());
        Assertions.assertSame(myAppointmentInterval, myAppointment.getAppointmentInterval());
        Assertions.assertSame(myDoctor, myAppointment.getDoctor());
        Assertions.assertSame(myPatient, myAppointment.getPatient());
        Assertions.assertSame(myDate, myAppointment.getDate());
    }

}
