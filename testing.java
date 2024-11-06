import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Dec2HexTest {

    // This will be used for setting up before each test if needed
    public Dec2HexTest() {}

    // Before annotation is used to setup any necessary setup before each test
    @Before
    public void setUp() {
        // Any necessary setup for the tests can go here.
        // In this case, since Dec2Hex is a utility class with static methods, we don't need to initialize anything
    }

    // Test for converting the decimal 1 to hexadecimal (expected "1")
    @Test
    public void testConvertToHexOne() {
        assertEquals("Decimal 1 should convert to Hex '1'", "1", Dec2Hex.convertToHex(1));
    }

    // Test for converting the decimal 10 to hexadecimal (expected "A")
    @Test
    public void testConvertToHexTen() {
        assertEquals("Decimal 10 should convert to Hex 'A'", "A", Dec2Hex.convertToHex(10));
    }

    // Test for converting the decimal 15 to hexadecimal (expected "F")
    @Test
    public void testConvertToHexFifteen() {
        assertEquals("Decimal 15 should convert to Hex 'F'", "F", Dec2Hex.convertToHex(15));
    }

    // Test for converting the decimal 16 to hexadecimal (expected "10")
    @Test
    public void testConvertToHexSixteen() {
        assertEquals("Decimal 16 should convert to Hex '10'", "10", Dec2Hex.convertToHex(16));
    }

    // Test for converting the decimal 47 to hexadecimal (expected "2F")
    @Test
    public void testConvertToHexFortySeven() {
        assertEquals("Decimal 47 should convert to Hex '2F'", "2F", Dec2Hex.convertToHex(47));
    }

    // Test for converting the decimal 255 to hexadecimal (expected "FF")
    @Test
    public void testConvertToHexTwoFiftyFive() {
        assertEquals("Decimal 255 should convert to Hex 'FF'", "FF", Dec2Hex.convertToHex(255));
    }

    // Test for converting the decimal 0 to hexadecimal (expected "0")
    @Test
    public void testConvertToHexZero() {
        assertEquals("Decimal 0 should convert to Hex '0'", "0", Dec2Hex.convertToHex(0));
    }

    // Test for converting the decimal 256 to hexadecimal (expected "100")
    @Test
    public void testConvertToHexTwoHundredFiftySix() {
        assertEquals("Decimal 256 should convert to Hex '100'", "100", Dec2Hex.convertToHex(256));
    }

    // Test for converting the maximum 32-bit signed integer (2147483647) to hexadecimal
    @Test
    public void testConvertToHexMaxInt() {
        assertEquals("Decimal 2147483647 should convert to Hex '7FFFFFFF'", "7FFFFFFF", Dec2Hex.convertToHex(2147483647));
    }
}
