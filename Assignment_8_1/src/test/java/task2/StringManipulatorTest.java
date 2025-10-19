package task2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringManipulatorTest {

    private final StringManipulator sm = new StringManipulator();

    @Test
    void testConcatenate() {
        assertEquals("HelloWorld", sm.concatenate("Hello", "World"));
        assertEquals("12345", sm.concatenate("123", "45"));
    }

    @Test
    void testFindLength() {
        assertEquals(5, sm.findLength("Hello"));
        assertEquals(0, sm.findLength(""));
        assertEquals(0, sm.findLength(null));
    }

    @Test
    void testConvertToUpperCase() {
        assertEquals("HELLO", sm.convertToUpperCase("hello"));
        assertNull(sm.convertToUpperCase(null));
    }

    @Test
    void testConvertToLowerCase() {
        assertEquals("world", sm.convertToLowerCase("WORLD"));
        assertNull(sm.convertToLowerCase(null));
    }

    @Test
    void testContainsSubstring() {
        assertTrue(sm.containsSubstring("HelloWorld", "World"));
        assertFalse(sm.containsSubstring("HelloWorld", "earth"));
        assertFalse(sm.containsSubstring(null, "test"));
        assertFalse(sm.containsSubstring("text", null));
    }
}
