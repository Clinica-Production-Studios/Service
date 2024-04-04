package ro.unibuc.hello.dto;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PatientTest {
    Patient myPatient = new Patient("1", "Gigi");

    @Test
    public void test_Patient()
    {
        Assertions.assertSame("1", myPatient.getId());
        Assertions.assertSame("Gigi", myPatient.getName());
    }
}
