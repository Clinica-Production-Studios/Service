package ro.unibuc.hello.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ro.unibuc.hello.data.ProgramareEntity;
import ro.unibuc.hello.data.ProgramareRepository;
import ro.unibuc.hello.exception.EntityNotFoundException;

@Service
public class ProgramareService {
    @Autowired
    private ProgramareRepository programareRepository;

    public ProgramareEntity createProgramare(ProgramareEntity programare) {
        programare.setId(null);
        programareRepository.save(programare);
        return programare;
    }

    public ProgramareEntity getProgramareById(String id) {
        return programareRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("programare"));
    }

    public List<ProgramareEntity> getAllProgramari() {
        return programareRepository.findAll();
    }

    public ProgramareEntity updateProgramare(ProgramareEntity programare) {
        programareRepository.findById(programare.getId()).orElseThrow(() -> new EntityNotFoundException("programare"));
        programareRepository.save(programare);
        return programare;
    }

    public void deleteProgramare(String id) {
        ProgramareEntity programare = programareRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("programare"));
        programareRepository.delete(programare);
    }

    public List<ProgramareEntity> getProgramariOfDoctor(@PathVariable String doctorId) {
        return programareRepository.findAllProgramariOfDoctor(doctorId);
    }

    public List<ProgramareEntity> getProgramariOfPacient(@PathVariable String pacientId) {
        return programareRepository.findAllProgramariOfPacient(pacientId);
    }

    public List<ProgramareEntity> getProgramariOfDoctorWithinDateRange(@PathVariable String doctorId,
                                                                         @RequestParam("startDate") String startDate,
                                                                         @RequestParam("endDate") String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return programareRepository.findProgramariOfDoctorWithinDateRange(doctorId, start, end);
    }

    public List<ProgramareEntity> getProgramariOfPacientWithinDateRange(@PathVariable String pacientId,
                                                                         @RequestParam("startDate") String startDate,
                                                                         @RequestParam("endDate") String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return programareRepository.findProgramariOfPacientWithinDateRange(pacientId, start, end);
    }



}
