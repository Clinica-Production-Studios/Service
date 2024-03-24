package ro.unibuc.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.unibuc.hello.data.PatientEntity;
import ro.unibuc.hello.data.PatientRepository;
import ro.unibuc.hello.exception.EntityNotFoundException;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public PatientEntity createPatient(PatientEntity patient) {
        patient.setId(null);
        patientRepository.save(patient);
        return patient;
    }

    public PatientEntity getPatientById(String id) {
        return patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("patient"));    
    }

    public List<PatientEntity> getAllPatienti() {
        return patientRepository.findAll();    
    }

    public PatientEntity updatePatient(PatientEntity patient) {
        patientRepository.findById(patient.getId()).orElseThrow(() -> new EntityNotFoundException("patient"));   
        patientRepository.save(patient);
        return patient;
    }

    public void deletePatient(String id) {
        PatientEntity patient = patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("patient"));   
        patientRepository.delete(patient);
    }
}
