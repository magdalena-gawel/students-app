package pl.students.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentBoxTest {

    @Test
    public void testEmptyBox() {
        StudentBox emptyBox = new StudentBox(null);
        assertEquals(null, emptyBox.whatsInTheBox());
        assertEquals(false, emptyBox.isPresent());
    }

    @Test
    public void testStudentSuper() {
        Student student = new Student("Jakub", "Tokarczyk");
        StudentBox filledBox = new StudentBox(student);
        assertEquals(student, filledBox.whatsInTheBox());
        assertEquals(true, filledBox.isPresent());
    }

    @Test
    public void testStudentChild() {
        Student studentA = new StudentGroupA("Jakub", "Tokarczyk");
        StudentBox filledBox = new StudentBox(studentA);
        assertEquals(studentA, filledBox.whatsInTheBox());
        assertEquals(true, filledBox.isPresent());
    }
}