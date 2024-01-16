import Controller.ControllerClass;
import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.Domain.Student;
import Model.ModelClass;
import Model.ModelClassFile;
import Model.ModelClassHash;
import View.ViewClass;
import View.ViewClassEng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Ivan", 21);
        Student student2 = new Student("Anna", 25);
        Student student3 = new Student("Vasya", 22);
        Student student4 = new Student("Nastya", 27);
        Student student5 = new Student("Vasilisa", 26);
        Student student6 = new Student("Karina", 25);
        Student student7 = new Student("Andrey", 22);
        Student student8 = new Student("Masha", 27);
        Student student9 = new Student("Irina", 28);
        Student student10 = new Student("Nikolay", 30);
        List<Student> studList = new ArrayList<>();
        studList.add(student1);
        studList.add(student2);
        studList.add(student3);
        studList.add(student4);
        studList.add(student5);
        studList.add(student6);
        studList.add(student7);
        studList.add(student8);
        studList.add(student9);
        studList.add(student10);

        // Создаем HashMap студентов и добавляем их в нее с помощью ключей
        HashMap<Integer,Student> studList2 = new HashMap<>();
        studList2.put(0,student1);
        studList2.put(1,student2);
        studList2.put(2,student3);
        studList2.put(3,student4);
        studList2.put(4,student5);
        studList2.put(5,student6);
        studList2.put(6,student7);
        studList2.put(7,student8);




        //iGetModel modelFile = new ModelClassFile("studentDB.csv");
        //modelFile.saveAllStudentToFile(studList);

        //iGetModel model = new ModelClass(studList);
        //iGetView view = new ViewClass();
       // ControllerClass controller = new ControllerClass(model,view);

        // Создаем модель на основе HashMap
        iGetModel model1 = new ModelClassHash(studList2);
        // Создаем англоязычное представление
       iGetView viewEng = new ViewClassEng();

        // Создаем контроллер и передаем ему модель и представление
       ControllerClass controllerEng = new ControllerClass(model1,viewEng);



        //controller.run();
        controllerEng.run();

        //view.printAllStudents(model.getStudents());
        //viewEng.printAllStudents(model.getStudents());

    }
}