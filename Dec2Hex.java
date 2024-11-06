import java.util.Scanner;

public class Dec2Hex {
    public static void main(String[] args) {
        // Check if a command-line argument is provided
        if (args.length == 0) {
            // erros message no input provided
            System.err.println("Error: No input provided. Please enter an integer as a command-line argument.");
            return;
        }
        // store number
        int num;

        // check input is integer
        try {
            // check integer
            num = Integer.parseInt(args[0]);

        }
        // catch the error if not valid integer
        catch (NumberFormatException e) {
            // show error message
            System.err.println("Error: Input is not a valid integer. Please enter a valid integer as input.");
            return;
        }

        // Handle the case where input is zero
        if (num == 0) {
            System.out.println("Hexadecimal representation is: 0");
            return;
        }

        // if input is 0
        if (num == 0) {
            // print message
            System.out.println("Hexadecimal representation is: 0");
            return;
        }

        // declare values
        char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        String hexadecimal = "";
        // print what number the program is converting
        System.out.println("Converting the Decimal Value " + num + " to Hex...");

        // Convert decimal to hexadecimal
        // when number is not equal to 0
        while (num != 0) {
            // calculate remainder when num is divided by 16
            int rem = num % 16;
            // hexadecimal equals matching rem to hexchars character
            hexadecimal = hexChars[rem] + hexadecimal;
            // update num
            num = num / 16;
        }
        // print the hexadecimal value
        System.out.println("Hexadecimal representation is: " + hexadecimal);
    }
}
