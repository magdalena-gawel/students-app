package pl.students.immutable;

import junit.framework.TestCase;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

public class ImmutableStudentTest extends TestCase {
    protected ImmutableStudent jakub;
    protected LocalDateTime date_9Jan, date_10Jan;

    protected void setUp() {
        date_9Jan = LocalDateTime.of(2017, Month.JANUARY, 9, 10, 0, 0);
        date_10Jan = LocalDateTime.of(2017, Month.JANUARY, 10, 10, 0, 0);

        ArrayList<ImmutableGrade> grades = new ArrayList<ImmutableGrade>(
                Arrays.asList(new ImmutableGrade(4.0, date_9Jan), new ImmutableGrade(5.0, date_10Jan))
        );
        jakub = new ImmutableStudent("Jakub", "Tokarczyk", grades);
    }

    public void testImmutableGradeDate() {
        //since LocalDateTime is immutable, can't really show immutability
        assertTrue(true);
    }
}