package numberSayer;

/* This class defines an algorithm for converting any positive or negative integer - 
 * up to +-999.999.999.999,999 (999 trillion) - into English words, complete with punctuation.
 * The algorithm was adapted from Carr (2007), as referenced by Robhudson (2021).
 * 
 * The solution follows a distinct set of six rules:
 * 
 * 1.) Zero rule: if the user input is "0", the output should be "Zero."
 * 
 * 2.) Three digit rule: the user input is split into groups of three digits,
 *     starting from the right. Each set of three digits is processed individually
 *     as a text number of hundreds, tens, and units. 
 *     Once they are converted to text, the groups are then recombined by adding 
 *     the relevant scale number.
 *     
 * To convert the three-digit group into text (i.e. to apply the three-digit rule),
 * three rules are needed:
 * 
 *     3.) Hundreds rule: If the hundreds part of the three-digit group is not zero,
 *         that hundreds part is added as a word: If that three digit group is divisible
 *         by hundred, "hundred" is added. Else, "hundred and" is added.
 *     
 *     4.) Tens rule: If the tens part of the three-digit group is two or higher (20 and up),
 *         the corresponding "-ty" number text is added, followed by the number text of the 
 *         third digit (i.e. the number under ten). If the third digit is zero, it is skipped.
 *         If the tense and the units are both zero, nothing is added. For any other value 
 *         (i.e. smaller than 20 but not "00", the corresponding two digit number text is added.
 *     
 *     5.) Recombination rules: when recombining the the three-digit text numbers, each group
 *         except the last is followed by a scale number and a comma (unless the group is all-zero's,
 *         in which case it's not included as text). An exception is when the final group has no 
 *         hundreds part and there is more than one non-blank three-digit group. In this case, 
 *         the final comma is replaced with "and".
 *         
 *6.) Negative rule: Negative numbers always have the prefix "Minus".         
 */ 
public class NumberSayer {
	/* The following three arrays store all the string (word) values 
	 * needed to write out all numbers up to 999 trillion
	 * (NOTE: modern short-scale numbering is used, so "1000,000,000" 
	 * = "one billion", and "1000,000,000,000" = "one trillion", etc.).
	 */
	static final String[] upToNineteen = new String[] { 
			"Zero.", "one", "two", "three", "four", "five", 
			"six", "seven", "eight", "nine", "ten", 
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", 
			"sixteen", "seventeen", "eighteen", "nineteen"
	};
	/* Empty strings included to facilitate easy indexing while 
	 * changing the three-digit groups to words and while adding
	 * scale number when three-digit word groups are recombined. */
	static final String[] twentyToNinety = new String[] { 
			"", "", "twenty", "thirty", "forty", "fifty", 
			"sixty", "seventy", "eighty", "ninety"
	};
	static final String[] scaleNumbers = new String[] {
			"", "thousand", "million", "billion", "trillion"
	};
		
	public static String sayNumber(long number) {
		// ZERO RULE: if the number is "0" the return value will always be "Zero".
		if (number == 0) {
			return upToNineteen[0];
		}
		/* THREE-DIGIT RULE:
		 * 
		 * If the number is not zero, we need to divide it into three-digit groups.
		 *
		 * Because our upper limit is one trillion, there will never be more than five three-digit groups.
		 * When an integer is divided by 1000, the remainder will be the last three-digit group.
		 * For negative numbers, however, we need to use the absolute value of the remainder,
		 * as it would be negative. 
		 * 
		 * The three-digit group array indeces can be matched against the 'scaleNumbers' array indeces,
		 * which will be important later. 
		 */
		// Stores the five possible three-digit groups.
		long[] threeDigitGroups = new long[5];
		// Ensures a positive number for the remainder.
		long positiveNumber = Math.abs(number);
		
		// Extracts the three-digit groups.
		for (int i = 0; i < 5; i++) {
			threeDigitGroups[i] = positiveNumber % 1000;
			positiveNumber /= 1000;
		}	
	   /* Now each group is converted to text/string.
	    * A helper method 'threeDigitGroupToString()' is created below.
	    * 
	    * The subroutine below is called once for each of the three-digit groups using another for loop. 
	    * For each pass, the returned text is stored in a new array of strings. 
	    * The index numbers of the three-digit group values and their new text versions are kept in-sync.
	    */
		// Stores each three digit group as words - the index numbers of the text array and the three-digit array match.
		String[] threeDigitGroupsText = new String[5];
		 
		for (int i = 0; i < 5; i++) {
			threeDigitGroupsText[i] = threeDigitGroupToString(threeDigitGroups[i]);
		}
		/* Now that we have the individual three digit groups, we must recombine them.
		 * 
		 * We start with the lower value groups and add each larger group to the 
		 * final return string. When a group is NOT blank, the matching scale number text
		 * from the 'scaleNumbers' array is added. If a non-blank group has already
		 * been added, a comma or "and" is also added. 
		 */
		// Recombines the three-digit groups.
		String combinedGroups = threeDigitGroupsText[0];
		/* Stores larger values (i.e. the group text plus scale number)
		 * for each group/iteration below. */
		String groupSubString = "";
		boolean addAnd;
		/* Checks if an "and" is needed (if the first three digit group is larger 
		 * than zero and smaller than 100, we need an "and" for the last number-word). */
		addAnd = (threeDigitGroups[0] > 0) && (threeDigitGroups[0] < 100);
		 
		// Processes the remaining groups in turn, smallest to largest.
		for (int i = 1; i < 5; i++) {
		    // Checks for only non-blank groups.
		    if (threeDigitGroups[i] != 0) {
		        // Builds the larger values by adding the matching scale number.
		        groupSubString = threeDigitGroupsText[i] + " " + scaleNumbers[i];
		        /* If the combined string is now non-blank, the boolean is checked.
		         * If it's still true (i.e. it's the first iteration/smallest group), "and" is appended, 
		         * but if it switched to false, a comma is added. */
		        if (combinedGroups.length() != 0) {
		        	groupSubString += addAnd ? " and " : ", ";
		        }
		        // Opportunity to add 'and' is ended (we only need one "and" at the end, if any).
		        addAnd = false;
		        // Adds the three-digit group to the combined string.
		        combinedGroups = groupSubString + combinedGroups;
		    }
		}
		// NEGATIVE RULE: 
		if (number < 0) {
			combinedGroups = "Minus " + combinedGroups;
		}
		 // Changes first letter to uppercase and adds full stop.
		combinedGroups = combinedGroups.substring(0, 1).toUpperCase() 
					   + combinedGroups.substring(1) + ".";
		
		return combinedGroups;
	};
		
