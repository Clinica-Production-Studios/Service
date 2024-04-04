package ro.unibuc.hello.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ro.unibuc.hello.data.AppointmentRepository;
import ro.unibuc.hello.dto.Appointment;
import ro.unibuc.hello.dto.AppointmentInterval;
import ro.unibuc.hello.dto.Doctor;
import ro.unibuc.hello.dto.Patient;
import ro.unibuc.hello.exception.EntityNotFoundException;

@SpringBootTest
@Tag("IT")
class AppointmentServiceTestIT {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired  
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentIntervalService appointmentIntervalService;

    @Test
    void testCreateAndGetAppointment() {
        Doctor doctor = new Doctor(null, "Gabi Dragan", "Neurolog");
        Doctor createdDoctor = doctorService.createDoctor(doctor);

        Patient patient = new Patient(null, "Gabi Dragan");
        Patient createdPatient = patientService.createPatient(patient);

        AppointmentInterval appointmentInterval = new AppointmentInterval(null, 2, 30);
        AppointmentInterval createdAppointmentInterval = appointmentIntervalService.createAppointmentInterval(appointmentInterval);

        Appointment appointment = new Appointment(null, createdAppointmentInterval, createdDoctor, createdPatient, LocalDate.now());
        Appointment createdAppointment = appointmentService.createAppointment(appointment);

        Appointment retrievedAppointment = appointmentService.getAppointmentById(createdAppointment.getId());

        assertNotNull(retrievedAppointment);
        assertEquals(createdAppointment.getDoctor().getId(), retrievedAppointment.getDoctor().getId());
    }

    @Test
    void testGetAllAppointments() {

        Doctor doctor1 = new Doctor(null, "Gabi Dragan", "Neurolog");
        Doctor createdDoctor1 = doctorService.createDoctor(doctor1);

        Patient patient1 = new Patient(null, "Andrei");
        Patient createdPatient1 = patientService.createPatient(patient1);

        AppointmentInterval appointmentInterval1 = new AppointmentInterval(null, 2, 30);
        AppointmentInterval createdAppointmentInterval1 = appointmentIntervalService.createAppointmentInterval(appointmentInterval1);

        Appointment appointment1 = new Appointment(null, createdAppointmentInterval1, createdDoctor1, createdPatient1, LocalDate.now());



        Doctor doctor2 = new Doctor(null, "Marian", "Chrirug");
        Doctor createdDoctor2 = doctorService.createDoctor(doctor2);

        Patient patient2 = new Patient(null, "Andreea");
        Patient createdPatient2 = patientService.createPatient(patient2);

        AppointmentInterval appointmentInterval2 = new AppointmentInterval(null, 3, 15);
        AppointmentInterval createdAppointmentInterval2 = appointmentIntervalService.createAppointmentInterval(appointmentInterval2);

        Appointment appointment2 = new Appointment(null, createdAppointmentInterval2, createdDoctor2, createdPatient2, LocalDate.now());

        appointmentService.createAppointment(appointment1);
        appointmentService.createAppointment(appointment2);

        List<Appointment> appointments = appointmentService.getAllAppointments();

        assertEquals(5, appointments.size());
    }

    @Test
    void testUpdateAppointment() {
        Doctor doctor = new Doctor(null, "Gabi Dragan", "Neurolog");
        Doctor createdDoctor = doctorService.createDoctor(doctor);

        Patient patient = new Patient(null, "Gabi Dragan");
        Patient createdPatient = patientService.createPatient(patient);

        AppointmentInterval appointmentInterval = new AppointmentInterval(null, 2, 30);
        AppointmentInterval createdAppointmentInterval = appointmentIntervalService.createAppointmentInterval(appointmentInterval);

        Appointment appointment = new Appointment(null, createdAppointmentInterval, createdDoctor, createdPatient, LocalDate.now());
        Appointment createdAppointment = appointmentService.createAppointment(appointment);

        Doctor doctorUpdate = new Doctor(null, "Gigel", "Chirurg plastician");
        Doctor createdDoctorUpdate = doctorService.createDoctor(doctorUpdate);

        createdAppointment.setDoctor(createdDoctorUpdate);
        Appointment updatedAppointment = appointmentService.updateAppointment(createdAppointment);

        assertEquals(createdDoctorUpdate.getId(), updatedAppointment.getDoctor().getId());
    }

    @Test
    void testDeleteAppointment()
    {
        Doctor doctor = new Doctor(null, "Gabi Dragan", "Neurolog");
        Doctor createdDoctor = doctorService.createDoctor(doctor);

        Patient patient = new Patient(null, "Gabi Dragan");
        Patient createdPatient = patientService.createPatient(patient);

        AppointmentInterval appointmentInterval = new AppointmentInterval(null, 2, 30);
        AppointmentInterval createdAppointmentInterval = appointmentIntervalService.createAppointmentInterval(appointmentInterval);

        Appointment appointment = new Appointment(null, createdAppointmentInterval, createdDoctor, createdPatient, LocalDate.now());
        Appointment createdAppointment = appointmentService.createAppointment(appointment);

        Assertions.assertEquals(createdAppointment.getDoctor().getId(), appointmentService.getAppointmentById(createdAppointment.getId()).getDoctor().getId());

        appointmentService.deleteAppointment(createdAppointment.getId());

        assertThrows(EntityNotFoundException.class, () -> appointmentService.getAppointmentById(createdAppointment.getId()));
    }
}