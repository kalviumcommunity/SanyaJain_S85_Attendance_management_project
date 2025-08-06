# School Attendance System
This is a 10-part code-along project to build a console-based school attendance system in Java.

## Session 1: Introduction and Orientation
- Verified Java and Git setup.
- Initialized Git repository for the project.
- Created basic project structure with Main.java.
- Compiled and ran the initial "Welcome" program.
- Pushed initial setup to a part-01 branch on GitHub and created a PR.

### How to Run
1. Navigate to the project root directory (AttendanceSystem).
2. Compile: javac src/com/school/Main.java
3. Run: java -cp src com.school.Main

## Part 4: Data Encapsulation & Attendance Recording Validation
- Applied encapsulation to Student and Course classes by making fields private and adding public getters.
- Introduced a new AttendanceRecord class with private fields, a constructor, and getters to store attendance data.
- Implemented basic validation in the AttendanceRecord constructor for the attendance status (allowing only "Present" or "Absent").
- Used an ArrayList in Main.java to store and display AttendanceRecord objects.
- Demonstrated retrieving IDs using getters (e.g., student1.getStudentId()) when creating records.

### How to Run
1. Navigate to the project root directory.
2. Compile: javac src/com/school/*.java (or list individual files including AttendanceRecord.java)
3. Run: java -cp src com.school.Main
