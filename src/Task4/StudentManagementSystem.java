package Task4;

import java.util.Scanner;
import java.util.InputMismatchException; // Import InputMismatchException for handling invalid input

//Custom exception for age not within range
class AgeNotWithinRangeException extends Exception {
 public AgeNotWithinRangeException(String message) {
     super(message);
 }
}

//Custom exception for invalid name
class NameNotValidException extends Exception {
 public NameNotValidException(String message) {
     super(message);
 }
}

//Student class
class Student {
 private int rollNo;
 private String name;
 private int age;
 private String course;

 // using Parameterized constructor
 public Student(int rollNo, String name, int age, String course) throws AgeNotWithinRangeException, NameNotValidException {
     if (age < 15 || age > 21) {
         throw new AgeNotWithinRangeException("Age should be between 15 and 21");
     }
     if (!isValidName(name)) {
         throw new NameNotValidException("Name should not contain numbers or special symbols");
     }
     this.rollNo = rollNo;
     this.name = name;
     this.age = age;
     this.course = course;
 }

 // Method to check if name is valid
 private boolean isValidName(String name) {
     return name.matches("[a-zA-Z\\s]+");
 }

 // Getters
 public int getRollNo() {
     return rollNo;
 }

 public String getName() {
     return name;
 }

 public int getAge() {
     return age;
 }

 public String getCourse() {
     return course;
 }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        // Creating a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Input student information using scanner 
            System.out.print("Enter roll number: ");
            int rollNo = scanner.nextInt(); // Reading roll number as integer
            scanner.nextLine(); // Consume newline character after reading integer
            System.out.print("Enter name: ");
            String name = scanner.nextLine(); // Reading name as string
            System.out.print("Enter age: ");
            int age = scanner.nextInt(); // Reading age as integer
            scanner.nextLine(); // Consume newline character after reading integer
            System.out.print("Enter course: ");
            String course = scanner.nextLine(); // Reading course as string
            
            // Creating valid student objects
            Student student = new Student(rollNo, name, age, course);
            System.out.println("Student created successfully: " + student.getName());
        } catch (AgeNotWithinRangeException e) {
            System.out.println("Error creating student: " + e.getMessage()); // Handling AgeNotWithinRangeException
        } catch (NameNotValidException e) {
            System.out.println("Error creating student: " + e.getMessage()); // Handling NameNotValidException
        } catch (InputMismatchException e) {
            System.out.println("Error creating student: Invalid input format."); // Handling InputMismatchException
        } finally {
            scanner.close(); // Closing the Scanner object to release resources
        }
    }
}