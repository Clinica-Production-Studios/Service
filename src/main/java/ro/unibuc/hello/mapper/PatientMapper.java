package ro.unibuc.hello.mapper;

import ro.unibuc.hello.dto.Patient;
import ro.unibuc.hello.data.PatientEntity;

public class PatientMapper {
    private static PatientMapper instance;

    private PatientMapper() {  
    }

    public static PatientMapper getInstance() {
        if (instance == null) {
            instance = new PatientMapper();
        }
        return instance;
    }

    public Patient toDto(PatientEntity entity) {
        Patient patient = new Patient();
        patient.setId(entity.getId());
        patient.setName(entity.getName());
        return patient;
    }

    public PatientEntity toEntity(Patient patient) {
        PatientEntity entity = new PatientEntity();
        entity.setId(patient.getId());
        entity.setName(patient.getName());
        return entity;
    }
}
