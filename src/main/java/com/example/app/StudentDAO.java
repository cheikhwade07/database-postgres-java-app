package com.example.app;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public List<Student> getAllStudents() throws SQLException {
        String sql = "SELECT student_id, first_name, last_name, email, enrollment_date FROM students ORDER BY student_id";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            List<Student> out = new ArrayList<>();
            while (rs.next()) {
                out.add(new Student(
                        rs.getInt("student_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getDate("enrollment_date") == null ? null : rs.getDate("enrollment_date").toLocalDate()
                ));
            }
            return out;
        }
    }

    public int addStudent(String first, String last, String email, LocalDate enrollmentDate) throws SQLException {
        String sql = "INSERT INTO students(first_name, last_name, email, enrollment_date) VALUES(?,?,?,?) RETURNING student_id";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, first);
            ps.setString(2, last);
            ps.setString(3, email);
            if (enrollmentDate == null) ps.setNull(4, Types.DATE);
            else ps.setDate(4, Date.valueOf(enrollmentDate));
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt(1);
            }
        }
    }

    public int updateStudentEmail(int studentId, String newEmail) throws SQLException {
        String sql = "UPDATE students SET email = ? WHERE student_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newEmail);
            ps.setInt(2, studentId);
            return ps.executeUpdate();
        }
    }

    public int deleteStudent(int studentId) throws SQLException {
        String sql = "DELETE FROM students WHERE student_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            return ps.executeUpdate();
        }
    }
}
