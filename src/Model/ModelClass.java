package Model;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;

import java.util.Iterator;
import java.util.List;

/**
 * Класс ModelClass представляет модель данных студентов в архитектуре MVC (Model-View-Controller).
 * Он содержит список студентов и предоставляет методы для получения этого списка и удаления студентов.
 */
public class ModelClass implements iGetModel {
    /**
     * Список студентов, представляющих данные модели.
     */
    private List<Student> students;

    /**
     * Конструктор класса ModelClass.
     *
     * @param students Список студентов для инициализации модели.
     */
    public ModelClass(List<Student> students) {
        this.students = students;
    }

    /**
     * Получает текущий список студентов модели.
     *
     * @return Список студентов модели.
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Удаляет студента с указанным идентификатором из списка студентов модели.
     *
     * @param studentNumber Идентификатор студента для удаления.
     * @return true, если студент успешно удален, false, если студент с указанным идентификатором не найден.
     */
    @Override
    public boolean deleteStudent(int studentNumber) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == studentNumber) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}


