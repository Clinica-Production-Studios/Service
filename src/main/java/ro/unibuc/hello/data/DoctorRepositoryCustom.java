package ro.unibuc.hello.data;

import java.util.List;

public interface DoctorRepositoryCustom {

    List<PacientEntity> findAllPacientiOfDoctor(String doctorId);
}
