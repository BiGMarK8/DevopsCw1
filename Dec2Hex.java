import java.util.Scanner;

public class Dec2Hex {
    public static void main(String[] args) {
        // create scanner
        Scanner scanner = new Scanner(System.in);
        // ask user to input interger
        System.out.print("Please enter an integer to convert to hexadecimal: ");
        // store num
        int num;

        // Check input is an integer
        while (true) {
            try {
                num = Integer.parseInt(scanner.nextLine());
                // Exit the loop if parsing is successful
                break;
            }
            // if input is not integer
            catch (NumberFormatException e) {
                // display error message
                System.err.print("Invalid input. Please enter a valid integer: ");
            }
        }
        // close scanner
        scanner.close();

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
