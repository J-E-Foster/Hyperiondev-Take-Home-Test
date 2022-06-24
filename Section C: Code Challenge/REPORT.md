<h1>Space Complexity of the "number-to-words" algorithm</h1> 

## Space Complexity and Big-O Notation

Just like time complexity is a measure of how long an algorithm takes to run relative to its input size, so space complexity is a measure of the **the total amount of memory that an algorithm occupies relative to its input size** (Baeldung, 2022).  In terms of worst-case time complexity, we can express this using big-O notation (CSDojo, 2018 & Hyperiondev, 2021), which will give us an idea of the upper-bound of an algorithm's memory growth rate (i.e. it could grow more slowly, but not more than the upper-bound) (Baeldung 2022).

This is often confused with auxiliary space, which is the extra or temporary spaced an algorithm uses. But because time complexity is defined as the total growth relative to the input size, **we need to consider auxiliary space and the memory occupied by the input, as the input gets larger** (CSDojo, 2018 & Geeksforgeeks, 2021).

Thus to get an idea of the overall worst-case time complexity, we can consider the big-O space of required by all the variables present in the algorithm (this includes the input) (Baeldung, 2022 & CSDojo 2018).

## Method

We have two main types of variables we need to check in this algorithm, namely constants and arrays:

Constants occupy a fixed amount of space, which differs depending on the data types, but in terms of big-O, they occupy O(1)/constant space - i.e. they remain a constant - c - relative to the input size (CSDojo, 2018).

Arrays, which are a collection of constants, typically have a space complexity of O(n), where n is the size of the array. Thus as n grows, the array's space complexity grows with it in a linear fashion. But if n itself is a constant - c - (i.e. when an array always has a fixed size), then we again have a space complexity of O(1) (CSDojo, 2018).

## Application

### Let's consider the big-O's of our algorithm variables:

```
public class SayTheNumber {

    static final String[] upToNineteen = new String[] {                                  -> These three arrays always
            "Zero.", "one", "two", "three", "four", "five",                                 occupy  the same amount of
            "six", "seven", "eight", "nine", "ten",                                         space, regardless of input size. 
            "eleven", "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen"                                  Thus:  O(1) + O(1) + O(1) 
    };                                                                                           =  c1  +  c2  +  c3
    static final String[] twentyToNinety = new String[] {                                        =  c4
            "", "", "twenty", "thirty", "forty", "fifty",                                        = O(1)
            "sixty", "seventy", "eighty", "ninety"
    };
    static final String[] scaleNumbers = new String[] {
            "", "thousand", "million", "billion", "trillion"
    };

    public static String sayNumber(long number) {                                        -> 'number' is the input, which is 
        if (number == 0) {                                                                  is always a constant c. Thus: O(1)
            return upToNineteen[0];	
        }
        long[] threeDigitGroups = new long[5];                                           -> constant size array. Thus: O(1)
        long positiveNumber = Math.abs(number);	                                         -> long = c. Thus: O(1)

        for (int i = 0; i < 5; i++) {                                                    -> int = c. Thus: O(1)
            threeDigitGroups[i] = positiveNumber % 1000;
            positiveNumber /= 1000;
        }
        String[] threeDigitGroupsText = new String[5];                                   -> constant size array. Thus: O(1)

        for (int i = 0; i < 5; i++) {                                                    -> int = c. Thus: O(1)
            threeDigitGroupsText[i] = threeDigitGroupToString(threeDigitGroups[i]);
        }
        String combinedGroups = threeDigitGroupsText[0];                                 -> String = c. Thus: O(1)
        String groupSubString = "";                                                      -> String = c. Thus: O(1)
        boolean addAnd;                                                                  -> boolean = c. Thus: O(1)
        addAnd = (threeDigitGroups[0] > 0) && (threeDigitGroups[0] < 100);

        for (int i = 1; i < 5; i++) {                                                    ->  int = c. Thus: O(1)
            if (threeDigitGroups[i] != 0) {
                String groupSubString = threeDigitGroupsText[i] 
                                      + " " + scaleNumbers[i];

                if (combinedGroups.length() != 0) {
                    groupSubString += addAnd ? " and " : ", ";
                }
                addAnd = false;
                combinedGroups = groupSubString + combinedGroups;
            }
        }
        if (number < 0) {
            combinedGroups = "Minus " + combinedGroups;
       }
        combinedGroups = combinedGroups.substring(0, 1).toUpperCase()                    -> One String for each
                       + combinedGroups.substring(1) + ".";                                 substring() method plus the ".".

        return combinedGroups;                                                              Thus: O(1) + O(1) + O(1)
    };                                                                                            = c1 +  c2  + c3  =  c4 
                                                                                                  = O(1)
    private static String threeDigitGroupToString(long threeDigitGroup) {                -> long already accounted for in array
        String groupString = "";                                                         -> String = c. Thus: O(1)
        int hundreds = (int)threeDigitGroup / 100;                                       -> int = c. Thus: O(1)
        int tensUnits = (int)threeDigitGroup % 100;                                      -> int = c. Thus: O(1)

        if (hundreds != 0) {
            groupString += upToNineteen[hundreds] + " hundred";

            if (tensUnits != 0) {
                groupString += " and ";
            }
        }
        int tens = tensUnits / 10;                                                       -> int = c. Thus: O(1)
        int units = tensUnits % 10;                                                      -> int = c. Thus: O(1)

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
```

## Result

If we now add up all the big-O's for the variables, we get: 17 x O(1), i.e. 17 constants, **which add up to another constant**.

And the big-O complexity of a constant value is always O(1), whether we are evaluating time or space complexity,  thus giving us, in this case, **a final worst case space complexity of O(1)** (CSDojo, 2018).

This makes sense as even if the input number grows, it remains a constant, and there are no arrays that actually
grow in size relative to the input, hence we have a constant space complexity, no matter the size of the user's input number.<br /><br /><br /><br />


## References

[1] Baeldung.com (2021). Understanding Space Complexity. [online] Available at: https://www.baeldung.com/cs/space-complexity [Accessed 23 Jun 2022].<br />
[2] CS Dojo (2018). Introduction to Big O Notation and Time Complexity (Data Structures & Algorithms #7). [video] Youtube.com. Available at: https://www.youtube.com/watch?v=D6xkbGLQesk&ab_channel=CSDojo [Accessed 23 Jun 2022].<br />
[3] Geeksforgeeks.com (2021). What does ‘Space Complexity’ mean? [online] Available at: https://www.geeksforgeeks.org/g-fact-86/#:~:text=Auxiliary%20Space%20is%20the%20extra,and%20space%20used%20by%20input. [Accessed 23 Jun 2022].<br />
[4] Hyperiondev (2021). Introduction to Computer Science Fundamentals and Big O Notation. p.6-14.
