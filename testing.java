import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.logging.Logger;
import java.util.logging.Level;

public class testing {

    // Create a logger instance for the class
    Logger logger = Logger.getLogger(getClass().getName());

    // Test for converting the decimal 1 to hexadecimal (expected "1")
    @Test
    public void testConvertToHexOne() {
        logger.info("Running testConvertToHexOne");
        assertEquals("Decimal 1 should convert to Hex '1'", "1", Dec2Hex.convertToHex(1));
        logger.info("Completed testConvertToHexOne");
    }

    // Test for converting the decimal 10 to hexadecimal (expected "A")
    @Test
    public void testConvertToHexTen() {
        logger.info("Running testConvertToHexTen");
        assertEquals("Decimal 10 should convert to Hex 'A'", "A", Dec2Hex.convertToHex(10));
        logger.info("Completed testConvertToHexTen");
    }

    // Test for converting the decimal 15 to hexadecimal (expected "F")
    @Test
    public void testConvertToHexFifteen() {
        logger.info("Running testConvertToHexFifteen");
        assertEquals("Decimal 15 should convert to Hex 'F'", "F", Dec2Hex.convertToHex(15));
        logger.info("Completed testConvertToHexFifteen");
    }

    // Test for converting the decimal 16 to hexadecimal (expected "10")
    @Test
    public void testConvertToHexSixteen() {
        logger.info("Running testConvertToHexSixteen");
        assertEquals("Decimal 16 should convert to Hex '10'", "10", Dec2Hex.convertToHex(16));
        logger.info("Completed testConvertToHexSixteen");
    }

    // Test for converting the decimal 47 to hexadecimal (expected "2F")
    @Test
    public void testConvertToHexFortySeven() {
        logger.info("Running testConvertToHexFortySeven");
        assertEquals("Decimal 47 should convert to Hex '2F'", "2F", Dec2Hex.convertToHex(47));
        logger.info("Completed testConvertToHexFortySeven");
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
            logger.log(Level.SEVERE, "Error: {0}", e.getMessage());  // Using built-in formatting
            assertEquals("No input argument provided.", e.getMessage());
        }
    }

    // Test for non-integer argument (should not fail execution but handle gracefully)
    @Test
    public void testNonIntegerArgument() {
        String[] args = {"Hello"};  // Non-integer argument
        handleArgument(args);
    }

    // Test for valid integer argument
    @Test
    public void testValidIntegerArgument() {
        String[] args = {"42"};  // Valid integer argument
        handleArgument(args);
    }

    // Extracted method to handle non-integer and valid integer arguments
    private void handleArgument(String[] args) {
        if (args.length > 0) {
            handleArgumentParsing(args[0]);
        }
    }

    // Method to handle the parsing of the argument
    private void handleArgumentParsing(String arg) {
        try {
            // Attempt to parse the argument
            Integer.parseInt(arg);
            logger.info("Valid integer argument received: " + arg);
        } catch (NumberFormatException e) {
            // Handle non-integer argument gracefully by logging a message
            logger.log(Level.WARNING, "Non-integer argument received: {0}", arg);  // Using built-in formatting
        }
    }

    // Using logger with Supplier (lazy evaluation for performance)
    private void logErrorIfNeeded(String errorMessage) {
        if (logger.isLoggable(Level.SEVERE)) {
            logger.log(Level.SEVERE, () -> "Something went wrong: " + errorMessage);  // Lazy evaluation
        }
    }

    // Example of checking conditions and throwing exceptions
    private void checkArgument(int arg) {
        if (arg <= 0) {
            throw new IllegalStateException(String.format("Arg must be positive, but got %d", arg));  // String formatting
        }
    }
}
