package com.example.app;

import java.time.LocalDate;

public class Student {
    public int studentId;
    public String firstName;
    public String lastName;
    public String email;
    public LocalDate enrollmentDate;

    public Student(int studentId, String firstName, String lastName, String email, LocalDate enrollmentDate) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return String.format("%d | %s %s | %s | %s",
                studentId, firstName, lastName, email,
                enrollmentDate == null ? "NULL" : enrollmentDate.toString());
    }
}
