package com.alexlasota.schoolmanagementsystem.model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor //potrzebny?
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Student {
    private Long id;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String pesel;
    private Gender gender;

    public enum Gender {
        MALE, FEMALE
    }
}
