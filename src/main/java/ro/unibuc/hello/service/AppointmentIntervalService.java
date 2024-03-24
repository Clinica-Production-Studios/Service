package ro.unibuc.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.unibuc.hello.data.AppointmentIntervalEntity;
import ro.unibuc.hello.data.AppointmentIntervalRepository;
import ro.unibuc.hello.exception.EntityNotFoundException;

@Service
public class AppointmentIntervalService {
    @Autowired
    private AppointmentIntervalRepository appointmentIntervalRepository;

    public AppointmentIntervalEntity createAppointmentInterval(AppointmentIntervalEntity appointmentInterval) {
        appointmentInterval.setId(null);
        appointmentIntervalRepository.save(appointmentInterval);
        return appointmentInterval;
    }

    public AppointmentIntervalEntity getAppointmentIntervalById(String id) {
        return appointmentIntervalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("appointmentInterval"));
    }

    public List<AppointmentIntervalEntity> getAllAppointmentIntervals() {
        return appointmentIntervalRepository.findAll();
    }

    public AppointmentIntervalEntity updateAppointmentInterval(AppointmentIntervalEntity appointmentInterval) {
        appointmentIntervalRepository.findById(appointmentInterval.getId()).orElseThrow(() -> new EntityNotFoundException("appointmentInterval"));
        appointmentIntervalRepository.save(appointmentInterval);
        return appointmentInterval;
    }

    public void deleteAppointmentInterval(String id) {
        AppointmentIntervalEntity appointmentInterval = appointmentIntervalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("appointmentInterval"));
        appointmentIntervalRepository.delete(appointmentInterval);
    }
}
