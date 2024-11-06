import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testing {

    @Test
    public void testConvertToHex() {
        // Test positive integers
        assertEquals("1", Dec2Hex.convertToHex(1));
        assertEquals("A", Dec2Hex.convertToHex(10));
        assertEquals("F", Dec2Hex.convertToHex(15));
        assertEquals("10", Dec2Hex.convertToHex(16));
        assertEquals("2F", Dec2Hex.convertToHex(47));
        assertEquals("FF", Dec2Hex.convertToHex(255));

        // Test zero
        assertEquals("0", Dec2Hex.convertToHex(0));

        // Test larger numbers
        assertEquals("100", Dec2Hex.convertToHex(256));
        assertEquals("7FFFFFFF", Dec2Hex.convertToHex(2147483647)); // Maximum positive integer (32-bit signed)
    }
}
