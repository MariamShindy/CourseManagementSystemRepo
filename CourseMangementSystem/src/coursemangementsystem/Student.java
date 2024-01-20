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
public class Student extends User {
        private List<Course> courses;
        private List<Survey> surveys;
        private List<Double> Grades;

    public Student( int id, String name, String email, String password, boolean loggedIn) {
        super(id, name, email, password, loggedIn);
    }
    
    
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    
     public void setGrade(Course course, double grade) {
        int index = courses.indexOf(course);
        if (index != -1) {
            Grades.set(index, grade);
            course.setGrade(this, grade);
        }
    }
     
     public List<Double> getGrades() {
        return Grades;
    }
     
    public void setSurveys(List<Survey> surveys) {
        this.surveys = surveys;
    }

    public List<Survey> getSurveys() {
        return surveys;
    }
    
     public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        if (username.equals("student") && password.equals("123")) {
            this.setLoggedIn(true);
            System.out.println("Logged in as student.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
    
    public void logout() {
       this.setLoggedIn(false);
        System.out.println("Logged out.");
    }   
        
    
    public void enrollCourse(Course course){
        if (this.isLoggedIn()) {
        courses.add(course);
        Grades.add(0.0); // initialize grade to 0.0 for the new course
        course.enrollStudent(this);
    }
         else{
    System.out.println("You are not logged in in " + course.getName());
     }
    }
  
    
 public void seeGrade(Course course) {
        if (this.isLoggedIn()) {
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).equals(course)) {
                    System.out.println("Your grade in " + course.getName() + " is " + Grades.get(i));
                    return;
                }
            }
            System.out.println("You are not enrolled in " + course.getName());
        } else {
            System.out.println("You are not logged in");
        }
    }
 
 
 public void MakeSurvey(Course course , String rating){
     if (this.isLoggedIn()) {
     Survey survey = new Survey(course,rating);
     surveys.add(survey);
 }
      else{
    System.out.println("You are not logged in in " + course.getName());
 }
 }
 
 public void SeeAllCourse (){
     if (this.isLoggedIn()) {
         this.getCourses();
     }
      else{
    System.out.println("You are not logged in in ");
     }
 }
 
 
 public void UpdateInfo(String name, String email, String password){
     if (this.isLoggedIn()) {
     setName(name);
     setEmail(email);
     setPassword(password);
 }
      else{
    System.out.println("You are not logged in in ");
 }
 }
 
 //LOGIN LOGOUT kol users ADMIN MODULE 
}
