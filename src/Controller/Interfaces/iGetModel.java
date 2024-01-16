package Controller.Interfaces;

import Model.Domain.Student;

import java.util.List;

public interface iGetModel {
    public List<Student> getStudents();

    boolean deleteStudent(int studentId);
}
