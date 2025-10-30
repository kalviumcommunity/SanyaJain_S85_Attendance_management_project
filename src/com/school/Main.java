package com.school;


import java.util.List;

public class Main {

    public static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\n--- School Directory ---");
        List<Person> people = regService.getAllPeople();
        if (people.isEmpty()) {
            System.out.println("No people in the directory.");
            return;
        }
        for (Person person : people) {
            person.displayDetails();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- School Administration & Attendance System (Overloaded Commands Demo) ---");

        // --- Initialize Services ---
        FileStorageService storageService = new FileStorageService();
        RegistrationService regService = new RegistrationService(storageService);
        AttendanceService attendanceService = new AttendanceService(storageService, regService);

        // --- Data Setup via RegistrationService ---
        Student student1 = regService.registerStudent("Alice Wonderland", "Grade 10");
        Student student2 = regService.registerStudent("Bob The Builder", "Grade 9");
        Teacher teacher1 = regService.registerTeacher("Dr. Emily Carter", "Physics");
        Staff staff1 = regService.registerStaff("Mr. John Davis", "Librarian");

        displaySchoolDirectory(regService);

        // --- Course Setup via RegistrationService (with capacity) ---
        Course course1 = regService.createCourse("Intro to Quantum Physics", 2);
        Course course2 = regService.createCourse("Advanced Algorithms", 1);

        // --- Enrollments ---
        System.out.println("\n\n--- Enrolling Students ---");
        regService.enrollStudentInCourse(student1, course1); // succeed
        regService.enrollStudentInCourse(student2, course1); // succeed
        regService.enrollStudentInCourse(student2, course1); // duplicate attempt
        regService.enrollStudentInCourse(student1, course2); // succeed
        regService.enrollStudentInCourse(student2, course2); // fail (capacity)

        System.out.println("\n\n--- Courses After Enrollment ---");
        for (Course c : regService.getCourses()) {
            c.displayDetails();
        }

        // --- Demonstrate Overloaded markAttendance() Methods ---
        System.out.println("\n\n--- Marking Attendance (Overloaded Methods) ---");

        // Only mark attendance if student is enrolled in the course
        if (course1.getEnrolledStudents().contains(student1)) {
            attendanceService.markAttendance(student1.getId(), course1.getCourseId(), "Present");
        }
        if (course2.getEnrolledStudents().contains(student2)) {
            attendanceService.markAttendance(student2.getId(), course2.getCourseId(), "Absent");
        } else {
            System.out.println("Skipping attendance: " + student2.getName() + " is not enrolled in " + course2.getCourseName());
        }
        if (course2.getEnrolledStudents().contains(student1)) {
            attendanceService.markAttendance(student1.getId(), course2.getCourseId(), "Late");
        }

        // --- Display Attendance Logs ---
        System.out.println("\n\n--- Full Attendance Log ---");
        attendanceService.displayAttendanceLog();

        System.out.println("\n\n--- Attendance for Student: " + student1.getName() + " ---");
        attendanceService.displayAttendanceLog(student1);

        System.out.println("\n\n--- Attendance for Course: " + course2.getCourseName() + " ---");
        attendanceService.displayAttendanceLog(course2);

        // --- Save All Data ---
        System.out.println("\n\n--- Saving Registration & Attendance Data ---");
        regService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\nSession 9: SRP with Registration & Attendance Services Complete.");
    }
}