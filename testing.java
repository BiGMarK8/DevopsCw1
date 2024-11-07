import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Testing {

    // Create a logger instance for the class
    Logger logger = Logger.getLogger(getClass().getName());

    // Test for converting the decimal 1 to hexadecimal (expected "1")
    @Test
    public void testConvertToHexOne() {
        if (logger.isLoggable(Level.INFO)) {
            logger.info("Running testConvertToHexOne");
        }
        assertEquals("Decimal 1 should convert to Hex '1'", "1", Dec2Hex.convertToHex(1));
        if (logger.isLoggable(Level.INFO)) {
            logger.info("Completed testConvertToHexOne");
        }
    }

    // Test for converting the decimal 10 to hexadecimal (expected "A")
    @Test
    public void testConvertToHexTen() {
        if (logger.isLoggable(Level.INFO)) {
            logger.info("Running testConvertToHexTen");
        }
        assertEquals("Decimal 10 should convert to Hex 'A'", "A", Dec2Hex.convertToHex(10));
        if (logger.isLoggable(Level.INFO)) {
            logger.info("Completed testConvertToHexTen");
        }
    }

    // Test for converting the decimal 15 to hexadecimal (expected "F")
    @Test
    public void testConvertToHexFifteen() {
        if (logger.isLoggable(Level.INFO)) {
            logger.info("Running testConvertToHexFifteen");
        }
        assertEquals("Decimal 15 should convert to Hex 'F'", "F", Dec2Hex.convertToHex(15));
        if (logger.isLoggable(Level.INFO)) {
            logger.info("Completed testConvertToHexFifteen");
        }
    }

    // Test for converting the decimal 16 to hexadecimal (expected "10")
    @Test
    public void testConvertToHexSixteen() {
        if (logger.isLoggable(Level.INFO)) {
            logger.info("Running testConvertToHexSixteen");
        }
        assertEquals("Decimal 16 should convert to Hex '10'", "10", Dec2Hex.convertToHex(16));
        if (logger.isLoggable(Level.INFO)) {
            logger.info("Completed testConvertToHexSixteen");
        }
    }

    // Test for converting the decimal 47 to hexadecimal (expected "2F")
    @Test
    public void testConvertToHexFortySeven() {
        if (logger.isLoggable(Level.INFO)) {
            logger.info("Running testConvertToHexFortySeven");
        }
        assertEquals("Decimal 47 should convert to Hex '2F'", "2F", Dec2Hex.convertToHex(47));
        if (logger.isLoggable(Level.INFO)) {
            logger.info("Completed testConvertToHexFortySeven");
        }
    }

    // Test for no input argument provided (should throw IllegalArgumentException)
    @Test
    public void testNoArgumentProvided() {
        try {
            String[] args = {};  // No arguments provided
            if (args.length == 0) {
                throw new IllegalArgumentException("No input argument provided.");
            }
            // If no exception is thrown, this test should fail
            assert false : "Expected IllegalArgumentException was not thrown";
        } catch (IllegalArgumentException e) {
            if (logger.isLoggable(Level.SEVERE)) {
                logger.severe(String.format("Error: %s", e.getMessage()));  // Log the error message
            }
            assertEquals("No input argument provided.", e.getMessage());
        }
    }

    // Test for non-integer argument (should not fail execution but handle gracefully)
    @Test
    public void testNonIntegerArgument() {
        String[] args = {"Hello"};  // Non-integer argument
        handleNonIntegerArgument(args);
    }

    // Test for valid integer argument
    @Test
    public void testValidIntegerArgument() {
        String[] args = {"42"};  // Valid integer argument
        handleNonIntegerArgument(args);
    }

    // Extracted method to handle non-integer and valid integer arguments
    private void handleNonIntegerArgument(String[] args) {
        if (args.length > 0) {
            try {
                Integer.parseInt(args[0]);  // Attempt to parse the argument
                if (logger.isLoggable(Level.INFO)) {
                    logger.info(String.format("Valid integer argument received: %s", args[0]));
                }
            } catch (NumberFormatException e) {
                // Handle non-integer argument gracefully by logging a message
                if (logger.isLoggable(Level.WARNING)) {
                    logger.warning(String.format("Non-integer argument received: %s", args[0]));
                }
            }
        }
    }
}
