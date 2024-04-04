package ro.unibuc.hello.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.unibuc.hello.dto.Doctor;
import ro.unibuc.hello.dto.DoctorPatients;
import ro.unibuc.hello.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public Doctor createDoctor(@RequestBody @Valid Doctor doctor) {
        return doctorService.createDoctor(doctor);
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable String id) {
        return doctorService.getDoctorById(id);
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable String id, @RequestBody @Valid Doctor doctor) {
        doctor.setId(id);
        return doctorService.updateDoctor(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable String id) {
        doctorService.deleteDoctor(id);
    }

    @GetMapping("/{doctorId}/patients")
    public DoctorPatients getPatientsOfDoctor(@PathVariable String doctorId) {
        return doctorService.findAllPatientsOfDoctor(doctorId);
    }
}
