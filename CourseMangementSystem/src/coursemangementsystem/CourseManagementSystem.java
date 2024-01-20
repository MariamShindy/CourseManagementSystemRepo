package coursemangementsystem;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CourseManagementSystem {

    private static Student s1;
    private static Instructor i1;
    private static Course c1;
    private static Room r1;
    private static Branch b1;
    private static Double G1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //create a new instance of admin class because i use singelton 
        Admin admin = Admin.getInstance();
        //create a new student
        s1 = new Student(1, "student", "john@gmail.com", "123", false);
        //create a new instructor
        i1 = new Instructor(false, 1, "instructor", "Amen@gmail.com", "123", false);
        //create a new grade 
        G1 = 20.5;
        //create a new room
        r1 = new Room(1,"Room1");
        //create a new branch
        b1 = new Branch(1,"Branch1");
        
        Random random = new Random();
        // Generate a random start date
        Date startDate = new Date(System.currentTimeMillis() - random.nextInt(1000000000));
        // Generate a random end date
        Date endDate = new Date(System.currentTimeMillis() + random.nextInt(1000000000));
        // Calculate the difference in days between the start and end dates
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        //create a new course 
        c1 = new Course("English",5,r1,b1,2000,startDate,diffInDays,endDate);
        
        
        // Main menu loop
        while (true) {
            System.out.println("=== Course Management System ===");
            System.out.println("1. Admin Login");
            System.out.println("2. Instructor Login");
            System.out.println("3. Student Login");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character

            switch (choice) {
                case 1:
                    // Handle admin login
                    admin.login();
                    if (admin.isLoggedIn()) {
                        adminMenu(admin, scanner);
                    }
                    break;
                case 2:
                    // Handle instructor login
                    i1.login();
                    if (i1.isLoggedIn()){
                        instructorMenu(i1,scanner);
                    }
                    break;
                case 3:
                    // Handle student login              
                    s1.login();
                    if(s1.isLoggedIn()){
                        studentMenu(s1,scanner);
                    }
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
     
   private static void  instructorMenu(Instructor i1 , Scanner scanner){
       while (i1.isLoggedIn()) {
            System.out.println("=== Instructor Menu ===");
            System.out.println("1. Add Grade");
            System.out.println("2. Publish Grades");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Handle adding a grade
                    i1.addGrade(G1);
                    break;
                case 2:
                    // Handle publish grades
                    i1.publishGrades();
                    break;
                case 3:
                    // Handle loging out
                    i1.logout();
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
   }
   
     private static void  studentMenu(Student s1 , Scanner scanner){
       while (i1.isLoggedIn()) {
            System.out.println("=== Student Menu ===");
            System.out.println("1. encroll a course");
            System.out.println("2. see grade");
            System.out.println("3. make a survey");
            System.out.println("4. see all courses");
            System.out.println("5. update info ");
            System.out.println("6. Logout");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Handle Enroll a course
                    s1.enrollCourse(c1);
                    break;
                case 2:
                    // Handle see grade
                    s1.seeGrade(c1);
                    break;
                 case 3:
                    // Handle make a survey
                    String rating = "Excellent";
                    s1.MakeSurvey(c1, rating);
                    break;
                 case 4:
                    // Handle see all courses
                    s1.SeeAllCourse();
                    break;
                 case 5:
                    // Handle update info
                     String name = "Amir";
                    s1.UpdateInfo(name, s1.getEmail(), s1.getPassword());
                    break;
                case 6:
                    // Handle loging out
                    s1.logout();
                default:
                    //Enter number not in range 1 to 6 
                    System.out.println("Invalid choice. Please try again.");
            }
        }
   }
   
   
    private static void adminMenu(Admin admin, Scanner scanner) {
        // Admin menu options
        while (admin.isLoggedIn()) {
            System.out.println("=== Admin Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Add Instructor");
            System.out.println("5. Update Instructor");
            System.out.println("6. Delete Instructor");
            System.out.println("7. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Handle adding a student
                    admin.addStudent(s1);
                    break;
                case 2:
                    // Handle updating a student
                    s1 = new Student(s1.getId(), "Joe", "joe@gmail.com", s1.getPassword(), s1.isLoggedIn());
                    admin.updateStudent(s1);
                    break;
                case 3:
                    // Handle deleting a student
                    admin.deleteStudent(s1);
                    break;
                case 4:
                    // Handle adding an instructor
                    admin.addInstructor(i1);
                    break;
                case 5:
                    // Handle updating an instructor
                    i1 = new Instructor(false, i1.getId(), "AmenMohamed", "AmenMohamed@gmail.com", i1.getPassword(), i1.isLoggedIn());
                    break;
                case 6:
                    admin.deleteInstructor(i1);
                    break;
                case 7:
                    admin.logout();
                    System.out.println("Logged out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
