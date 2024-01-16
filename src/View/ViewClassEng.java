package View;

import Controller.Interfaces.iGetView;
import Model.Domain.Student;

import java.util.List;
import java.util.Scanner;

/**
 * Класс ViewClassEng реализует интерфейс iGetView и представляет представление в англоязычной версии.
 * Он содержит методы для вывода списка студентов и ввода пользовательских команд.
 */
public class ViewClassEng implements iGetView {

    /**
     * Выводит список студентов на экран в англоязычном формате.
     *
     * @param students Список студентов для вывода.
     */
    public void printAllStudents(List<Student> students){
        System.out.println("--------------------------List of students------------------------------");
        for(Student s: students){
            System.out.println(s);
        }
        System.out.println("------------------------------------------------------------------------");
    }

    /**
     * Выводит приглашение для пользователя и ожидает ввода.
     *
     * @param msg Сообщение-приглашение для пользователя.
     * @return Введенная пользователем строка.
     */
    @Override
    public String prompt(String msg) {
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        return in.nextLine();
    }
}
