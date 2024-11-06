import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class testing {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        // Redirect System.out to capture the output
        System.setOut(new PrintStream(outContent));

        // Set up a logger with ConsoleHandler for the tests
        Logger logger = Logger.getLogger(Dec2Hex.class.getName());
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
    }

    @Test
    public void testNoInput() {
        // Simulate no command-line arguments
        String[] args = {};
        Dec2Hex.main(args);

        // Check if the correct error was logged
        assertTrue(outContent.toString().contains("Error: No input provided"));
    }

    @Test
    public void testInvalidInput() {
        // Simulate invalid input (non-integer input)
        String[] args = {"abc"};
        Dec2Hex.main(args);

        // Check if the correct error was logged
        assertTrue(outContent.toString().contains("Error: Input is not a valid integer"));
    }

    @Test
    public void testZeroInput() {
        // Simulate zero input
        String[] args = {"0"};
        Dec2Hex.main(args);

        // Check if the correct info was logged for zero input
        assertTrue(outContent.toString().contains("Hexadecimal representation is: 0"));
    }

    @Test
    public void testValidInput() {
        // Simulate valid input (decimal to hexadecimal conversion)
        String[] args = {"255"};
        Dec2Hex.main(args);

        // Check if the correct hexadecimal value was logged
        assertTrue(outContent.toString().contains("Hexadecimal representation is: FF"));
    }

    @Test
    public void testLoggingWhenInfoLevelEnabled() {
        // Redirect System.out to capture the output (for logging)
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Simulate valid input (decimal to hexadecimal conversion)
        String[] args = {"255"};
        Dec2Hex.main(args);

        // Check if the correct message is logged
        assertTrue(outContent.toString().contains("Converting the Decimal Value 255 to Hex..."));
    }
}
