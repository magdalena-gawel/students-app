package pl.students.app;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class StudentsTest extends TestCase {
    protected Students all;
    protected Student jakub, adam, agnieszka;

    protected void setUp() {

        jakub = new Student("Jakub", "Ptak");
        adam = new Student("Adam", "Nowakowski");
        agnieszka = new Student("Agnieszka", "Noc");

        //pytanie: da się to zrobić jakoś zgrabniej? w ogole nie do konca mi to pasuje w setUp, ale jesli nie tu, to gdzie?
        jakub.setGrades(
                new ArrayList<Grade>(
                        Arrays.asList(new Grade(2.0, new Date()), new Grade(4.0, new Date()))
                )
        );
        adam.setGrades(
                new ArrayList<Grade>(
                        Arrays.asList(new Grade(2.0, new Date()))
                )
        );
        agnieszka.setGrades(
                new ArrayList<Grade>(
                        Arrays.asList(new Grade(6.0, new Date()), new Grade(5.0, new Date()))
                )
        );
        all = new Students();
        all.addStudent(jakub);
        all.addStudent(adam);
        all.addStudent(agnieszka);
    }

    public void testGetStudentsWithNameStartingWith() {
        ArrayList result = all.getStudentsWithNameStartingWith("A");

        ArrayList<Student> expected = new ArrayList<Student>();
        expected.add(adam);
        expected.add(agnieszka);

        assertEquals(expected, result);
    }

    public void testRemoveStudentsWithSurnameEndedWith() {
        ArrayList result = all.removeStudentsWithSurnameEndedWith("c");

        ArrayList<Student> expected = new ArrayList<Student>();
        expected.add(jakub);
        expected.add(adam);

        assertEquals(expected, result);
    }

    public void testSortByGrade() {
        ArrayList result = all.sortByGrade();

        ArrayList<Student> expected = new ArrayList<Student>();
        expected.add(adam);
        expected.add(jakub);
        expected.add(agnieszka);

        assertEquals(expected, result);
    }

}