package com.school;

import java.util.ArrayList;
import java.util.List;

public class Course implements Storable {
    private static int idCounter = 101;
    private int courseId;
    private String courseName;
    private int capacity;
    private List<Student> enrolledStudents;

    public Course(String courseName, int capacity) {
        this.courseId = idCounter++;
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public int getNumberOfEnrolledStudents() {
        return enrolledStudents.size();
    }

    public boolean addStudent(Student student) {
        if (student == null) return false;
        if (enrolledStudents.size() >= capacity) return false;
        if (enrolledStudents.contains(student)) return false;
        enrolledStudents.add(student);
        return true;
    }

    public void displayDetails() {
        System.out.println(
            "Course ID: " + courseId + ", Name: " + courseName +
            ", Capacity: " + capacity +
            ", Enrolled: " + getNumberOfEnrolledStudents()
        );
    }

    @Override
    public String toDataString() {
        return courseId + "," + courseName + "," + capacity;
    }
}