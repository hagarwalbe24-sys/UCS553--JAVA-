

import java.util.*;

class Course {
    String courseCode;
    int capacity;

    HashSet<String> enrolledStudents;
    ArrayList<String> prerequisites;
    LinkedList<String> waitlist;

    Course(String courseCode, int capacity,
           ArrayList<String> prerequisites) {
        this.courseCode = courseCode;
        this.capacity = capacity;
        this.prerequisites = new ArrayList<>(prerequisites);
        this.enrolledStudents = new HashSet<>();
        this.waitlist = new LinkedList<>();
    }

    boolean hasSeat() {
        return enrolledStudents.size() < capacity;
    }
}

public class CourseRegistrationPortal {

    HashMap<String, Course> courses = new HashMap<>();

    // Stores the courses completed by each student.
    HashMap<String, HashSet<String>> completedCourses =
            new HashMap<>();

    void addCourse(String code, int capacity,
                   ArrayList<String> prerequisites) {
        courses.put(code,
                new Course(code, capacity, prerequisites));
    }

    void completeCourse(String studentId, String courseCode) {
        completedCourses
                .computeIfAbsent(studentId, k -> new HashSet<>())
                .add(courseCode);
    }

    boolean prerequisitesMet(String studentId, Course course) {
        HashSet<String> completed = completedCourses.getOrDefault(
                studentId, new HashSet<>());

        return completed.containsAll(course.prerequisites);
    }

    void registerStudent(String studentId, String courseCode) {
        Course course = courses.get(courseCode);

        if (course == null) {
            System.out.println("Course not found: " + courseCode);
            return;
        }

        if (course.enrolledStudents.contains(studentId)) {
            System.out.println(studentId + " is already enrolled.");
            return;
        }

        if (course.waitlist.contains(studentId)) {
            System.out.println(studentId + " is already waitlisted.");
            return;
        }

        if (!prerequisitesMet(studentId, course)) {
            System.out.println("Registration denied for " + studentId
                    + ": prerequisites not completed.");
            return;
        }

        if (course.hasSeat()) {
            course.enrolledStudents.add(studentId);
            System.out.println(studentId
                    + " enrolled in " + courseCode);
        } else {
            course.waitlist.addLast(studentId);
            System.out.println(studentId
                    + " added to waitlist for " + courseCode);
        }
    }

    void dropCourse(String studentId, String courseCode) {
        Course course = courses.get(courseCode);

        if (course == null) {
            System.out.println("Course not found: " + courseCode);
            return;
        }

        if (!course.enrolledStudents.remove(studentId)) {
            System.out.println(studentId
                    + " is not enrolled in " + courseCode);
            return;
        }

        System.out.println(studentId
                + " dropped " + courseCode);

        promoteWaitlistedStudent(course);
    }

    void promoteWaitlistedStudent(Course course) {
        if (!course.hasSeat() || course.waitlist.isEmpty()) {
            return;
        }

        // FIFO: promote the first student in the queue.
        String studentId = course.waitlist.removeFirst();
        course.enrolledStudents.add(studentId);

        System.out.println(studentId
                + " promoted from waitlist to "
                + course.courseCode);
    }

    void displayCourse(String courseCode) {
        Course course = courses.get(courseCode);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.println("\nCourse: " + course.courseCode);
        System.out.println("Capacity: " + course.capacity);
        System.out.println("Prerequisites: " + course.prerequisites);
        System.out.println("Enrolled students: "
                + course.enrolledStudents);
        System.out.println("Waitlist: " + course.waitlist);
    }

    public static void main(String[] args) {
        CourseRegistrationPortal portal =
                new CourseRegistrationPortal();

        portal.addCourse("CS101", 2, new ArrayList<>());
        portal.addCourse("CS201", 2,
                new ArrayList<>(Arrays.asList("CS101")));

        portal.completeCourse("S1", "CS101");
        portal.completeCourse("S2", "CS101");
        portal.completeCourse("S3", "CS101");
        portal.completeCourse("S4", "CS101");

        portal.registerStudent("S1", "CS201");
        portal.registerStudent("S2", "CS201");
        portal.registerStudent("S3", "CS201");
        portal.registerStudent("S4", "CS201");

        portal.dropCourse("S1", "CS201");

        portal.displayCourse("CS201");
    }
}
