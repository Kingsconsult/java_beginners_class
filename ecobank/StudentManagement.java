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
        runProgram();

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

    private static void runProgram() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String promptQuestion = """
                \n
                Welcome to EcoBank Student Management
                System
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

    // add a student
    private static void addAStudent(Scanner scanner) {
        System.out.print("Enter the Student detail you want to save\n");
        System.out.print("Enter student Id:- ");
        long studentId = scanner.nextLong();
        System.out.print("Enter student name:- ");
        String studentName = scanner.next();
        System.out.print("Enter student email:- ");
        String studentEmail = scanner.next();
        Boolean reTry = true;

        while (reTry) {
            String question_Prompt = """
                    \n
                    studentId:- %d
                    studentName:- %s
                    studentEmail:- %s
                    Do you want to save this record?
                    1) Yes
                    2) No
                    3) Back to Main Menu
                    """.formatted(studentId, studentName, studentEmail);
            System.out.println(question_Prompt);
            int answer;

            try {
                answer = scanner.nextInt();
                if (answer == 1) {
                    reTry = false;
                    boolean studentExists = false;

                    // check if student exists
                    for (Student student : students) {
                        if (student.getId() == studentId) {
                            studentExists = true;
                            System.out.println("\nStudent with ID " + studentId + " already exists...");
                            break;
                        }
                    }

                    if (!studentExists) {
                        Student student = new Student();
                        student.setId(studentId);
                        student.setName(studentName);
                        student.setEmail(studentEmail);
                        students.add(student);
                        saveStudentToFile(); // save the student information to the file
                        while (reTry) {
                            String tryAgain = """
                                    Do you want to save another record?
                                    1) Yes
                                    2) No
                                    """;
                            System.out.println(tryAgain);
                            answer = scanner.nextInt();
                            if (answer == 1) {
                                reTry = false;
                                addAStudent(scanner);
                                break;
                            } else if (answer == 2) {
                                reTry = false;
                                runProgram(); // return to main menu
                                break;
                            } else {
                                System.out.println("Select a valid option");
                            }
                        }
                    }

                } else if (answer == 2) {
                    reTry = false;
                    addAStudent(scanner);
                } else if (answer == 3) {
                    reTry = false;
                    runProgram();
                } else {
                    reTry = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid choice option");
                reTry = true;
                scanner.nextLine();
            }
        }
    }

    // search student by ID
    private static void searchStudentById(Scanner scanner) {
        System.out.println("Enter student Id you want to search");
        long studentId;
        boolean is_Not_Valid = true;
        while (is_Not_Valid) {
            try {
                studentId = scanner.nextLong();
                for (Student student : students) {
                    if (student.getId() == studentId) {
                        System.out.println("Student Id: " + student.getId());
                        System.out.println("Student Name: " + student.getName());
                        System.out.println("Student Email: " + student.getEmail());
                        is_Not_Valid = false;
                        return;
                    } else {
                        System.out.println("Student not found");
                        is_Not_Valid = false;
                        return;
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Id not be a number");
                is_Not_Valid = true;
                // return;
            }
        }

    }

    // retrieve students by their email, name or id
    private static void retrieveAStudent(Scanner scanner) {
        System.out.println("Search by id, name or email you want to retrieve");
        String studentId = scanner.next();

        for (Student student : students) {
            if (student.getEmail().equals(studentId) || student.getName().equals(studentId)
                    || String.valueOf(student.getId()).equals(studentId)) {
                System.out.println("Student Id: " + student.getId());
                System.out.println("Student Name: " + student.getName());
                System.out.println("Student Email: " + student.getEmail());
                return;
            } else {
                System.out.println("Student not found");
                retrieveAllStudents(scanner);
                return;
            }
        }
    }

    // retrieve all students
    private static void retrieveAllStudents(Scanner scanner) {
        if (students.size() == 0) {
            System.out.println("Students record not found");
        }
        for (Student student : students) {
            System.out.println("Student Id: " + student.getId());
            System.out.println("Student Name: " + student.getName());
            System.out.println("Student Email: " + student.getEmail());
        }
    }

    // delete a student
    private static void deleteAStudent(Scanner scanner) {
        System.out.println("Enter the students Id you want to delete");
        long studentId;
        // long studentId = scanner.nextLong();
        boolean is_Not_Valid = true;
        while (is_Not_Valid) {
            try {
                studentId = scanner.nextLong();
                for (Student student : students) {
                    if (student.getId() == studentId) {
                        students.remove(student);
                        System.out.println("Student deleted successfully");
                        saveStudentToFile();
                        is_Not_Valid = false;
                        return;
                    } else {
                        System.out.println("Student not found");
                        is_Not_Valid = false;
                        deleteAStudent(scanner);
                        return;
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Id not be a number");
                is_Not_Valid = true;
                return;
            }
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
            } else {
                System.out.println("Student not found");
                editAStudent(scanner);
                return;
            }
        }
    }

}
