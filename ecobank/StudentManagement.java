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
        // read the file immediately the app runs
        loadStudentsFromTheDB();

        Scanner scanner = new Scanner(System.in);
        int choice;
        String promptQuestion = """
            \n
            What do you want to?  
            (1) Add a new student  
            (2) Retrieve a Student
            (3) Edit a Student 
            (4) Retrieve all students 
            (5) Search for a Student
            (6) Delete a Student
            (0) Exit 
            """;

        do {
            System.out.println(promptQuestion);

            try {
                choice = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Invalid choice");
                scanner.nextLine();
                choice = 6;
                continue;
            }

            switch (choice) {
                case 1:
                    addAStudent(scanner);
                    // saveStudentToFile();
                    break;
                case 2:
                    retrieveAStudent(scanner);
                    break;
                case 3:
                    editAStudent(scanner);
                    saveStudentToFile();
                    break;
                case 4:
                    retrieveAllStudents(scanner);
                    break;
                case 5:
                    searchStudentById(scanner);
                    break;
                case 6:
                    deleteAStudent(scanner);
                    saveStudentToFile();
                    break;
                case 0:
                    saveStudentToFile();
                default:
                    System.out.println("Please type the number between 1-6");
                    break;
            }

        } while (choice != 0);
        scanner.close();
    }

    // search student by ID
    private static void searchStudentById(Scanner scanner) {
        System.out.println("Enter student Id you want to search");
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

    // retrieve students by their email, name or id
    private static void retrieveAStudent(Scanner scanner) {
        System.out.println("Search by id, name or email you want to retrieve");
        String studentId = scanner.next();        

        for (Student student : students) {
            if (student.getEmail().equals(studentId) || student.getName().equals(studentId) || String.valueOf(student.getId()).equals(studentId)) {
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
        

        // Student student = new Student();
        // student.setId(studentId);
        // student.setName(studentName);
        // student.setEmail(studentEmail);        
        // students.add(student);
        // System.out.println("\nStudent added successfully");

        boolean studentExists = false;

        for (Student student : students) {
            if (student.getId() == studentId) {
                studentExists = true;
                System.out.println("\nStudent with ID " + studentId + " already exists...");
                // break;
            }
        }
    
        if (!studentExists) {
            Student student = new Student();
            student.setId(studentId);
            student.setName(studentName);
            student.setEmail(studentEmail);        
            students.add(student);
            System.out.println("\nStudent added successfully");
        }
    }

    // save a student
    private static void saveStudentToFile() {
        try (FileWriter filewriter = new FileWriter(FILENAME);
                BufferedWriter bufferedWriter = new BufferedWriter(filewriter)) {
            for (Student student : students) {
                bufferedWriter.write(student.getId() + "," + student.getName() + "," + student.getEmail());
                bufferedWriter.newLine();
            }
            System.out.println("\nStudent information saved successfully");
        } catch (Exception e) {
            System.out.println("Error writing to the file");
        }

    }

}
