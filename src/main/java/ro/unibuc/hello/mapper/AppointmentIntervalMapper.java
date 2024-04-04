package ro.unibuc.hello.mapper;

import ro.unibuc.hello.dto.AppointmentInterval;
import ro.unibuc.hello.data.AppointmentIntervalEntity;

public class AppointmentIntervalMapper {
    private static AppointmentIntervalMapper instance;

    private AppointmentIntervalMapper() {
    }

    public static AppointmentIntervalMapper getInstance() {
        if (instance == null) {
            instance = new AppointmentIntervalMapper();
        }
        return instance;
    }

    public AppointmentInterval toDto(AppointmentIntervalEntity entity) {
        AppointmentInterval interval = new AppointmentInterval();
        interval.setId(entity.getId());
        interval.setHour(entity.getHour());
        interval.setMinute(entity.getMinute());
        return interval;
    }

    public AppointmentIntervalEntity toEntity(AppointmentInterval interval) {
        AppointmentIntervalEntity entity = new AppointmentIntervalEntity();
        entity.setId(interval.getId());
        entity.setHour(interval.getHour());
        entity.setMinute(interval.getMinute());
        return entity;
    }
}
