package ro.unibuc.hello.mapper;

import ro.unibuc.hello.dto.Appointment;
import ro.unibuc.hello.data.AppointmentEntity;

public class AppointmentMapper {
    private static AppointmentMapper instance;

    private AppointmentMapper() {
    }

    public static AppointmentMapper getInstance() {
        if (instance == null) {
            instance = new AppointmentMapper();
        }
        return instance;
    }

    public Appointment toDto(AppointmentEntity entity) {
        Appointment appointment = new Appointment();
        appointment.setId(entity.getId());
        appointment.setAppointmentInterval(AppointmentIntervalMapper.getInstance().toDto(entity.getAppointmentInterval()));
        appointment.setDoctor(DoctorMapper.getInstance().toDto(entity.getDoctor()));
        appointment.setPatient(PatientMapper.getInstance().toDto(entity.getPatient()));
        appointment.setDate(entity.getDate());
        return appointment;
    }

    public AppointmentEntity toEntity(Appointment appointment) {
        AppointmentEntity entity = new AppointmentEntity();
        entity.setId(appointment.getId());
        entity.setAppointmentInterval(AppointmentIntervalMapper.getInstance().toEntity(appointment.getAppointmentInterval()));
        entity.setDoctor(DoctorMapper.getInstance().toEntity(appointment.getDoctor()));
        entity.setPatient(PatientMapper.getInstance().toEntity(appointment.getPatient()));
        entity.setDate(appointment.getDate());
        return entity;
    }
}
