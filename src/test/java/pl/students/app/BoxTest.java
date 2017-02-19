package pl.students.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoxTest {

    @Test
    public void testEmptyBox() {
        Box<Object> emptyBox = new Box<>(null);
        assertEquals(null, emptyBox.whatsInTheBox());
        assertEquals(false, emptyBox.isPresent());
    }

    @Test
    public void testFilledBox() {
        Box<Double> filledBox = new Box<>(2.5);
        assertEquals(new Double(2.5), filledBox.whatsInTheBox());
        assertEquals(true, filledBox.isPresent());
    }

    @Test
    public void testAnotherFilledBox() {
        Box<String> filledBox = new Box<>("Magda");
        assertEquals("Magda", filledBox.whatsInTheBox());
        assertEquals(true, filledBox.isPresent());
    }
}