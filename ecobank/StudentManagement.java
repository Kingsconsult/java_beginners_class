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
                    toAddAStudent(scanner);
                    break;
                case 2:
                    toRetrieveAStudent(scanner);
                    break;
                case 3:
                    toEditAStudent(scanner);
                    break;
                case 4:
                    toGetAllStudents();
                    break;
                case 5:
                    toSearch(scanner);
                    break;
                case 6:
                    toDeleteAStudent(scanner);
                    break;
                case 0:
                    toSaveStudentToFile();
                default:
                    break;
            }

        } while (choice != 0);
        scanner.close();
    }


    private static void toRetrieveAStudent(Scanner scanner) {
        System.out.println("Enter the Id of the student you want to retrieve"); 
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

    private static void toDeleteAStudent(Scanner scanner) {
        System.out.println("Enter the Id of the student you want to delete");
        long studentId = scanner.nextLong();

        for (Student student : students) {
            if (student.getId() == studentId) {
                students.remove(student);
                System.out.println("This student has been deleted");
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
    private static void toGetAllStudents(){
        int count = 1;
       for(Student student: students){
        System.out.println(count + "      id: " + student.id + "      Name: " + student.name + "     email " + student.email);
        count++;
       }
    }

    private static void toSearch(Scanner scanner){
       List<Student> results = new ArrayList<>();
        Long longInput ;
        System.out.println("Enter your Id");
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
            System.out.println(input+ " =>  No result found");
        }

        for (Student result : results) {
            System.out.println(input + " =>  id: " + result.id + "      Name: " + result.name + "     email " + result.email);
        }

    }

    private static void toEditAStudent(Scanner scanner) {
        System.out.println("Enter the Id of the student you want to edit");
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

    private static void toAddAStudent(Scanner scanner) {
        System.out.println("Enter the student Id");
        long studentId = scanner.nextLong();
        // scanner.nextLine();
        System.out.println("Enter the name of the student");
        String studentName = scanner.next();
        System.out.println("Enter the email of the student");
        String studentEmail = scanner.next();

        // Student student = new Student(studentId, studentName, studentEmail);
        Student student = new Student();
        student.setId(studentId);
        student.setName(studentName);
        student.setEmail(studentEmail);
        students.add(student);
        System.out.println("This student has been added successfully");

    }

    private static void toSaveStudentToFile() {
        try (FileWriter filewriter = new FileWriter(FILENAME);
                BufferedWriter bufferedWriter = new BufferedWriter(filewriter)) {
            for (Student student : students) {
                bufferedWriter.write(student.getId() + "," + student.getName() + "," + student.getEmail());
                bufferedWriter.newLine();
            }
            System.out.println("This student details has been saved successfully");
        } catch (Exception e) {
            System.out.println("Error writing to the file");
        }

    }

}
