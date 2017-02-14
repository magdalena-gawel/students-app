package pl.students.app;

public class StudentGroupB extends Student{

    StudentGroupB(String name, String surname) {
        // Here I am explicitly calling the superclass
        // constructor - since constructors are not inherited
        // you must chain them like this.
        super(name, surname);
    }
}
