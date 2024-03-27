package ro.unibuc.hello.dto;

import java.util.List;

import ro.unibuc.hello.data.PatientEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DoctorPaticintsTest {
    List<PatientEntity> patients = List.of();
    DoctorPatients myDoctorPaticints = new DoctorPatients("1", "John", "Cardiolog", patients);

    @Test
    void test_content() {
        Assertions.assertSame("1", myDoctorPaticints.getId());
        Assertions.assertSame("John", myDoctorPaticints.getName());
        Assertions.assertSame("Cardiolog", myDoctorPaticints.getSpecialization());
        Assertions.assertSame(patients, myDoctorPaticints.getPacients());
    }
}
