package com.example.app;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        StudentDAO dao = new StudentDAO();
        if (args.length == 0) {
            System.out.println("Usage:");
            System.out.println("  list");
            System.out.println("  add <first> <last> <email> <yyyy-mm-dd|null>");
            System.out.println("  update <student_id> <new_email>");
            System.out.println("  delete <student_id>");
            return;
        }

        switch (args[0].toLowerCase()) {
            case "list": {
                dao.getAllStudents().forEach(System.out::println);
                break;
            }
            case "add": {
                if (args.length < 5) {
                    System.err.println("add <first> <last> <email> <yyyy-mm-dd|null>");
                    return;
                }
                String first = args[1];
                String last  = args[2];
                String email = args[3];
                LocalDate date = "null".equalsIgnoreCase(args[4]) ? null : LocalDate.parse(args[4]);
                int id = dao.addStudent(first, last, email, date);
                System.out.println("Inserted student_id: " + id);
                break;
            }
            case "update": {
                if (args.length < 3) {
                    System.err.println("update <student_id> <new_email>");
                    return;
                }
                int studentId = Integer.parseInt(args[1]);
                String newEmail = args[2];
                int rows = dao.updateStudentEmail(studentId, newEmail);
                System.out.println("Rows updated: " + rows);
                break;
            }
            case "delete": {
                if (args.length < 2) {
                    System.err.println("delete <student_id>");
                    return;
                }
                int studentId = Integer.parseInt(args[1]);
                int rows = dao.deleteStudent(studentId);
                System.out.println("Rows deleted: " + rows);
                break;
            }
            default:
                System.err.println("Unknown command. Use: list | add | update | delete");
        }
    }
}
