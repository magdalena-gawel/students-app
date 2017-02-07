package pl.students.app;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class StudentIncorrectEqualsAndHashTest extends TestCase {

    public void testHash() {
        StudentIncorrectEqualsAndHash u1 = new StudentIncorrectEqualsAndHash("Przemek", "Gawel");
        StudentIncorrectEqualsAndHash u2 = new StudentIncorrectEqualsAndHash("Przemek", "Nowakowski");

        Map<StudentIncorrectEqualsAndHash, String> hm = new HashMap<StudentIncorrectEqualsAndHash, String>();
        hm.put(u1, "Przemek");
        hm.put(u2, "Przemek");

        assertEquals(1, hm.size());

//        Worst-case scenario: that every hash value is the same, so all elements end up in the same bucket,
//        in which case you get O(n) performance (assuming the chains are linked lists)
    }

}