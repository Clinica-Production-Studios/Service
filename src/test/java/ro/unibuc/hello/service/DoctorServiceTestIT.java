package ro.unibuc.hello.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import ro.unibuc.hello.data.DoctorRepository;
import ro.unibuc.hello.dto.Appointment;
import ro.unibuc.hello.dto.AppointmentInterval;
import ro.unibuc.hello.dto.Doctor;
import ro.unibuc.hello.dto.Patient;
import ro.unibuc.hello.exception.EntityNotFoundException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Tag("IT")
class DoctorServiceTestIT {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired  
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentIntervalService appointmentIntervalService;

    @Test
    void testCreateAndGetDoctor() {
        Doctor doctor = new Doctor(null, "Marius", "Chirurg");

        Doctor createdDoctor = doctorService.createDoctor(doctor);

        Doctor retrievedDoctor = doctorService.getDoctorById(createdDoctor.getId());

        assertNotNull(retrievedDoctor);
        assertEquals(doctor.getName(), retrievedDoctor.getName());
    }

    @Test
    void testGetAllDoctors() {

        Doctor doctor1 = new Doctor(null, "Gabi Dragan", "Neurolog");

        Doctor doctor2 = new Doctor(null, "Gabriela Dragan", "Chirurg");

        doctorService.createDoctor(doctor1);
        doctorService.createDoctor(doctor2);

        List<Doctor> doctors = doctorService.getAllDoctors();

        assertEquals(6, doctors.size());
    }

    @Test
    void testUpdateDoctor() {

        Doctor doctor = new Doctor(null, "Gabi Dragan", "Neurolog");

        Doctor createdDoctor = doctorService.createDoctor(doctor);

        createdDoctor.setName("Gabitzu Dragan");
        Doctor updatedDoctor = doctorService.updateDoctor(createdDoctor);

        assertEquals("Gabitzu Dragan", updatedDoctor.getName());
    }

    @Test
    void testDeleteDoctor()
    {
        Doctor doctor = new Doctor(null, "Gabi Dragan", "Neurolog");
        Doctor createdDoctor = doctorService.createDoctor(doctor);
        Assertions.assertEquals(createdDoctor.getName(), doctorService.getDoctorById(createdDoctor.getId()).getName());

        doctorService.deleteDoctor(createdDoctor.getId());

        assertThrows(EntityNotFoundException.class, () -> doctorService.getDoctorById(createdDoctor.getId()));
    }

    @Test
    void testFindAllPatientsOfDoctor()
    {
        Doctor doctor = new Doctor(null, "Gabi Dragan", "Neurolog");
        Doctor createdDoctor = doctorService.createDoctor(doctor);

        Patient patient = new Patient(null, "Gabi Dragan");
        Patient createdPatient = patientService.createPatient(patient);

        AppointmentInterval appointmentInterval = new AppointmentInterval(null, 2, 30);
        AppointmentInterval createdAppointmentInterval = appointmentIntervalService.createAppointmentInterval(appointmentInterval);

        Appointment appointment = new Appointment(null, createdAppointmentInterval, createdDoctor, createdPatient, LocalDate.now());
        appointmentService.createAppointment(appointment);

        Assertions.assertEquals(doctorService.findAllPatientsOfDoctor(createdDoctor.getId()).getPatients().get(0).getId(), createdPatient.getId());

    }

}