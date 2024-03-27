package ro.unibuc.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.unibuc.hello.data.DoctorEntity;
import ro.unibuc.hello.data.DoctorRepository;
import ro.unibuc.hello.data.DoctorRepositoryCustom;
import ro.unibuc.hello.dto.DoctorPatients;
import ro.unibuc.hello.exception.EntityNotFoundException;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private DoctorRepositoryCustom doctorRepositoryCustom;

    public DoctorEntity createDoctor(DoctorEntity doctor) {
        doctor.setId(null);
        doctorRepository.save(doctor);
        return doctor;
    }

    public DoctorEntity getDoctorById(String id) {
        return doctorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("doctor"));    
    }

    public List<DoctorEntity> getAllDoctors() {
        return doctorRepository.findAll();    
    }

    public DoctorEntity updateDoctor(DoctorEntity doctor) {
        doctorRepository.findById(doctor.getId()).orElseThrow(() -> new EntityNotFoundException("doctor"));   
        doctorRepository.save(doctor);
        return doctor;
    }

    public void deleteDoctor(String id) {
        DoctorEntity doctor = doctorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("doctor"));   
        doctorRepository.delete(doctor);
    }

    public DoctorPatients findAllPatientsOfDoctor(String doctorId) {
        DoctorEntity doctorEntity = doctorRepository.findById(doctorId).orElseThrow(() -> new EntityNotFoundException("doctor"));
        
        DoctorPatients doctor = new DoctorPatients();
        doctor.setId(doctorEntity.getId());
        doctor.setName(doctorEntity.getName());
        doctor.setSpecialization(doctorEntity.getSpecialization());
        doctor.setPacients(doctorRepositoryCustom.findAllPatientsOfDoctor(doctorId));

        return doctor;
    }
}
