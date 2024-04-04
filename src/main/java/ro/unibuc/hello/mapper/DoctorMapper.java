package ro.unibuc.hello.mapper;

import ro.unibuc.hello.data.DoctorEntity;
import ro.unibuc.hello.dto.Doctor;

public class DoctorMapper {

    private static DoctorMapper instance;

    private DoctorMapper() {
    }

    public static DoctorMapper getInstance() {
        if (instance == null) {
            instance = new DoctorMapper();
        }
        return instance;
    }

    public Doctor toDto(DoctorEntity entity) {
        Doctor doctor = new Doctor();
        doctor.setId(entity.getId());
        doctor.setName(entity.getName());
        doctor.setSpecialization(entity.getSpecialization());
        return doctor;
    }

    public DoctorEntity toEntity(Doctor doctor) {
        DoctorEntity entity = new DoctorEntity();
        entity.setId(doctor.getId());
        entity.setName(doctor.getName());
        entity.setSpecialization(doctor.getSpecialization());
        return entity;
    }
}
