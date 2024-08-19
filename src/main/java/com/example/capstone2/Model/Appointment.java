package com.example.capstone2.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Pattern(regexp = "(conformed|in progress|canceled|done)")
    private String status;

    @Pattern(regexp = "(online|on premise)")
    private String type;

    private LocalDate appointmentDate;

    private String startTime;

    private String endTime;

    private int price;

    private int userID;

    private int doctorID;
}
