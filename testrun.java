import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.lang.Exception;

public class testrun {
   public static void main(String[] args) {
      // Run the tests in Dec2HexTest class
      Result result = JUnitCore.runClasses(testing.class);

      int fails = 0;
      try {
          // Iterate through the failures (if any) and print them
          for (Failure failure : result.getFailures()) {
             System.out.println(failure.toString());
             fails++;
          }
          
          // If there are any failed tests, throw an exception
          if (fails > 0) {
            throw new Exception();
          }

          // Print if all tests were successful
          System.out.println("All tests passed: " + result.wasSuccessful());
      }
      catch (Exception e) {
          // Print the number of failed tests
          System.out.println(fails + " tests failed.");
          System.exit(1);
      }

      // Exit with status code 0 if all tests passed
      System.exit(0);
   }
}
