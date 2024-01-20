/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursemangementsystem;

/**
 *
 * @author Dell
 */
import java.util.Date;
import java.util.List;

public class CourseDetailsPage {
    private Instructor instructor;
    private Room room;
    private Branch branch;
    private double price;
    private ParentCourse parentCourse;
    private List<Student> students;
    private int grade;
    private Date startDate;
    private int days;
    private Date endDate;

    public CourseDetailsPage(Instructor instructor, Room room, Branch branch, double price,
            ParentCourse parentCourse, List<Student> students, int grade, Date startDate, int days, Date endDate) {
        this.instructor = instructor;
        this.room = room;
        this.branch = branch;
        this.price = price;
        this.parentCourse = parentCourse;
        this.students = students;
        this.grade = grade;
        this.startDate = startDate;
        this.days = days;
        this.endDate = endDate;
    }
}
