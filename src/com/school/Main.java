package com.school;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("--- School Administration & Attendance System ---");

      
        // --- Creating Students ---
        Student student1 = new Student("Alice Wonderland", "Grade 10");
        Student student2 = new Student("Bob The Builder", "Grade 9");

        // --- Creating Teacher & Staff ---
        Teacher teacher1 = new Teacher("Dr. Emily Carter", "Physics");
        Staff staff1 = new Staff("Mr. John Davis", "Librarian");

        System.out.println("\n--- School Personnel Details ---");
        student1.displayDetails();
        student2.displayDetails();
        teacher1.displayDetails();
        staff1.displayDetails();

        
        // --- Creating Courses ---
        Course course1 = new Course("Intro to Quantum Physics");
        Course course2 = new Course("Advanced Mathematics");

        System.out.println("\nAvailable Courses:");
        course1.displayDetails();
        course2.displayDetails();


        // --- Attendance Recording (Modified to use Person's ID) ---
        // --- Attendance Recording ---
        System.out.println("\n--- Attendance Recording ---");
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Student1 attends course1
        AttendanceRecord record1 = new AttendanceRecord(student1.getId(), course1.getCourseId(), "Present");
        AttendanceRecord record2 = new AttendanceRecord(student2.getId(), course1.getCourseId(), "Absent");
        attendanceLog.add(record1);

        // Student2 attempts to attend course1 with an invalid status
       
        attendanceLog.add(record2);

        System.out.println("\n--- Attendance Log ---");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        // --- Saving Data to Files ---
        FileStorageService storage = new FileStorageService();

        // Save Students
        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        storage.saveData(students, "students.txt");

        // Save Courses
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        storage.saveData(courses, "courses.txt");

        // Save Attendance
        storage.saveData(attendanceLog, "attendance_log.txt");

        System.out.println("\n✅ Session 6: Data persisted successfully to text files.");
    }
}
