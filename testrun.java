import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.logging.Logger;

public class testrun {

    // Initialize logger
    private static final Logger logger = Logger.getLogger(testrun.class.getName());

    public static void main(String[] args) {
        // Run the tests in the 'testing' class
        Result result = JUnitCore.runClasses(testing.class);

        int fails = 0;
        try {
            // Iterate through the failures (if any) and log them
            for (Failure failure : result.getFailures()) {
                logger.severe(failure.toString());
                fails++;
            }

            // If there are any failed tests, throw the custom exception
            if (fails > 0) {
                throw new InvalidValueException(fails + " tests failed.");
            }

            // Log success message if all tests pass
            logger.info("All tests passed: " + result.wasSuccessful());
        } catch (InvalidValueException e) {
            // Handle the custom exception for failed tests
            logger.severe("Test Run Failed: " + e.getMessage());
            System.exit(1); // Exit with error status
        } catch (Exception e) {
            // Catch any other unexpected exceptions
            logger.severe("Unexpected error occurred: " + e.getMessage());
            System.exit(1); // Exit with error status
        }

        // Exit with status code 0 if all tests passed
        System.exit(0);
    }
}
