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

    private static List<Student> students = new ArrayList<>();

    private static final String FILENAME = "ecobank_student.txt";

    public static void main(String[] args) {
        loadStudentsFromTheDB();
        // Student hardcodedStudent = new Student(1, "student name",
        // "email@student.com");
        // students.add(hardcodedStudent);
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("What do you want to do");
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
                    System.out.println("you want to retrieve a student");
                    break;
                case 3:
                    editAStudent(scanner);
                    break;
                case 4:
                    System.out.println("you want to delete a student");
                    break;
                case 0:
                    saveStudentToFile();
                default:
                    System.out.println("please type the number between 1 -3");
                    break;
            }

        } while (choice != 0);

        scanner.close();

    }

    private static void loadStudentsFromTheDB() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILENAME))) {
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
        System.out.println("Enter the student Id you want to edit");
        long studentId = scanner.nextLong();

        for (Student student : students) {
            if (student.getId() == studentId) {
                System.out.println("Enter the student name");
                String studentName = scanner.next();
                System.out.println("Enter the student Email");
                String studentEmail = scanner.next();

                student.setEmail(studentEmail);
                student.setId(studentId);
                student.setName(studentName);
                System.out.println("The student information was updated successfully");

            }
        }

    }

    private static void addAStudent(Scanner scanner) {
        System.out.println("Enter the student Id");
        long studentId = scanner.nextLong();
        System.out.println("Enter the student name");
        String studentName = scanner.next();
        System.out.println("Enter the student Email");
        String studentEmail = scanner.next();

        Student student = new Student();
        student.setEmail(studentEmail);
        student.setId(studentId);
        student.setName(studentName);
        students.add(student);
        System.out.println("The student information was saved successfully");
    }

    private static void saveStudentToFile() {
        try (FileWriter fileWriter = new FileWriter(FILENAME);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Student student : students) {
                bufferedWriter.write(student.getId() + "," + student.getName() + "," + student.getEmail());
                bufferedWriter.newLine();
            }
            System.out.println("Students information saved in the database");
        } catch (Exception e) {
            System.out.println("error reading from the file");
        }
    }

}
