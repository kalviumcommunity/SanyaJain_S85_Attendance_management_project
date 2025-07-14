// Source code is decompiled from a .class file using FernFlower decompiler.
package com.school;

public class Main {
   public Main() {
   }

   public static void main(String[] var0) {
     
      Course[] courses = new Course[2];
      courses[0] = new Course();
      courses[0].setter(101, "Mathematics");
      courses[1] = new Course();
      courses[1].setter(102, "Science");


      for (Course course : courses) {
          course.display();
      }


      Student[] students = new Student[2];
      students[0] = new Student();
      students[0].setter(1, "Alice");
      students[1] = new Student();
      students[1].setter(2, "Bob");

   
      for (Student student : students) {
          student.display();
      }

     
   }
}