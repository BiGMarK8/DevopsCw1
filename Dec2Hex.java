import java.util.logging.Level;
import java.util.logging.Logger;

public class Dec2Hex {
    private static final Logger logger = Logger.getLogger(Dec2Hex.class.getName());

    // Main method for command-line execution (keeping the existing structure)
    public static void main(String[] args) {
        // Check if a command-line argument is provided
        if (args.length == 0) {
            logger.log(Level.SEVERE, "Error: No input provided. Please enter an integer as a command-line argument.");
            return;
        }

        // Store number
        int num;

        // Check if the input is an integer
        try {
            num = Integer.parseInt(args[0]);
        }
        // Catch the error if the input is not a valid integer
        catch (NumberFormatException e) {
            logger.log(Level.SEVERE, "Error: Input is not a valid integer. Please enter a valid integer as input.", e);
            return;
        }

        // Call the convertToHex method to convert the number
        String hexValue = convertToHex(num);
        
        // Log the result
        if (hexValue != null) {
            logger.log(Level.INFO, "Hexadecimal is: {0}", hexValue);
        }
    }

    // Method to convert decimal to hexadecimal
    public static String convertToHex(int num) {
        // Handle the case where input is zero
        if (num == 0) {
            return "0";
        }

        // Declare values for hexadecimal characters (0-9 and A-F)
        char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

        // Use StringBuilder to build the hexadecimal string
        StringBuilder hexadecimal = new StringBuilder();

        // Convert decimal to hexadecimal
        while (num != 0) {
            int rem = num % 16;
            hexadecimal.insert(0, hexChars[rem]); // Insert at the beginning
            num = num / 16;
        }

        return hexadecimal.toString();
    }
}
