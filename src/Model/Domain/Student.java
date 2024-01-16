package Model.Domain;

public class Student extends Person implements Comparable<Student>{

    private int id;

    private static int generalId;


    public Student(String name, int age) {
        super(name, age);
        this.id = generalId;
        generalId++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return super.toString() + ", id: " + this.id;
    }

    @Override
    public int compareTo(Student o) {
        System.out.println(super.getName() + "-" + o.getName());
        if(super.getAge() > o.getAge()) return 1;
        if(super.getAge() < o.getAge()) return -1;
        if(this.id > o.id) return 1;
        if(this.id < o.id) return -1;
        return 0;
    }
}
