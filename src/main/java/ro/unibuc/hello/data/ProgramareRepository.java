package ro.unibuc.hello.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ProgramareRepository extends MongoRepository<ProgramareEntity, String> {
    @Query("{'doctor.id' : ?0}")
    List<ProgramareEntity> findAllProgramariOfDoctor(String doctorId);
    
    @Query("{'pacient.id' : ?0}")
    List<ProgramareEntity> findAllProgramariOfPacient(String pacientId);
    
    @Query("{'doctor.id' : ?0, 'data' : {$gte : ?1, $lte : ?2}}")
    List<ProgramareEntity> findProgramariOfDoctorWithinDateRange(String doctorId, LocalDate startDate, LocalDate endDate);

    @Query("{'pacient.id' : ?0, 'data' : {$gte : ?1, $lte : ?2}}")
    List<ProgramareEntity> findProgramariOfPacientWithinDateRange(String pacientId, LocalDate startDate, LocalDate endDate);
}
