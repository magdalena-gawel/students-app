package pl.students.immutable;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class ImmutableStudentTest extends TestCase {
    protected ImmutableStudent jakub;
    protected Date date_9Jan, date_10Jan;

    protected void setUp() {
        Calendar cal = Calendar.getInstance();
        cal.set(2017, Calendar.JANUARY, 9);
        date_9Jan = cal.getTime();
        cal.set(2017, Calendar.JANUARY, 10);
        date_10Jan = cal.getTime();

        ArrayList<ImmutableGrade> grades = new ArrayList<ImmutableGrade>(
                Arrays.asList(new ImmutableGrade(4.0, date_9Jan), new ImmutableGrade(5.0, date_10Jan))
        );
        jakub = new ImmutableStudent("Jakub", "Tokarczyk", grades);
    }

    public void testImmutableGradeDate() {
        System.out.println("========= Immutable grade date: =========");
        System.out.println(jakub.getGrades());
        date_9Jan.setMonth(date_9Jan.getMonth() + 1); //deprecated, ale gdy uzywam Calendar, nie widac problemu z mutability
        System.out.println(jakub.getGrades());
    }
}