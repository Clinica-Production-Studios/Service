package ro.unibuc.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.unibuc.hello.data.PatientEntity;
import ro.unibuc.hello.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    public PatientEntity createPatient(@RequestBody PatientEntity patient) {
        return patientService.createPatient(patient);
    }

    @GetMapping("/{id}")
    public PatientEntity getPatientById(@PathVariable String id) {
        return patientService.getPatientById(id);
    }

    @GetMapping
    public List<PatientEntity> getAllPatienti() {
        return patientService.getAllPatienti();
    }

    @PutMapping("/{id}")
    public PatientEntity updatePatient(@PathVariable String id, @RequestBody PatientEntity patient) {
        patient.setId(id);
        return patientService.updatePatient(patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable String id) {
        patientService.deletePatient(id);
    }
}
