package Model;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Класс ModelClassHash представляет модель данных студентов в архитектуре MVC (Model-View-Controller),
 * используя HashMap для хранения студентов.
 * Он содержит методы для получения списка студентов и удаления студентов по идентификатору.
 */
public class ModelClassHash implements iGetModel {
    /**
     * HashMap для хранения студентов, где ключ - идентификатор студента, значение - сам студент.
     */
    private HashMap<Integer,Student> students;

    /**
     * Конструктор класса ModelClassHash.
     *
     * @param students HashMap студентов для инициализации модели.
     */
    public ModelClassHash(HashMap<Integer, Student> students) {
        this.students = students;
    }

    /**
     * Получает текущий список студентов модели.
     *
     * @return Список студентов модели.
     */
    @Override
    public List<Student> getStudents() {
        List<Student> studList = new ArrayList<>();
        for(Student student: students.values()){
            studList.add(student);
        }
        return studList;
    }

    /**
     * Удаляет студента с указанным идентификатором из HashMap студентов модели.
     *
     * @param studentNumber Идентификатор студента для удаления.
     * @return true, если студент успешно удален, false, если студент с указанным идентификатором не найден.
     */
    @Override
    public boolean deleteStudent(int studentNumber) {
        if (students.containsKey(studentNumber)) {
            students.remove(studentNumber);
            return true;
        }
        return false;
    }
}
