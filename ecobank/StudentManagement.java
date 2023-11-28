package ecobank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {

    private static List<Student> students = new ArrayList<Student>();

    private static final String FILENAME = "ecobank_student.txt";

    public static void main(String[] args) {
        loadStudentFromTheDB();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("What do you want to do?");
            try {
                choice = scanner.nextInt();
                System.out.println("Your choice is " + choice);
            } catch (InputMismatchException e) {
                System.out.println("What you provided is not correct");
                scanner.nextLine();
                choice = 7;
                System.out.println("Your choice is " + choice);
                continue;

            }

            switch (choice) {
                case 1:
                    addAStudent(scanner);
                    break;
                case 2:
                    retrieveStudentRecord(scanner);
                    break;
                case 3:
                    deleteStudentRecord(scanner);
                    break;
                case 4:
                    editAStudent(scanner);
                    break;
                case 5:
                    retrieveAllRecord(scanner);
                    break;
                case 6:
                    searchStudents(scanner);
                    break;
                case 0:
                    saveStudentToFile();

                default:
                    System.out.println("Please enter a number between 1 and 6");
                    break;
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void loadStudentFromTheDB() {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] pieces = line.split(",");
                long id = Long.parseLong(pieces[0].trim());
                String name = pieces[1].trim();
                String email = pieces[2].trim();

                Student student = new Student();
                student.setId(id);
                student.setEmail(email);
                student.setName(name);

                students.add(student);
            }
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }

    private static void editAStudent(Scanner scanner) {
        System.out.println("Enter the studnet Id you want to edit");
        long studentId = scanner.nextLong();

        for (Student student : students) {
            if (student.getId() == studentId) {

                System.out.println("Enter the student Name");
                String studentName = scanner.next();
                System.out.println("Enter the student Email");
                String studentEmail = scanner.next();

                student.setEmail(studentEmail);
                student.setId(studentId);
                student.setName(studentName);

                System.out.println("The student informatuon was updated successfully");
            }
        }
    }

    private static void addAStudent(Scanner scanner) {
        System.out.println("Enter the student ID");
        long studentId = scanner.nextLong();
        System.out.println("Enter the student Name");
        String studentName = scanner.next();
        System.out.println("Enter the student Email");
        String studentEmail = scanner.next();

        Student student = new Student();
        student.setEmail(studentEmail);
        student.setId(studentId);
        student.setName(studentName);
        students.add(student);
        System.out.println("The student information is saved successfully");
    }

    private static void retrieveStudentRecord(Scanner scanner) {
        System.out.println("Enter the student ID to retrieve:");
        long studentId = scanner.nextLong();

        Student foundStudent = null;

        for (Student student : students) {
            if (student.getId() == studentId) {
                foundStudent = student;
                break;
            }
        }

        if (foundStudent != null) {
            System.out.println("Student found:");
            System.out.println("ID: " + foundStudent.getId());
            System.out.println("Name: " + foundStudent.getName());
            System.out.println("Email: " + foundStudent.getEmail());
        } else {
            System.out.println("No student found with ID: " + studentId);
        }
    }

    private static void deleteStudentRecord(Scanner scanner) {
        System.out.println("Enter the student ID to delete:");
        long studentId = scanner.nextLong();

        for (Student student : students) {
            if (student.getId() == studentId) {
                students.remove(student);
                System.out.println("Student with ID " + studentId + " has been sucessfully deleted.");
                return;
            }
        }

        System.out.println("No student found with ID: " + studentId);
    }

    private static void retrieveAllRecord(Scanner scanner) {
        for (Student student : students) {
            System.out.println("Student Id: " + student.getId());
            System.out.println("Student Name: " + student.getName());
            System.out.println("Student Email: " + student.getEmail());
        }

        System.out.println("All students record retrieved");
    }

    private static void searchStudents(Scanner scanner) {
        System.out.println("Enter the id, name or email of the student you want to search for");
        String studentId = scanner.next();

        for (Student student : students) {
            if (student.getEmail().equals(studentId) || student.getName().equals(studentId)
                    || String.valueOf(student.getId()).equals(studentId)) {
                System.out.println("Student Id: " + student.getId());
                System.out.println("Student Name: " + student.getName());
                System.out.println("Student Email: " + student.getEmail());
                return;
            }

        }
    }

    public static void saveStudentToFile() {
        try (FileWriter fileWriter = new FileWriter(FILENAME);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Student student : students) {
                bufferedWriter.write(student.getId() + "," + student.getName() + "," + student.getEmail());
                bufferedWriter.newLine();
            }
            System.out.println("Studennt information saved in the database");
        } catch (Exception e) {

            System.out.println("error reading information");
        }
    }

}
