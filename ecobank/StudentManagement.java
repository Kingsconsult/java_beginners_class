package ecobank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {

    private static List<Student> students = new ArrayList<>();

    private static final String FILENAME = "ecobank_student.txt";

    public static void main(String[] args) {
        loadFromDB();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Tell me what you want to do");

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("This is an Invalid choice");
                scanner.nextLine();
                choice = 7;
                continue;
            }

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    retrieveStudent(scanner);
                    break;
                case 3:
                    editStudent(scanner);
                    break;
                case 4:
                retrieveAllStudentsRecord(scanner);
                    break;
                case 5:
                searchStudentId(scanner);
                    break;
                case 6:
                    deleteStudent(scanner);
                    break;

                case 0:
                    saveToFile();
                default:
                    break;
            }

        } while (choice != 0);
        scanner.close();
    }
    private static void searchStudentId(Scanner scanner) {
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
    private static void retrieveStudent(Scanner scanner) {
        System.out.println("Please enter the student identifier you want to retrieve");
        long studentId = scanner.nextLong();

        for (Student student : students) {
            if (student.getId() == studentId) {
                System.out.println("Student Id: " + student.getId());
                System.out.println("Student Name: " + student.getName());
                System.out.println("Student Email: " + student.getEmail());
                return;
            }
        }
    }
    private static void retrieveAllStudentsRecord(Scanner scanner) {
        for (Student student : students) {
            System.out.println("Student Id: " + student.getId());
            System.out.println("Student Name: " + student.getName());
            System.out.println("Student Email: " + student.getEmail());
        }
    }
    private static void deleteStudent(Scanner scanner) {
        System.out.println("Please enter the student identifier you want to delete");
        long studentId = scanner.nextLong();

        for (Student student : students) {
            if (student.getId() == studentId) {
                students.remove(student);
                System.out.println("Student has been deleted");
                return;
            }
        }
    }
    private static void loadFromDB() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] studentDetails = line.split(",");
                Student student = new Student();
                student.setId(Long.parseLong(studentDetails[0].trim()));
                student.setName(studentDetails[1].trim());
                student.setEmail(studentDetails[2].trim());
                students.add(student);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private static void editStudent(Scanner scanner) {
        System.out.println("Please enter the student identifier of the student you want to edit");
        long studentId = scanner.nextLong();
        for (Student student : students) {
            if (student.getId() == studentId) {
                System.out.println("Please enter a new name");
                String newName = scanner.next();
                student.setName(newName);
                System.out.println("Please enter a new email");
                String newEmail = scanner.next();
                student.setEmail(newEmail);
                System.out.println("The student details have been updated successfully");
                return;
            }
        }
    }
    private static void addStudent(Scanner scanner) {
        System.out.println("Please enter student Id");
        long studentId = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Please enter student name");
        String studentName = scanner.next();
        System.out.println("Please enter student email");
        String studentEmail = scanner.next();
        Student student = new Student();
        student.setId(studentId);
        student.setName(studentName);
        student.setEmail(studentEmail);
        students.add(student);
        System.out.println("The Student has been added successfully");

    }
    private static void saveToFile() {
        try (FileWriter filewriter = new FileWriter(FILENAME);
                BufferedWriter bufferedWriter = new BufferedWriter(filewriter)) {
            for (Student student : students) {
                bufferedWriter.write(student.getId() + "," + student.getName() + "," + student.getEmail());
                bufferedWriter.newLine();
            }
            System.out.println("The Student information has been saved successfully");
        } catch (Exception e) {
            System.out.println("Error encountered while writing to file");
        }

    }

}
