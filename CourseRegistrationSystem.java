import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistrationSystem {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private Scanner scanner;

    public CourseRegistrationSystem() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
        loadSampleData();
    }

    private void loadSampleData() {
        courses.add(new Course("CS101", "Introduction to Computer Science", "Basic concepts of computer science", 30, "MWF 10-11AM"));
        courses.add(new Course("MATH201", "Calculus I", "Introduction to differential calculus", 25, "TTh 9-10:30AM"));
        courses.add(new Course("PHYS101", "Physics I", "Introduction to mechanics", 20, "MWF 11-12PM"));
        
        students.add(new Student("S001", "Alice"));
        students.add(new Student("S002", "Bob"));
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\nCourse Registration System Menu:");
            System.out.println("1. Display Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View Student Info");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    displayAvailableCourses();
                    break;
                case 2:
                    registerForCourse();
                    break;
                case 3:
                    dropCourse();
                    break;
                case 4:
                    viewStudentInfo();
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private void displayAvailableCourses() {
        System.out.println("\nAvailable Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    private void registerForCourse() {
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();
        Student student = findStudent(studentID);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        Course course = findCourse(courseCode);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        if (student.registerCourse(course)) {
            System.out.println("Registered successfully.");
        } else {
            System.out.println("Registration failed.");
        }
    }

    private void dropCourse() {
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();
        Student student = findStudent(studentID);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        Course course = findCourse(courseCode);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        if (student.dropCourse(course)) {
            System.out.println("Dropped course successfully.");
        } else {
            System.out.println("Dropping course failed.");
        }
    }

    private void viewStudentInfo() {
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();
        Student student = findStudent(studentID);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println(student);
        for (Course course : student.getRegisteredCourses()) {
            System.out.println(course);
        }
    }

    private Student findStudent(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    private Course findCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CourseRegistrationSystem system = new CourseRegistrationSystem();
        system.displayMenu();
    }
}
