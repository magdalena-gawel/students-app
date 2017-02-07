package pl.students.app;

import junit.framework.TestCase;

import java.util.*;

public class StudentIncorrectEqualsTest extends TestCase {

    public void testEquals() {
        StudentIncorrectEquals u1 = new StudentIncorrectEquals("Przemek", "Gawel");
        StudentIncorrectEquals u2 = new StudentIncorrectEquals("Przemek", "Gawel");
        assertFalse(u1.equals(u2));
    }

    public void testEqualsList() {
        StudentIncorrectEquals u1 = new StudentIncorrectEquals("Przemek", "Gawel");
        StudentIncorrectEquals u2 = new StudentIncorrectEquals("Przemek", "Gawel");

        ArrayList<StudentIncorrectEquals> students = new ArrayList<StudentIncorrectEquals>();
        students.add(u1);
        students.add(u2);
        assertEquals(2, students.size());
    }

    public void testEqualsSet() {
        StudentIncorrectEquals u1 = new StudentIncorrectEquals("Przemek", "Gawel");
        StudentIncorrectEquals u2 = new StudentIncorrectEquals("Przemek", "Gawel");

        Set<StudentIncorrectEquals> students = new HashSet<StudentIncorrectEquals>();
        students.add(u1);
        students.add(u2);
        assertEquals(2, students.size());
    }

    public void testHash() {
        StudentIncorrectEquals u1 = new StudentIncorrectEquals("Przemek", "Gawel");
        StudentIncorrectEquals u2 = new StudentIncorrectEquals("Przemek", "Nowakowski");

        Map<StudentIncorrectEquals, String> hm = new HashMap<StudentIncorrectEquals, String>();
        hm.put(u1, "Przemek");
        hm.put(u2, "Przemek");

        assertEquals(2, hm.size());

//        Worst-case scenario: that every hash value is the same, so all elements end up in the same bucket,
//        in which case you get O(n) performance (assuming the chains are linked lists)
    }
}