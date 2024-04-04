package ro.unibuc.hello.dto;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DoctorPatientTest {
    List<Patient> patients = List.of();
    DoctorPatients myDoctorPatients = new DoctorPatients("1", "John", "Cardiolog", patients);

    @Test
    public void test_doctorPatient() {
        Assertions.assertSame("1", myDoctorPatients.getId());
        Assertions.assertSame("John", myDoctorPatients.getName());
        Assertions.assertSame("Cardiolog", myDoctorPatients.getSpecialization());
        Assertions.assertSame(patients, myDoctorPatients.getPatients());
    }
}
