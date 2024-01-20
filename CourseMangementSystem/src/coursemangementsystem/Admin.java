/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursemangementsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Admin extends User {
    private List<Student> students;
    private List<Instructor> instructors;
    private static Admin instance;

    //construcotr
    public Admin(List<Student> students, List<Instructor> instructors, int id, String name, String email, String password, boolean loggedIn) {
        super(id, name, email, password, loggedIn);
        this.students = students;
        this.instructors = instructors;
    }
    
    
    //Singelton design pattern
    public static Admin getInstance() {
        if (instance == null) {
            instance = new Admin(new ArrayList<>(), new ArrayList<>(), 0, "admin", "admin@example.com", "123456", false);
        }
        return instance;
    }
  
    //setters and getters started
    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

  
    public List<Instructor> getInstructors() {
        return instructors;
    }

    public List<Student> getStudents() {
        return students;
    }
    //setters and getters ended
    
    //Admin log in
     public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        if (username.equals("admin") && password.equals("123")) {
            this.setLoggedIn(true);
            System.out.println("Logged in as admin.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
    
    //Admin log out 
    public void logout() {
       this.setLoggedIn(false);
        System.out.println("Logged out.");
    }
    
    //Admin add new student to the arraylist
    public void addStudent(Student student) {
        if (this.isLoggedIn()) {
            students.add(student);
            System.out.println("Student added.");
        } else {
            System.out.println("Error: Not logged in as admin.");
        }
    }
    
    //admin update information about exist student
    public void updateStudent(Student student) {
        if (this.isLoggedIn()) {
            int index = students.indexOf(student);
            if (index >= 0) {
                students.set(index, student);
                System.out.println("Student updated.");
            } else {
                System.out.println("Error: Student not found.");
            }
        } else {
            System.out.println("Error: Not logged in as admin.");
        }
    }
    
    //Admin can delete student
    public void deleteStudent(Student student) {
        if (this.isLoggedIn()) {
            if (students.remove(student)) {
                System.out.println("Student deleted.");
            } else {
                System.out.println("Error: Student not found.");
            }
        } else {
            System.out.println("Error: Not logged in as admin.");
        }
    }
    
    //Admin add instructor to the array list
    public void addInstructor(Instructor instructor) {
        if (this.isLoggedIn()) {
            instructors.add(instructor);
            System.out.println("Instructor added.");
        } else {
            System.out.println("Error: Not logged in as admin.");
        }
    }
    
    //Admin can update the instructor information
    public void updateInstructor(Instructor instructor) {
        if (this.isLoggedIn()) {
            int index = instructors.indexOf(instructor);
            if (index >= 0) {
                instructors.set(index, instructor);
                System.out.println("Instructor updated.");
            } else {
                System.out.println("Error: Instructor not found.");
            }
        } else {
            System.out.println("Error: Not logged in as admin.");
        }
    }
    
    //Admin can delete instructor from the array list
    public void deleteInstructor(Instructor instructor) {
        if (this.isLoggedIn()) {
            if (instructors.remove(instructor)) {
                System.out.println("Instructor deleted.");
            } else {
                System.out.println("Error: Instructor not found.");
            }
        } else {
            System.out.println("Error: Not logged in as admin.");
        }
    }

   
    
    
    
}
