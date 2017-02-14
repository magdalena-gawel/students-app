package pl.students.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentGroupA extends Student{

    StudentGroupA(String name, String surname) {
        // Here I am explicitly calling the superclass
        // constructor - since constructors are not inherited
        // you must chain them like this.
        super(name, surname);
    }
}
