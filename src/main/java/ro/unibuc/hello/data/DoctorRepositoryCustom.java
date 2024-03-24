package ro.unibuc.hello.data;

import java.util.List;

public interface DoctorRepositoryCustom {

    List<PatientEntity> findAllPatientsOfDoctor(String doctorId);
}
