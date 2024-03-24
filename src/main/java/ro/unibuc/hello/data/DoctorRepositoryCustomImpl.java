package ro.unibuc.hello.data;

import org.springframework.stereotype.Repository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DoctorRepositoryCustomImpl implements DoctorRepositoryCustom {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<PatientEntity> findAllPatientsOfDoctor(String doctorId) {
        return appointmentRepository.findAllAppointmentsOfDoctor(doctorId).stream().map(AppointmentEntity::getPatient)
                .distinct().collect(Collectors.toList());
    }
}
