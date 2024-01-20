/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursemangementsystem;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Dell
 */
class Course {
    private String Name;
    private int id;
    private Room room;
    private Branch branch;
    private double price;
    private List<Student> students;
    private List <Instructor> instructors;
    private Date startDate;
    private long days;
    private Date endDate;
    private List <ParentCourse>parentCourses;
    public List <Double> Grades;

    public Course(String Name, int id, Room room, Branch branch, double price, 
            Date startDate, long days, Date endDate) {
        this.Name = Name;
        this.id = id;
        this.room = room;
        this.branch = branch;
        this.price = price;
        this.startDate = startDate;
        this.days = days;
        this.endDate = endDate;
    }

      
    
    public void setBranch(Branch branch) {
        this.branch = branch;
    }
    
    
    public void setName(String Name) {
        this.Name = Name;
    }
    
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setDays(int days) {
        this.days = days;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRoom(Room room) {
        this.room = room;
    }


    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    public void setGrade(Student student, double grade) {
        int index = students.indexOf(student);
        if (index != -1) {
            Grades.set(index, grade);
        }
    }

    public List<Double> getGrades() {
        return Grades;
    }

    public void setParentCourses(List<ParentCourse> parentCourses) {
        this.parentCourses = parentCourses;
    }
  

    public void setParentCourse(List<ParentCourse> parentCourses) {
        this.parentCourses = parentCourses;
    }

    
    public String getName() {
        return Name;
    }


    public Branch getBranch() {
        return branch;
    }

      public Date getStartDate() {
        return startDate;
    }
    
    public Date getEndDate() {
        return endDate;
    }

  public long getDays() {
        return days;
    }

    public int getId() {
        return id;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public List<Student> getStudents() {
        return students;
    }

    public double getPrice() {
        return price;
    }

    public Room getRoom() {
        return room;
    }

    public List<ParentCourse> getParentCourses() {
        return parentCourses;
    }

     public void enrollStudent(Student student) {
        students.add(student);
        Grades.add(0.0); // initialize grade to 0.0 for the new student
    }
     
     
    public void addParentCourse(ParentCourse parentCourse) {
        parentCourses.add(parentCourse);
    }

    public void deleteParentCourse(ParentCourse parentCourse) {
        parentCourses.remove(parentCourse);
    }

    public void updateParentCourse(ParentCourse parentCourse, String newName, int newId) {
        parentCourse.setName(newName);
        parentCourse.setId(newId);
    }
    
    public void ShowAllInstructors(Course course){
         for (Instructor i : instructors) {
            System.out.println("Course Instructors are" + course.getInstructors());
            return;
        }
    }
    
      public void ShowAllStudents(Course course){
         for (Student s : students) {
            System.out.println("Course Studentds are" + course.getStudents());
            return;
        }
    }
        
      
}
