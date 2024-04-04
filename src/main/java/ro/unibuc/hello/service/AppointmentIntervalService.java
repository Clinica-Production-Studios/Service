package ro.unibuc.hello.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.introspect.AnnotationMap;

import ro.unibuc.hello.dto.AppointmentInterval;
import ro.unibuc.hello.data.AppointmentIntervalEntity;
import ro.unibuc.hello.data.AppointmentIntervalRepository;
import ro.unibuc.hello.exception.EntityNotFoundException;
import ro.unibuc.hello.mapper.AppointmentIntervalMapper;

@Service
public class AppointmentIntervalService {
    @Autowired
    private AppointmentIntervalRepository appointmentIntervalRepository;

    public AppointmentInterval createAppointmentInterval(AppointmentInterval appointmentInterval) {
        appointmentInterval.setId(null);
        AppointmentIntervalEntity appointmentIntervalEntity = appointmentIntervalRepository.save(AppointmentIntervalMapper.getInstance().toEntity(appointmentInterval));
        return AppointmentIntervalMapper.getInstance().toDto(appointmentIntervalEntity);
    }

    public AppointmentInterval getAppointmentIntervalById(String id) {
        return AppointmentIntervalMapper.getInstance().toDto(appointmentIntervalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("appointmentInterval")));
    }

    public List<AppointmentInterval> getAllAppointmentIntervals() {
        return appointmentIntervalRepository.findAll().stream().map(AppointmentIntervalMapper.getInstance()::toDto).collect(Collectors.toList());
    }

    public AppointmentInterval updateAppointmentInterval(AppointmentInterval appointmentInterval) {
        appointmentIntervalRepository.findById(appointmentInterval.getId()).orElseThrow(() -> new EntityNotFoundException("appointmentInterval"));
        AppointmentIntervalEntity appointmentIntervalEntity = appointmentIntervalRepository.save(AppointmentIntervalMapper.getInstance().toEntity(appointmentInterval));
        return AppointmentIntervalMapper.getInstance().toDto(appointmentIntervalEntity);
    }

    public void deleteAppointmentInterval(String id) {
        AppointmentIntervalEntity appointmentIntervalEntity = appointmentIntervalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("appointmentInterval"));
        appointmentIntervalRepository.delete(appointmentIntervalEntity);
    }
}
