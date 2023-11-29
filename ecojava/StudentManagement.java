package ecojava;

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

        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("What do you want to do? \n(1) Add Student \n(2) Retrieve Student by ID \n(3) Edit Student \n(4) Get all Students \n(5) Search for a Student \n(6) Delete a Student \n(0) Save actions");

            try {
                choice = scanner.nextInt();
                // System.out.println("Your choice is " + choice);6

            } catch (InputMismatchException e) {
                System.out.println("Invalid choice");
                scanner.nextLine();
                choice = 7;
                // System.out.println("Your choice is " + choice);
                continue;
            }

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    // System.out.println("you want to save a student");
                    break;
                case 2:
                    retrieveAStudentById(scanner);
                    // System.out.println("You want to retrieve a student");
                    break;
                case 3:
                    editStudent(scanner);
                    break;
                case 4:
                    retrieveAllStudents(scanner);
                    break;
                case 5:
                    search(scanner);
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

    // search student by ID,name or email
   

    private static void search(Scanner scanner){
        List<Student> results = new ArrayList<>();
         Long longInput ;
         System.out.println("Enter your search input e.g id, name or email");
         String input = scanner.next().trim();
         try{
          longInput = Long.parseLong(input);
         }catch(NumberFormatException e){
             longInput = -1L;
         }
 
         for (Student student : students) {
             if (input.equals( student.getEmail().trim())) {
                 results.add(student);
             }else if(input.equals(student.getName().trim()))
             {
                 results.add(student);
             }else if (longInput == student.getId()){
                 results.add(student);
             }
         }
 
 
         if(results.size() == 0){
             System.out.println(input+ " =>  Enter a valid Input");
         }
 
         for (Student result : results) {
             System.out.println(input + " =>  id: " + result.id + "      Name: " + result.name + "     email: " + result.email);
         }
 
     }

    // retrieve a student by Id
 
    private static void retrieveAStudentById(Scanner scanner) {
       


        System.out.println("Enter the students Id you want to search");
        long studentId = scanner.nextLong();
        // String studentName = scanner.nextLine();

        for (Student student : students) {
            if (student.getId() == studentId ) {
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
            System.out.println("  ");
        }
    }

    // delete a student
    private static void deleteAStudent(Scanner scanner) {
        System.out.println("Enter the students Id you want to delete");
        long studentId = scanner.nextLong();
        // String studentName = scanner.nextLine();

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
    private static void editStudent(Scanner scanner) {
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
    private static void addStudent(Scanner scanner) {
        System.out.println("To add a new student,Enter student Id");
        long studentId = scanner.nextLong();
        // scanner.nextLine();
        System.out.println("Enter student name");
        String studentName = scanner.next();
        System.out.println("Enter student email");
        String studentEmail = scanner.next();

        Student student = new Student();
        student.setId(studentId);
        student.setName(studentName);
        student.setEmail(studentEmail);
        students.add(student);
        System.out.println("Student has been Added successfully");

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
