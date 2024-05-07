package com.alexlasota.schoolmanagementsystem.model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor //potrzebny?
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class Teacher {
    private Long id;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String pesel;
    private Student.Gender gender;
    private Double salary;
}
