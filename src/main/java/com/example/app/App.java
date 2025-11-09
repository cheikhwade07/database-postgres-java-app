package com.example.app;

import java.sql.SQLException;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        StudentDAO dao = new StudentDAO();

        System.out.println("== Initial students ==");
        dao.getAllStudents().forEach(System.out::println);

        System.out.println("\n== INSERT ==");
        int newId = dao.addStudent("Alice", "Wong", "alice.wong@example.com", LocalDate.parse("2023-09-03"));
        System.out.println("Inserted student_id: " + newId);
        dao.getAllStudents().forEach(System.out::println);

        System.out.println("\n== UPDATE ==");
        int rowsU = dao.updateStudentEmail(newId, "alice.wong+updated@example.com");
        System.out.println("Rows updated: " + rowsU);
        dao.getAllStudents().forEach(System.out::println);

        System.out.println("\n== DELETE ==");
        int rowsD = dao.deleteStudent(newId);
        System.out.println("Rows deleted: " + rowsD);
        dao.getAllStudents().forEach(System.out::println);

        System.out.println("\nDone.");
    }
}
