package ro.unibuc.hello.dto;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DoctorTest {
    Doctor myDoctor = new Doctor("1", "Gabi", "Neurolog");

    @Test
    public void test_Doctor()
    {
        Assertions.assertSame("1", myDoctor.getId());
        Assertions.assertSame("Gabi", myDoctor.getName());
        Assertions.assertSame("Neurolog", myDoctor.getSpecialization());
    }
}
