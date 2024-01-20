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
class Survey {
    private Course course;
    private String rating;

    public Survey(Course course, String rating) {
        this.course = course;
        this.rating = rating;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Course getCourse() {
        return course;
    }

    public String getRating() {
        return rating;
    }
    
    
}
