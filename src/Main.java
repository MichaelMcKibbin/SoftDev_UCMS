import CourseManagement.Course;
import CourseManagement.Module;
import UserManagement.Admin;
import UserManagement.Lecturer;
import UserManagement.Student;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        loadSampleData();
        UCMS.determineRole();
    }
    // Create some sample data
    public static void loadSampleData() {
        System.out.println("Loading sample UCMS data...");

        // Sample Admin
        Admin admin1 = new Admin("Alice", "Adminson", "alice@uni.ie", "pass123", "", "0871111111");
        UCMS.admin = admin1;

        // Create sample Lecturers (String firstname, String lastname, String email, String password, String address, String phone, String lecturerId, String department)
        Lecturer lec1 = new Lecturer("John", "Smith", "john.smith@atu.ie", "password", "123 new street, anytown", "555-1212", "L001", "Computing");
        Lecturer lec2 = new Lecturer("Jane", "Smith", "jane.smith@atu.ie", "password", "123 new street, anytown", "555-1212", "L002", "Mathematics");
        Lecturer lec3 = new Lecturer("Bob", "Smith", "bob.smith@atu.ie", "password", "123 new street, anytown", "555-1212", "L003", "Physics");
        UserManagement.LecturerManagementModule.lecturersList.addAll(Arrays.asList(lec1, lec2, lec3));

        // Create sample Students
        Student s1 = new Student("Sara", "Kelly", "sara.kelly@atu.ie", "P4$$w0rd", "5 new town", "1265444152", "S001", "01/01/1979");
        Student s2 = new Student("John", "Doe", "john.doe@atu.ie", "P4$$w0rd", "5 new town", "1265444152", "S002", "01/01/1979");
        Student s3 = new Student("Jane", "Doe", "jane.doe@atu.ie", "P4$$w0rd", "5 new town", "1265444152", "S003", "01/01/1979");
        UserManagement.StudentManagementModule.studentsContainer.addAll(Arrays.asList(s1, s2, s3));

        // Sample Courses
        Course c1 = new Course("CS101", "Intro to Programming");
        Course c2 = new Course("CS202", "Data Structures");
        Course c3 = new Course("CS303", "Object Oriented Programming");
        CourseManagement.CourseManagementModule.courseList.addAll(Arrays.asList(c1, c2, c3));

        // Sample Modules
        Module m1 = new CourseManagement.Module("CS101", "Java Basics", "CS101", 1, 1, 30);
        Module m2 = new CourseManagement.Module("CS202", "Data Structures", "CS202", 1, 1, 30);
        Module m3 = new CourseManagement.Module("CS303", "OOP", "CS303", 1, 1, 30);
        CourseManagement.CourseManagementModule.moduleList.addAll(Arrays.asList(m1, m2, m3));

        // Assign Lecturers to Modules
        m1.assignTo(lec1);
        m2.assignTo(lec2);
        m3.assignTo(lec3);

        // Assign Modules to Courses (optional, depending on your data model)
        c1.getModules().add(m1);
        c2.getModules().add(m2);

        // Assign Students to Courses (if applicable)
        s1.assignTo(c1);
        s2.assignTo(c2);

        System.out.println("Sample data loaded successfully.\n");
    }

}

