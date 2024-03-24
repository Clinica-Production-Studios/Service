package ro.unibuc.hello.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends MongoRepository<AppointmentEntity, String> {
    @Query("{'doctor.id' : ?0}")
    List<AppointmentEntity> findAllAppointmentsOfDoctor(String doctorId);
    
    @Query("{'patient.id' : ?0}")
    List<AppointmentEntity> findAllAppointmentsOfPatient(String patientId);
    
    @Query("{'doctor.id' : ?0, 'date' : {$gte : ?1, $lte : ?2}}")
    List<AppointmentEntity> findAppointmentsOfDoctorWithinDateRange(String doctorId, LocalDate startDate, LocalDate endDate);

    @Query("{'patient.id' : ?0, 'date' : {$gte : ?1, $lte : ?2}}")
    List<AppointmentEntity> findAppointmentsOfPatientWithinDateRange(String patientId, LocalDate startDate, LocalDate endDate);
}
