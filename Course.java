public class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private int registeredStudents;
    private String schedule;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = 0;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRegisteredStudents() {
        return registeredStudents;
    }

    public String getSchedule() {
        return schedule;
    }

    public boolean registerStudent() {
        if (registeredStudents < capacity) {
            registeredStudents++;
            return true;
        }
        return false;
    }

    public boolean dropStudent() {
        if (registeredStudents > 0) {
            registeredStudents--;
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("Course Code: %s\nTitle: %s\nDescription: %s\nCapacity: %d\nRegistered Students: %d\nSchedule: %s\n",
                courseCode, title, description, capacity, registeredStudents, schedule);
    }
}
