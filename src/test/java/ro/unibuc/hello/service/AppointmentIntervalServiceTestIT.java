package ro.unibuc.hello.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ro.unibuc.hello.data.AppointmentIntervalRepository;
import ro.unibuc.hello.dto.AppointmentInterval;
import ro.unibuc.hello.exception.EntityNotFoundException;

@SpringBootTest
@Tag("IT")
class AppointmentIntervalServiceTestIT {

    @Autowired
    AppointmentIntervalRepository appointmentIntervalRepository;

    @Autowired  
    private AppointmentIntervalService appointmentIntervalService;

    @Test
    void testCreateAndGetAppointmentInterval() {
        AppointmentInterval appointmentInterval = new AppointmentInterval(null, 2, 30);

        AppointmentInterval createdAppointmentInterval = appointmentIntervalService.createAppointmentInterval(appointmentInterval);

        AppointmentInterval retrievedAppointmentInterval = appointmentIntervalService.getAppointmentIntervalById(createdAppointmentInterval.getId());

        assertNotNull(retrievedAppointmentInterval);
        assertEquals(appointmentInterval.getMinute(), retrievedAppointmentInterval.getMinute());
    }

    @Test
    void testGetAllAppointmentIntervals() {

        AppointmentInterval appointmentInterval1 = new AppointmentInterval(null, 2, 30);

        AppointmentInterval appointmentInterval2 = new AppointmentInterval(null, 4, 10);

        appointmentIntervalService.createAppointmentInterval(appointmentInterval1);
        appointmentIntervalService.createAppointmentInterval(appointmentInterval2);

        List<AppointmentInterval> appointmentIntervals = appointmentIntervalService.getAllAppointmentIntervals();

        assertEquals(4, appointmentIntervals.size());
    }

    @Test
    void testUpdateAppointmentInterval() {

        AppointmentInterval appointmentInterval = new AppointmentInterval(null, 2, 30);

        AppointmentInterval createdAppointmentInterval = appointmentIntervalService.createAppointmentInterval(appointmentInterval);

        createdAppointmentInterval.setHour(5);
        AppointmentInterval updatedAppointmentInterval = appointmentIntervalService.updateAppointmentInterval(createdAppointmentInterval);

        assertEquals(5, updatedAppointmentInterval.getHour());
    }

    @Test
    void testDeleteAppointmentInterval()
    {
        AppointmentInterval appointmentInterval = new AppointmentInterval(null, 2, 30);
        AppointmentInterval createdAppointmentInterval = appointmentIntervalService.createAppointmentInterval(appointmentInterval);
        Assertions.assertEquals(createdAppointmentInterval.getHour(), appointmentIntervalService.getAppointmentIntervalById(createdAppointmentInterval.getId()).getHour());

        appointmentIntervalService.deleteAppointmentInterval(createdAppointmentInterval.getId());

        assertThrows(EntityNotFoundException.class, () -> appointmentIntervalService.getAppointmentIntervalById(createdAppointmentInterval.getId()));
    }
}