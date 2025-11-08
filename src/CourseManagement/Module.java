package CourseManagement;

import UserManagement.Lecturer;
import Interfaces.Assignable;


import java.io.File;

/**
 * Module
 * ---------------------------------------------------------
 * Represents an academic module within a course in the UCMS system.
 * Responsibilities include:
 *  - Storing module details: code, name, level, semester, credits
 *  - Managing module outline files
 *  - Assigning the module to a Lecturer (or other User via Assignable interface)
 *  - Tracking marks scored by students (future use)
 *
 * Implements the Assignable interface to allow flexible assignment to a User.
 */
public class Module implements Interfaces.Assignable<Lecturer> {

    // ---------------------- FIELDS ----------------------

    /** Unique code for the module (e.g., CS101) */
    private String moduleCode;

    /** Name of the module (e.g., Introduction to Programming) */
    private String moduleName;

    /** Course code of the module this module belongs to */
    private String courseCode;

    /** Semester the module is taught */
    private int semester;

    /** Number of credits for the module */
    private int credits;

    /** Academic level of the module */
    private int level;

    /** File representing the module outline (syllabus) */
    private File moduleOutline;

    /** Marks scored by a student in this module */
    private double marksScored;

    /** Lecturer assigned to teach this module */
    private Lecturer lecturer;

    // ---------------------- CONSTRUCTOR ----------------------

    /**
     * Constructs a Module object with the specified parameters.
     *
     * @param moduleCode  unique module code
     * @param moduleName  name/title of the module
     * @param courseCode  course code this module belongs to
     * @param level       academic level of the module
     * @param semester    semester the module is taught
     * @param credits     number of credits for the module
     */
    public Module(String moduleCode, String moduleName,
                  String courseCode, int level, int semester, int credits) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.courseCode = courseCode;
        this.level = level;
        this.semester = semester;
        this.credits = credits;
    }

    // ---------------------- GETTERS & SETTERS ----------------------

    public String getModuleCode() { return moduleCode; }
    public void setModuleCode(String moduleCode) { this.moduleCode = moduleCode; }

    public String getModuleName() { return moduleName; }
    public void setModuleName(String moduleName) { this.moduleName = moduleName; }

    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

    public int getSemester() { return semester; }
    public void setSemester(int semester) { this.semester = semester; }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public double getMarksScored() { return marksScored; }
    public void setMarksScored(double marksScored) { this.marksScored = marksScored; }

    public Lecturer getLecturer() { return lecturer; }
    public void setLecturer(Lecturer lecturer) { this.lecturer = lecturer; }

    public File getModuleOutline() { return moduleOutline; }

    /**
     * Sets the module outline file using a file path.
     * Prints a warning if the file does not exist.
     *
     * @param moduleOutlinePath path to the module outline file
     */
    public void setModuleOutline(String moduleOutlinePath) {
        File moduleFile = new File(moduleOutlinePath);
        if (!moduleFile.exists()) {
            System.out.println("Module Outline does not exist at: " + moduleOutlinePath);
        } else {
            this.moduleOutline = moduleFile;
        }
    }

    public void setModuleOutline(File moduleOutline) { this.moduleOutline = moduleOutline; }

    // ---------------------- TO STRING ----------------------

    @Override
    public String toString() {
        String lecturerInfo = (lecturer != null)
                ? lecturer.getFirstname() + " " + lecturer.getLastname()
                : "Unassigned";
        return moduleCode + " - " + moduleName + " (Lecturer: " + lecturerInfo + ")";
    }

    // ---------------------- ASSIGNABLE INTERFACE METHODS ----------------------

    /**
     * Assigns this module to a User (currently only supports Lecturer).
     *
     * @param user the user to assign this module to
     */
//    @Override
//    public void assignTo(User user) {
//        if (user instanceof Lecturer) {
//            this.lecturer = (Lecturer) user;
//        } else {
//            System.out.println("Only a Lecturer can be assigned to a module.");
//        }
//    }

    @Override
    public void assignTo(Lecturer l) {
        if (l == null) return;

        // If already assigned to someone else, clean up that relationship first.
        if (this.lecturer != null) {
            this.lecturer.getModulesTaught().remove(moduleCode + " - " + moduleName);
        }

        this.lecturer = l;

        // Reflect on the lecturer side (store "CODE - NAME" as per your Lecturer design)
        // Make sure Lecturer.getModulesTaught() is initialized (e.g., new ArrayList<>()).
        String friendlyName = moduleCode + " - " + moduleName;
        if (!l.getModulesTaught().contains(friendlyName)) {
            l.getModulesTaught().add(friendlyName);
        }
    }

    /**
     * Returns the current assignee of this module.
     *
     * @return assigned user (Lecturer) or null if unassigned
     */
    @Override
    public Lecturer getAssignee() {
        return lecturer;
    }



    /**
     * Checks if this module is currently assigned to a Lecturer.
     *
     * @return true if assigned, false otherwise
     */
    @Override
    public boolean isAssigned() {
        return lecturer != null;
    }

    /**
     * Removes the current assignment of this module.
     */
    @Override
    public void unassign() {
        if (lecturer != null) {
            lecturer.getModulesTaught().remove(moduleCode + " - " + moduleName);
        }
        lecturer = null;
    }
}
