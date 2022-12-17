package com.example.school.Services;

import com.example.school.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class TeacherService {

    private final ArrayList<Teacher> tch = new ArrayList<>();

    public void add(Teacher teacher) {
        tch.add(teacher);
    }
    public ArrayList<Teacher> getAll() {
        return tch;
    }
    public boolean isTeacher(int TeacherID) {
        for (Teacher teacher : tch)
            if (teacher.getID() == TeacherID)
                return true;

        return false;
    }

    public Teacher getTeacher(int TeacherID) {
        for (Teacher teacher : tch)
            if (teacher.getID() == TeacherID)
                return teacher;

        return null;
    }


    public String updateTea(Teacher Tea) {
        for (int i = 0; i < tch.size(); i++) {
            if (tch.get(i).getID().equals(Tea.getID()))
                tch.set(i, Tea);
        }

        return "Teacher updated successfully";
    }

    public String delTea(int TeaID) {
        for (int i = 0; i < tch.size(); i++) {
            if (tch.get(i).getID() == TeaID)
                tch.remove(TeaID);
        }
        return "Teacher Deleted Successfully";
    }

    public ArrayList<Teacher> getTeacherOver(double salary) {
        ArrayList<Teacher> studentResults = new ArrayList<>();
        for (Teacher teacher : tch) {
            if (teacher.getSalary() >= salary)
                studentResults.add(teacher);
        }
        return  studentResults;
    }

}
