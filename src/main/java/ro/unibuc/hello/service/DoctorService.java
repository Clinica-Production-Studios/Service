package ro.unibuc.hello.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.unibuc.hello.dto.Doctor;
import ro.unibuc.hello.data.DoctorEntity;
import ro.unibuc.hello.data.DoctorRepository;
import ro.unibuc.hello.data.DoctorRepositoryCustom;
import ro.unibuc.hello.dto.DoctorPatients;
import ro.unibuc.hello.exception.EntityNotFoundException;
import ro.unibuc.hello.mapper.DoctorMapper;
import ro.unibuc.hello.mapper.PatientMapper;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private DoctorRepositoryCustom doctorRepositoryCustom;

    public Doctor createDoctor(Doctor doctor) {
        doctor.setId(null);
        DoctorEntity doctorEntity = doctorRepository.save(DoctorMapper.getInstance().toEntity(doctor));
        return DoctorMapper.getInstance().toDto(doctorEntity);
    }

    public Doctor getDoctorById(String id) {
        return DoctorMapper.getInstance()
                .toDto(doctorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("doctor")));
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll().stream().map(DoctorMapper.getInstance()::toDto).collect(Collectors.toList());
    }

    public Doctor updateDoctor(Doctor doctor) {
        doctorRepository.findById(doctor.getId()).orElseThrow(() -> new EntityNotFoundException("doctor"));
        DoctorEntity doctorEntity = doctorRepository.save(DoctorMapper.getInstance().toEntity(doctor));
        return DoctorMapper.getInstance().toDto(doctorEntity);
    }

    public void deleteDoctor(String id) {
        DoctorEntity doctorEntity = doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("doctor"));
        doctorRepository.delete(doctorEntity);
    }

    public DoctorPatients findAllPatientsOfDoctor(String doctorId) {
        Doctor doctor = DoctorMapper.getInstance()
                .toDto(doctorRepository.findById(doctorId).orElseThrow(() -> new EntityNotFoundException("doctor")));

        DoctorPatients doctorPatients = new DoctorPatients();
        doctorPatients.setId(doctor.getId());
        doctorPatients.setName(doctor.getName());
        doctorPatients.setSpecialization(doctor.getSpecialization());
        doctorPatients.setPatients(doctorRepositoryCustom.findAllPatientsOfDoctor(doctorId).stream()
                .map(PatientMapper.getInstance()::toDto).collect(Collectors.toList()));

        return doctorPatients;
    }
}
