package ro.unibuc.hello.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ro.unibuc.hello.data.PatientRepository;
import ro.unibuc.hello.dto.Patient;
import ro.unibuc.hello.exception.EntityNotFoundException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Tag("IT")
class PatientServiceTestIT {

    @Autowired
    PatientRepository patientRepository;

    @Autowired  
    private PatientService patientService;

    @Test
    void testCreateAndGetPatient() {
        Patient patient = new Patient(null, "Gabi Dragan");

        Patient createdPatient = patientService.createPatient(patient);

        Patient retrievedPatient = patientService.getPatientById(createdPatient.getId());

        assertNotNull(retrievedPatient);
        assertEquals(patient.getName(), retrievedPatient.getName());
    }

    @Test
    void testGetAllPatients() {

        Patient patient1 = new Patient(null, "Gabi Dragan");

        Patient patient2 = new Patient(null, "Gabriela Dragan");

        patientService.createPatient(patient1);
        patientService.createPatient(patient2);

        List<Patient> patients = patientService.getAllPatients();

        assertEquals(4, patients.size());
    }

    @Test
    void testUpdatePatient() {

        Patient patient = new Patient(null, "Gabi Dragan");

        Patient createdPatient = patientService.createPatient(patient);

        createdPatient.setName("Gabitzu Dragan");
        Patient updatedPatient = patientService.updatePatient(createdPatient);

        assertEquals("Gabitzu Dragan", updatedPatient.getName());
    }

    @Test
    void testDeletePatient()
    {
        Patient patient = new Patient(null, "Gabi Dragan");
        Patient createdPatient = patientService.createPatient(patient);
        Assertions.assertEquals(createdPatient.getName(), patientService.getPatientById(createdPatient.getId()).getName());

        patientService.deletePatient(createdPatient.getId());

        assertThrows(EntityNotFoundException.class, () -> patientService.getPatientById(createdPatient.getId()));
    }
}