	/* Accepts an integer value of no more than three digits and returns the equivalent English text. 
	 * This method implements the hundreds and tens rule. */
	private static String threeDigitGroupToString(long threeDigitGroup) {
		/* To apply hundreds rule, we need two key values:
		 *
		 * 1.) Amount of hundreds = divide the three-digit integer by 100.
		 * 2.) The remaining two numbers = the remainder of dividing by 100.
		 * 
		 * We also need two conditionals are needed:
		 * 
		 * 1.) Checks if the amount of hundreds is included in the return string
		 *      (i.e. if the value is non-zero). If so, it's converted to string.
		 * 2.) Checks if there are any tens or units in the three-digit Group.
		 *      if so, these will be added later by the "tens" rule. We add the word
		 *      "and", as this will be required (if there are no tens or units,
		 *      the hundreds number is exact, and no "and" is needed. 
		 */
		// Initializes the return text.
		String groupString = "";
		// Determines the hundreds and the remainder.
		int hundreds = (int)threeDigitGroup / 100;
		int tensUnits = (int)threeDigitGroup % 100;
		// HUNDREDS RULE:
		if (hundreds != 0) {
			groupString += upToNineteen[hundreds] + " hundred";
		 
		    if (tensUnits != 0) {
		    	groupString += " and ";
		    }
		} 
		/* Now, to apply the tens rule, we must find the number of tens and units.
		 * 
		 * This is done similarly to determining hundreds:
		 * 
		 * 1.) The remainder from the hundreds rule is again split using / and %.
		 * 2.) Once number of tens and unis are known we use the if statements to get the 
		 *     correct text.
		 */
		// Determines the tens and units.
		int tens = tensUnits / 10;
		int units = tensUnits % 10;
		/* TENS RULE:
		 * 
		 * If the tens are more than or equal to 20, we fetch the corresponding
		 * word from the 20-90 array, and if the remaining units are NOT zero,
		 * we also add the corresponding units from the 1-19 array.
		 * 
		 * Else (if the tens are less than twenty and the tensUnits are not zero,
		 * we add the corresponding units from the 1-19 array (we don't use 'tens'
		 * or 'units' as 'tensUnits' would already be in the 1-19 array.
		 * Again, we simply use the corresponding indeces.
		 */
		if (tens >= 2) {
			groupString += twentyToNinety[tens];
			
		    if (units != 0) {
		    	groupString += "-" + upToNineteen[units];
		    }
		} else if (tensUnits != 0) {
			groupString += upToNineteen[tensUnits];
		}
		return groupString;
	};
		
}


/////////////////////////////////// THE END ////////////////////////////////////


/* References:
 * 
 * Carr, R. (2007). Convert A Number into Words. [online] Blackwasp.co.uk. Available at: http://www.blackwasp.co.uk/NumberToWords.aspx [Accessed 22 Jun 2022]. 
 * DuduAlul (2021). Algorithm that converts numeric amount into English words. [online] Stackoverflow.com. Available at: https://stackoverflow.com/questions/3299619/algorithm-that-converts-numeric-amount-into-english-words [Accessed 22 Jun 2022].
 * Robhudson (2021). Algorithm that converts numeric amount into English words. [online] Stackoverflow.com. Available at: https://stackoverflow.com/questions/3299619/algorithm-that-converts-numeric-amount-into-english-words [Accessed 22 Jun 2022].
 * 
 */
	
////////////////////////////////////////////////////////////////////////////////
