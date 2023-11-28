package ecobankProject;

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
        loadStudentsFromTheDB();

        // Student hardcodedStudent = new Student(1, "Loveday Okoro",
        // "loveday@gmail.com");
        // students.add(hardcodedStudent);

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("What do you want to do?");

            try {
                choice = scanner.nextInt();
                // System.out.println("Your choice is " + choice);

            } catch (InputMismatchException e) {
                System.out.println("Invalid choice");
                scanner.nextLine();
                choice = 7;
                // System.out.println("Your choice is " + choice);
                continue;
            }

            switch (choice) {
                case 1:
                    addAStudent(scanner);
                    // System.out.println("you want to save a student");
                    break;
                case 2:
                    retrieveAStudent(scanner);
                    // System.out.println("You want to retrieve a student");
                    break;
                case 3:
                    editAStudent(scanner);
                    break;
                case 4:
                    retrieveAllStudents(scanner);
                    break;
                case 5:
                    searchStudentById(scanner);
                    break;
                case 6:
                    deleteAStudent(scanner);
                    // System.out.println("you want to delete a student");
                    break;

                // System.out.println("You want to update a student");

                case 0:
                    saveStudentToFile();
                default:
                    // System.out.println("Please type the number between 1-4");
                    break;
            }

        } while (choice != 0);
        scanner.close();
    }

    // search student by ID
    private static void searchStudentById(Scanner scanner) {
        System.out.println("Enter the students Id you want to search");
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

    // retrieve a student
    private static void retrieveAStudent(Scanner scanner) {
        System.out.println("Enter the students Id you want to retrieve");
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

    // retrieve all students
    private static void retrieveAllStudents(Scanner scanner) {
        for (Student student : students) {
            System.out.println("Student Id: " + student.getId());
            System.out.println("Student Name: " + student.getName());
            System.out.println("Student Email: " + student.getEmail());
        }
    }

    // delete a student
    private static void deleteAStudent(Scanner scanner) {
        System.out.println("Enter the students Id you want to delete");
        long studentId = scanner.nextLong();

        for (Student student : students) {
            if (student.getId() == studentId) {
                students.remove(student);
                System.out.println("Student deleted successfully");
                return;
            }
        }
    }

    private static void loadStudentsFromTheDB() {
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

    // edit a student
    private static void editAStudent(Scanner scanner) {
        System.out.println("Enter the students Id you want to edit");
        long studentId = scanner.nextLong();

        for (Student student : students) {
            if (student.getId() == studentId) {
                System.out.println("Enter the new name");
                String newName = scanner.next();
                student.setName(newName);
                System.out.println("Enter the new email");
                String newEmail = scanner.next();
                student.setEmail(newEmail);
                System.out.println("Student updated successfully");
                return;
            }
        }
    }

    // add a student
    private static void addAStudent(Scanner scanner) {
        System.out.println("Enter student Id");
        long studentId = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter student name");
        String studentName = scanner.next();
        System.out.println("Enter student email");
        String studentEmail = scanner.next();

        // Student student = new Student(studentId, studentName, studentEmail);
        Student student = new Student();
        student.setId(studentId);
        student.setName(studentName);
        student.setEmail(studentEmail);
        students.add(student);
        System.out.println("Student added successfully");

    }

    // save a student
    private static void saveStudentToFile() {
        try (FileWriter filewriter = new FileWriter(FILENAME);
                BufferedWriter bufferedWriter = new BufferedWriter(filewriter)) {
            for (Student student : students) {
                bufferedWriter.write(student.getId() + "," + student.getName() + "," + student.getEmail());
                bufferedWriter.newLine();
            }
            System.out.println("Student information saved successfully");
        } catch (Exception e) {
            System.out.println("Error writing to the file");
        }

    }

}
