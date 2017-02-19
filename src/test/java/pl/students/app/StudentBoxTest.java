package pl.students.app;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentBoxTest {

    @Test
    public void testEmptyBox() {
        StudentBox emptyBox = new StudentBox<>(null);
        assertEquals(null, emptyBox.whatsInTheBox());
        assertEquals(false, emptyBox.isPresent());
    }

    @Test
    public void testStudentSuper() {
        Student student = new Student("Jakub", "Tokarczyk");
        StudentBox filledBox = new StudentBox<>(student);
        assertEquals(student, filledBox.whatsInTheBox());
        assertEquals(true, filledBox.isPresent());
    }

    @Test
    public void testStudentChild() {
        Student studentA = new StudentGroupA("Jakub", "Tokarczyk");
        //wont compile
        //StudentBox filledBox = new StudentBox<>(0.0);
        StudentBox filledBox = new StudentBox<>(studentA);
        assertEquals(studentA, filledBox.whatsInTheBox());
        assertEquals(true, filledBox.isPresent());
    }

    @Test
    public void testBoxCollection() {
        //- utworzyć kolekcję pudełek (poczytaj o kowariancji w Javie)
        // not sure if i get the point
        List<StudentBox> boxes = new ArrayList<StudentBox>();

        Student student = new Student("Jakub", "Tokarczyk");
        StudentBox filledBox = new StudentBox<>(student);
        boxes.add(filledBox);

        Student studentA = new StudentGroupA("Maja", "Tokarczyk");
        StudentBox filledBoxA = new StudentBox<>(studentA);
        boxes.add(filledBoxA);

        List<StudentBox> expected = new ArrayList<StudentBox>(
                Arrays.asList(filledBox, filledBoxA)
        );

        assertEquals(expected, boxes);
    }
}