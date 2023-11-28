package ecobank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
// import java.nio.Buffer;
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
            System.out.println("What do you want to do?");

            try {
                choice = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Invalid choice");
                scanner.nextLine();
                choice = 7;
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
                    break;
                case 4:
                    getAllStudents();
                break;
                case 5:
                    search(scanner);
                break;

                case 6:
                    deleteAStudent(scanner);
                break;

                case 0:
                    saveStudentToFile();
                default:
                    System.out.println("Please type the number between 1-4");
                    break;
            }

        } while (choice != 0);
        scanner.close();
    }

//retrieving a student
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
//delete a student
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
//load students
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
    private static void getAllStudents(){
        int count = 1;
       for(Student student: students){
        System.out.println(count + "      id: " + student.id + "      Name: " + student.name + "     email " + student.email);
        count++;
       }
    }

    private static void search(Scanner scanner){
       List<Student> results = new ArrayList<>();
        Long longInput ;
        System.out.println("Enter search input e.g 112 for id, Opeyemi for name, opeyemi@gmail.com for email");
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
            }else{}
        }


        if(results.size() == 0){
            System.out.println(input+ " =>  No record found");
        }

        for (Student result : results) {
            System.out.println(input + " =>  ID = " + result.id + "      Name = " + result.name + "     Email =" + result.email);
        }

    }

    private static void editAStudent(Scanner scanner) {
        System.out.println("Enter the students Id to be editted");
        long studentId = scanner.nextLong();

        for (Student student : students) {
            if (student.getId() == studentId) {
                System.out.println("Enter preferred name");
                String newName = scanner.next();
                student.setName(newName);
                System.out.println("Enter preferred email");
                String newEmail = scanner.next();
                student.setEmail(newEmail);
                System.out.println("Successfully updated");
                return;
            }
        }
    }

    private static void addAStudent(Scanner scanner) {
        System.out.println("Enter student Id");
        long studentId = scanner.nextLong();
        System.out.println("Enter student Name");
        String studentName = scanner.next();
        System.out.println("Enter student Email");
        String studentEmail = scanner.next();
        Student student = new Student();
        student.setId(studentId);
        student.setName(studentName);
        student.setEmail(studentEmail);
        students.add(student);
        System.out.println("Student added successfully");

    }
    private static void saveStudentToFile() {
        try (FileWriter filewriter = new FileWriter(FILENAME);
                BufferedWriter bufferedWriter = new BufferedWriter(filewriter)) {
            for (Student student : students) {
                bufferedWriter.write(student.getId() + "," + student.getName() + "," + student.getEmail());
                bufferedWriter.newLine();
            }
            System.out.println("Student information saved successfully");
        } catch (Exception e) {
            System.out.println("Error writing to file");
        }

    }

}
