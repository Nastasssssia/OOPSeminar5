package Controller;

import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.Domain.Student;


import java.util.ArrayList;
import java.util.List;


/**
 * Класс ControllerClass является контроллером в архитектуре MVC (Model-View-Controller).
 * Он отвечает за управление взаимодействием между моделью (iGetModel) и представлением (iGetView).
 */
public class ControllerClass {

    /**
     * Модель, представляющая данные студентов.
     */
    private iGetModel model;

    /**
     * Представление, отвечающее за отображение данных пользователю.
     */
    private iGetView view;

    /**
     * Буфер данных для временного хранения полученных от модели данных студентов.
     */

    private List<Student> buferData = new ArrayList<>();

    /**
     * Конструктор класса ControllerClass.
     *
     * @param model Модель, представляющая данные студентов.
     * @param view  Представление, отвечающее за отображение данных пользователю.
     */
    public ControllerClass(iGetModel model, iGetView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Проверяет, содержит ли список студентов данные, и возвращает результат теста.
     *
     * @param stud Список студентов для тестирования.
     * @return true, если список студентов не пустой, в противном случае - false.
     */
    private boolean testData(List<Student> stud) {
        if (!stud.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Обновляет данные, полученные от модели, и отображает их через представление.
     */
    public void update() {
        //MVP
        buferData = model.getStudents(); //возврат от модели в контролер
        if (testData(buferData)) { //если тест пройдет
            view.printAllStudents(buferData);//возвращаем view список студентов
        } else {
            System.out.println("Список студентов пуст");
        }
        //MVC
        // view.printAllStudents(model.getStudents());
    }

    /**
     * Запускает цикл взаимодействия с пользователем и обрабатывает введенные команды.
     */
    public void run() {
        Command com = (Command) Command.NONE;
        boolean getNewIter = true;
        while (getNewIter) {
            String command = view.prompt("Введите команду:");
            com = Command.valueOf(command.toUpperCase());
            switch (com) {
                case EXIT:
                    getNewIter = false;
                    System.out.println("Выход из программы");
                    break;
                case LIST:
                    view.printAllStudents(model.getStudents());
                    break;
                case DELETE:
                    deleteStudent();
                    break;
                default:
                    System.out.println("Неизвестная команда");
                    break;
            }
        }
    }

    /**
     * Удаляет студента с заданным идентификатором и выводит соответствующее сообщение.
     */
    private void deleteStudent() {
        try {
            int studentId = Integer.parseInt(view.prompt("Введите ID студента для удаления:"));
            if (model.deleteStudent(studentId)) {
                System.out.println("Студент успешно удален");
            } else {
                System.out.println("Студент с таким ID не найден");
            }
        } catch (NumberFormatException e) {
            System.out.println("Некорректный формат номера ID студента");
        }
    }
}