package pl.students.app;

import junit.framework.TestCase;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class StudentTest extends TestCase {

    private Student jakub;
    private LocalDateTime date_9Jan, date_10Jan;

    protected void setUp() {
        date_9Jan = LocalDateTime.of(2017, Month.JANUARY, 9, 10, 0, 0);
        date_10Jan = LocalDateTime.of(2017, Month.JANUARY, 10, 10, 0, 0);

        jakub = new Student("Jakub", "Tokarczyk");
        jakub.setGrades(
                new ArrayList<>(
                        Arrays.asList(new Grade(4.0, date_9Jan), new Grade(5.0, date_10Jan))
                )
        );
    }

    public void testMutableName() {
        String before = jakub.getName();
        jakub.setName("Kuba");
        String after = jakub.getName();
        assertThat(before, not(after));
    }

    public void testMutableGrades() {
        List<Grade> before = new ArrayList<Grade>();
        for (Grade temp : jakub.getGrades()) {
            Grade newgrade = new Grade(temp.getValue(), temp.getAnnounced());
            before.add(newgrade);
        }
        jakub.setGrades(
                new ArrayList<Grade>(
                        Arrays.asList(new Grade(4.0, date_10Jan), new Grade(5.0, date_10Jan))
                )
        );
        List<Grade> after = jakub.getGrades();
        assertThat(before, not(after));
    }

    public void testEquals() {
        Student u1 = new Student("Przemek", "Gawel");
        Student u2 = new Student("Przemek", "Gawel");
        assertTrue(u1.equals(u2));

        LocalDateTime date = LocalDateTime.now();
        Grade g1 = new Grade(9.0, date);
        Grade g2 = new Grade(9.0, date);
        assertTrue(g1.equals(g2));
    }

    public void testEqualsList() {
        Student u1 = new Student("Przemek", "Gawel");
        Student u2 = new Student("Przemek", "Gawel");

        ArrayList<Student> students = new ArrayList<Student>();
        students.add(u1);
        students.add(u2);
        assertEquals(2, students.size());
    }

    public void testEqualsSet() {
        Student u1 = new Student("Przemek", "Gawel");
        Student u2 = new Student("Przemek", "Gawel");

        Set<Student> students = new HashSet<Student>();
        students.add(u1);
        students.add(u2);
        assertEquals(1, students.size());
    }

}