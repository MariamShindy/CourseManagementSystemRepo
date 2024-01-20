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
class Instructor extends User {
    private ArrayList<Double> grades;
    private boolean gradesPublished;

    public Instructor( boolean gradesPublished, int id, String name, String email, String password, boolean loggedIn) {
        super(id, name, email, password, loggedIn);
        this.gradesPublished = gradesPublished;
    }

  
      public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        if (username.equals("instructor") && password.equals("123")) {
            this.setLoggedIn(true);
            System.out.println("Logged in as instructor.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
    
    public void logout() {
       this.setLoggedIn(false);
        System.out.println("Logged out.");
    }
    
    
    public void addGrade(double grade) {
        if (!gradesPublished && this.isLoggedIn()) {
            grades.add(grade);
        } else {
            System.out.println("Error: You are not logged in");
        }
    }
    
    public void publishGrades() {
        if (!gradesPublished && this.isLoggedIn()) {
            gradesPublished = true;
            System.out.println("Grades have been published.");
        } else {
            System.out.println("Error: You are not logged in");
        }
    }
    
    public ArrayList<Double> getGrades() {
        if (gradesPublished && this.isLoggedIn()) {
            return grades;
        } else {
            System.out.println("Error: Error: You are not logged in");
            return null;
        }
    }
                
    
    
}
