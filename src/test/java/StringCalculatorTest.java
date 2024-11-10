import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
