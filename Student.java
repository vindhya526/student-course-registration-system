import java.util.ArrayList;

public class Student {
    private String studentID;
    private String name;
    private ArrayList<Course> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            System.out.println("Already registered for the course.");
            return false;
        }
        if (course.registerStudent()) {
            registeredCourses.add(course);
            return true;
        }
        System.out.println("Course is full.");
        return false;
    }

    public boolean dropCourse(Course course) {
        if (registeredCourses.remove(course)) {
            course.dropStudent();
            return true;
        }
        System.out.println("Not registered for the course.");
        return false;
    }

    public String toString() {
        return String.format("Student ID: %s\nName: %s\nRegistered Courses: %d\n", studentID, name, registeredCourses.size());
    }
}
