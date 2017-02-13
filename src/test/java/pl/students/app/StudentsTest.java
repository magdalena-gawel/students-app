package pl.students.app;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentsTest {
    protected Students all;
    protected Student jakub, adam, agnieszka;

    @Before
    public void setUp() {
        /**
         * in case of a lot of data, fixtures can be put into separate json file, and then deserialized with ObjectMappers; gson
         */
        jakub = new Student("Jakub", "Ptak");
        adam = new Student("Adam", "Nowakowski");
        agnieszka = new Student("Agnieszka", "Noc");

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

    @Test
    public void testGetStudentsWithNameStartingWith() {
        ArrayList result = all.getStudentsWithNameStartingWith("A");

        ArrayList<Student> expected = new ArrayList<Student>();
        expected.add(adam);
        expected.add(agnieszka);

        assertEquals(expected, result);
    }

    //use annotations instead of extending TestCase class
    @Test
    public void testRemoveStudentsWithSurnameEndedWith() {
        List result = all.getStudentsWithSurnameNotEndedWith('c');

        List<Student> expected = new ArrayList<Student>();
        expected.add(jakub);
        expected.add(adam);

        assertEquals(expected, result);
    }

    @Test
    public void testSortByGrade() {
        ArrayList result = all.sortByGrade();

        ArrayList<Student> expected = new ArrayList<Student>();
        expected.add(adam);
        expected.add(jakub);
        expected.add(agnieszka);

        assertEquals(expected, result);
    }

}