package pl.students.app;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentListBoxTest {

    @Test
    public void testStudentSuper() {
        Student student = new Student("Jakub", "Tokarczyk");
        List<Student> list = new ArrayList<>();
        list.add(student);
        //wont work
        //StudentListBox<Student> filledBox = new StudentListBox<>(new ArrayList<Double>());
        StudentListBox<Student> filledBox = new StudentListBox<>(list);
        assertEquals(list, filledBox.whatsInTheBox());
    }

}