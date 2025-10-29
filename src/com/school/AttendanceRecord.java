package com.school;
public class AttendanceRecord implements Storable {
    private int studentId;
    private int courseId;
    private String status;

 
    public AttendanceRecord(int studentId, int courseId, String status) {
        this.studentId = studentId;
        this.courseId = courseId;
        if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
            this.status = status.substring(0, 1).toUpperCase() + status.substring(1).toLowerCase();
        } else {
            this.status = "Invalid";
            System.out.println("⚠ Warning: Invalid attendance status entered. Must be 'Present' or 'Absent'.");
        }
    }
  

  
    public int getStudentId() {
        return studentId;
    }

  
  public int getCourseId() {
    return courseId;
  }
   

  public String getStatus() {
    return status;
  }
    public void displayRecord() {
        System.out.println("Student ID: " + studentId +
                ", Course ID: " + courseId +
                ", Status: " + status);
    }


    @Override
    public String toDataString() {
        return studentId + "," + courseId + "," + status;
    }
}