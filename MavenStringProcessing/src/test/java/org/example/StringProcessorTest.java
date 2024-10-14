package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringProcessorTest {

    private final StringProcessor stringProcessor = new StringProcessor();

    @Test
    public void testIsStrongPassword() {
        assertTrue(stringProcessor.isStrongPassword("A1@b"), "Password 'A1@b' should be considered strong");
        assertFalse(stringProcessor.isStrongPassword("abc"), "Password 'abc' should be considered weak");
        assertFalse(stringProcessor.isStrongPassword("1234"), "Password '1234' should be considered weak");
        assertFalse(stringProcessor.isStrongPassword("ABC"), "Password 'ABC' should be considered weak");
        assertFalse(stringProcessor.isStrongPassword(null), "Null password should be considered weak");
        assertFalse(stringProcessor.isStrongPassword("aA1"), "Password 'aA1' should be considered weak (no symbol)");
    }

    @Test
    public void testCalculateDigits() {
        assertEquals(3, stringProcessor.calculateDigits("abc123"), "There should be 3 digits in 'abc123'");
        assertEquals(0, stringProcessor.calculateDigits("abcdef"), "There should be 0 digits in 'abcdef'");
        assertEquals(5, stringProcessor.calculateDigits("12345"), "There should be 5 digits in '12345'");
        assertEquals(0, stringProcessor.calculateDigits(""), "There should be 0 digits in an empty string");
    }

    @Test
    public void testCalculateWords() {
        assertEquals(3, stringProcessor.calculateWords("hello world test"), "There should be 3 words in 'hello world test'");
        assertEquals(1, stringProcessor.calculateWords("singleword"), "There should be 1 word in 'singleword'");
        assertEquals(0, stringProcessor.calculateWords("     "), "There should be 0 words in a string of spaces");
        assertEquals(2, stringProcessor.calculateWords("hi there"), "There should be 2 words in 'hi there'");
        assertEquals(0, stringProcessor.calculateWords(""), "There should be 0 words in an empty string");
    }

    @Test
    public void testCalculateExpression() {
        assertEquals(7.0, stringProcessor.calculateExpression("3 + 4"), 0.001, "3 + 4 should equal 7.0");
        assertEquals(14.0, stringProcessor.calculateExpression("2 * (3 + 4)"), 0.001, "2 * (3 + 4) should equal 14.0");
        assertEquals(2.0, stringProcessor.calculateExpression("8 / 4"), 0.001, "8 / 4 should equal 2.0");
        assertThrows(ArithmeticException.class, () -> stringProcessor.calculateExpression("10 / 0"), "Division by zero should throw an ArithmeticException");
        assertEquals(9.0, stringProcessor.calculateExpression("3 + 3 * 2"), 0.001, "3 + 3 * 2 should equal 9.0 (order of operations)");
    }
}