package pl.students.app;

import junit.framework.TestCase;

import java.util.*;

public class StudentTest extends TestCase {

    protected Student jakub;
    protected Date date_9Jan, date_10Jan;

    protected void setUp() {
        Calendar cal = Calendar.getInstance();
        cal.set(2017, Calendar.JANUARY, 9);
        date_9Jan = cal.getTime();
        cal.set(2017, Calendar.JANUARY, 10);
        date_10Jan = cal.getTime();

        jakub = new Student("Jakub", "Tokarczyk");
        jakub.setGrades(
                new ArrayList<Grade>(
                        Arrays.asList(new Grade(4.0, date_9Jan), new Grade(5.0, date_10Jan))
                )
        );
    }

    /**
     * To nie jest test, ale chcialam na szybko przetestowac mutability.
     * Gdybym chciala tu wrzucic asercje, musialabym sklonowac/skopiowac wartosc sprzed operacji i porownac ja z data po operacji, prawda?
     * Probowalam i nie udalo mi sie, zawsze obie porownywane wartosci sa identyczne
     */
    public void testMutableGradeDate() {
        System.out.println("========= Mutable grade date: =========");
        System.out.println(jakub.getGrades());
        date_9Jan.setMonth(date_9Jan.getMonth() + 1); //deprecated, ale gdy uzywam Calendar, nie widac problemu z mutability
        System.out.println(jakub.getGrades());
    }

    /**
     * To tez nie jest test, podobnie jak wyzej
     */
    public void testMutableGrades() {
        System.out.println("========= Mutable grades: =========");
        System.out.println(jakub.getGrades());
        jakub.setGrades(
                new ArrayList<Grade>(
                        Arrays.asList(new Grade(4.0, date_10Jan), new Grade(5.0, date_10Jan))
                )
        );
        System.out.println(jakub.getGrades());
    }

    public void testEquals() {
        Student u1 = new Student("Przemek", "Gawel");
        Student u2 = new Student("Przemek", "Gawel");
        assertTrue(u1.equals(u2));

        Date date = new Date();
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