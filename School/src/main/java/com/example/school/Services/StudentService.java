package com.example.school.Services;

import com.example.school.Model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@Component
public class StudentService

{

    private final ArrayList<Student> std = new ArrayList<>();
    public void add(Student stu) {
        std.add(stu);
    }

    public ArrayList<Student> getAll() {
        return std;
    }
    public boolean isStu(int studentID) {
        for (Student student : std)
            if (student.getID() == studentID)
                return true;

        return false;
    }

    public Student getStudent(int studentID) {
        for (Student student : std)
            if (student.getID() == studentID)
                return student;

        return null;
    }

    public Student getStuByName(String studentName) {
        for (Student student : std)
            if (student.getName().equalsIgnoreCase(studentName))
                return student;

        return null;
    }
    public String updateStudent(Student student) {
        for (int i = 0; i < std.size(); i++) {
            if (std.get(i).getID()  .equals(student.getID()))
                std.set(i, student);
        }

        return "Student Updated Successfully!!";
    }
    public String delStu(int studentID) {
        for (int i = 0; i < std.size(); i++) {
            if (std.get(i).getID() == studentID)
                std.remove(studentID);
        }
        return "Student Deleted successfully !!";
    }


    public ArrayList<Student> getStuMajoredIn(String stuMajor) {
        ArrayList<Student> stuResults = new ArrayList<>();
        for (Student student : std) {
            if (student.getMajor().equalsIgnoreCase(stuMajor))
                stuResults.add(student);
        }

        return  stuResults;
    }
    public boolean isMajor(String studentMajor) {
        return studentMajor.equalsIgnoreCase("CS")
                || studentMajor.equalsIgnoreCase("Math")
                || studentMajor.equalsIgnoreCase("Engineering")
                || studentMajor.equalsIgnoreCase("Engineer");
    }

    public ArrayList<Student> getStudentOver(int age) {
        ArrayList<Student> studentResults = new ArrayList<>();
        for (Student student : std) {
            if (student.getAge() >= age)
                studentResults.add(student);
        }
        return  studentResults;
    }

}
