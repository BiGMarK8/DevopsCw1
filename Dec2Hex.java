import java.util.logging.Logger;

public class Dec2Hex {
    // Create a logger
    private static final Logger logger = Logger.getLogger(Dec2Hex.class.getName());

    public static void main(String[] args) {
        // Check if a command-line argument is provided
        if (args.length == 0) {
            // Log an error message using the logger
            logger.severe("Error: No input provided. Please enter an integer as a command-line argument.");
            return;
        }

        // Store number
        int num;

        // Check if the input is an integer
        try {
            // Parse the input argument to an integer
            num = Integer.parseInt(args[0]);
        }
        // Catch the error if the input is not a valid integer
        catch (NumberFormatException e) {
            // Log an error message using the logger
            logger.severe("Error: Input is not a valid integer. Please enter a valid integer as input.");
            return;
        }

        // Handle the case where input is zero
        if (num == 0) {
            logger.info("Hexadecimal representation is: 0");
            return;
        }

        // Declare values for hexadecimal characters (0-9 and A-F)
        char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        
        // Use StringBuilder to build the hexadecimal string
        StringBuilder hexadecimal = new StringBuilder();

        // Log the decimal number that is being converted
        logger.info("Converting the Decimal Value " + num + " to Hex...");

        // Convert decimal to hexadecimal
        // Loop until num becomes 0
        while (num != 0) {
            // Calculate remainder when num is divided by 16
            int rem = num % 16;
            // Append the corresponding hexadecimal character to the result
            hexadecimal.insert(0, hexChars[rem]); // Insert at the beginning
            // Update num to be the quotient of num divided by 16
            num = num / 16;
        }

        // Log the hexadecimal value
        logger.info("Hexadecimal representation is: " + hexadecimal.toString());
    }
}
