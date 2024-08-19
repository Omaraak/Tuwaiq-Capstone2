package com.example.capstone2.Repository;

import com.example.capstone2.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
    Appointment findAppointmentById(int id);
    Appointment findAppointmentByStartTimeAndEndTime(String startTime, String endTime);
    List<Appointment> findAppointmentByDoctorID(int doctorID);
    List<Appointment> findAppointmentByUserID(int userID);
}
