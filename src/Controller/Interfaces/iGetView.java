package Controller.Interfaces;

import Model.Domain.Student;

import java.util.List;

public interface iGetView {
    void printAllStudents(List<Student> students);

    String prompt(String msg);
}
