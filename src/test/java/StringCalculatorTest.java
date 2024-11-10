import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    @Test
    void testAddEmptyString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    void testAddSingleNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.addSingleNumber("1"));
    }

    @Test
    void testAddTwoNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.addTwoNumbers("1,2"));
    }

    @Test
    void testAddMultipleNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.addMultipleNumbers("1,2,3"));
    }

    @Test
    void testAddWithNewLineDelimiter() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.addWithNewLineDelimiter("1\n2,3"));
    }

    @Test
    void testAddWithCustomDelimiter() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.addWithCustomDelimiter("//;\n1;2"));
    }

    @Test
    void testAddWithNegativeNumbers() {
        StringCalculator calculator = new StringCalculator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.addWithNegativeNumbers("1,-2,3,-4");
        });
        assertEquals("negatives not allowed: -2, -4", exception.getMessage());
    }

}
