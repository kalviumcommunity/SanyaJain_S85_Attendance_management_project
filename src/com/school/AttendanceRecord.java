package com.school;

public class AttendanceRecord implements Storable {
    private Student student;
    private Course course;
    private String status;

    public AttendanceRecord(Student student, Course course, String status) {
        this.student = student;
        this.course = course;
        this.status = status.substring(0, 1).toUpperCase() + status.substring(1).toLowerCase();
        if ("Present".equalsIgnoreCase(status) || "Absent".equalsIgnoreCase(status)) {
            this.status = status;
        } else {
            this.status = "Invalid";
            System.out.println("Warning: Invalid attendance status provided ('" + status + "'). Set to 'Invalid'.");
        }
    }

    public Student getStudent() { 
        return student; 
    }

    public Course getCourse() { 
        return course; 
    }

    public String getStatus() { 
        return status; 
    }

    public void displayRecord() {
        System.out.println("Attendance: Student " + student.getName() + 
            " (ID: " + student.getId() + ")" + 
            " in course '" + course.getCourseName() + "' (ID: " + course.getCourseId() + ")" + 
            " - Status: " + status);
    }

    @Override
    public String toDataString() {
        return student.getId() + "," + course.getCourseId() + "," + status;
    }
}