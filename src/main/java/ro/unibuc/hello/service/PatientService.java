package ro.unibuc.hello.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.unibuc.hello.dto.Patient;
import ro.unibuc.hello.data.PatientEntity;
import ro.unibuc.hello.data.PatientRepository;
import ro.unibuc.hello.exception.EntityNotFoundException;
import ro.unibuc.hello.mapper.PatientMapper;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient) {
        patient.setId(null);
        PatientEntity patientEntity = patientRepository.save(PatientMapper.getInstance().toEntity(patient));
        return PatientMapper.getInstance().toDto(patientEntity);
    }

    public Patient getPatientById(String id) {
        return PatientMapper.getInstance()
                .toDto(patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("patient")));
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll().stream().map(PatientMapper.getInstance()::toDto)
                .collect(Collectors.toList());
    }

    public Patient updatePatient(Patient patient) {
        patientRepository.findById(patient.getId()).orElseThrow(() -> new EntityNotFoundException("patient"));
        PatientEntity patientEntity = patientRepository.save(PatientMapper.getInstance().toEntity(patient));
        return PatientMapper.getInstance().toDto(patientEntity);
    }

    public void deletePatient(String id) {
        PatientEntity patientEntity = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("patient"));
        patientRepository.delete(patientEntity);
    }
}
