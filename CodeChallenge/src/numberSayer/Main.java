package numberSayer;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// Gets user input.
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter any whole number smaller than 1,000,000,000,000,000 "
				           + "(no comma or space separators):");
		String userNumber;
		/* Stores user's number as a long, otherwise we can't use it in sayNumber(). */
		long number;
		
		// Validates user input.
		while (true) {
			userNumber = input.nextLine();
			
			if (userNumber.matches("-?[0-9]+") == false) {
				System.out.println("\nYour number contains non-numerical characters or spaces.\n"
								   + "Please remove all non-numerical characters or spaces, "
								   + "and re-enter your number:");
				continue;
			}
			// We need to convert to long case the number exceeds integer max value.
			number = Long.parseLong(userNumber);
			
			if (number > 999999999999999L) {
				System.out.println("\nYour number is larger than 999,999,999,999,999.\n"
								   + "Please enter a smaller number:");
				continue;
			}
			break;
		}
		input.close();
		
		System.out.println("\nYour number in words is:\n");		
		System.out.println(NumberSayer.sayNumber(number));	
	};	
	
}


////////////////////////////////// THE END /////////////////////////////////////