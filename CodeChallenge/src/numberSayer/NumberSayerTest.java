package numberSayer;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/* This class is a test class for the sayNumber() method of the NumberSayer class.
 * Using random numbers in the given range would be ideal, but this would require
 * implementing yet another algorithm, which would itself need to be tested. 
 * 
 * Thus manual test cases were used.
 */
class NumberSayerTest {

	@Test
	public void testNumberSayer() {
		assertTrue(numberSayer.NumberSayer.sayNumber(999999999999999L).equals(
				   "Nine hundred and ninety-nine trillion, nine hundred and ninety-nine billion, "
				 + "nine hundred and ninety-nine million, nine hundred and ninety-nine thousand, "
			     + "nine hundred and ninety-nine."
		));
		assertTrue(numberSayer.NumberSayer.sayNumber(90376000010012L).equals(
				"Ninety trillion, three hundred and seventy-six billion, ten thousand and twelve."
		));
		assertTrue(numberSayer.NumberSayer.sayNumber(12000013L).equals(
				"Twelve million and thirteen."
		));
		assertTrue(numberSayer.NumberSayer.sayNumber(1033286L).equals(
				"One million, thirty-three thousand, two hundred and eighty-six."
		));
		assertTrue(numberSayer.NumberSayer.sayNumber(20000L).equals("Twenty thousand."));
		assertTrue(numberSayer.NumberSayer.sayNumber(1001L).equals("One thousand and one."));	
		assertTrue(numberSayer.NumberSayer.sayNumber(165L).equals("One hundred and sixty-five."));
		assertTrue(numberSayer.NumberSayer.sayNumber(50L).equals("Fifty."));
		assertTrue(numberSayer.NumberSayer.sayNumber(43L).equals("Forty-three."));
		assertTrue(numberSayer.NumberSayer.sayNumber(15L).equals("Fifteen."));
		assertTrue(numberSayer.NumberSayer.sayNumber(14L).equals("Fourteen."));
		assertTrue(numberSayer.NumberSayer.sayNumber(11L).equals("Eleven."));
		assertTrue(numberSayer.NumberSayer.sayNumber(0L).equals("Zero."));
		assertTrue(numberSayer.NumberSayer.sayNumber(-11L).equals("Minus eleven."));
		assertTrue(numberSayer.NumberSayer.sayNumber(-14L).equals("Minus fourteen."));
		assertTrue(numberSayer.NumberSayer.sayNumber(-15L).equals("Minus fifteen."));
		assertTrue(numberSayer.NumberSayer.sayNumber(-43L).equals( "Minus forty-three."));
		assertTrue(numberSayer.NumberSayer.sayNumber(-50L).equals("Minus fifty."));
		assertTrue(numberSayer.NumberSayer.sayNumber(-165L).equals("Minus one hundred and sixty-five."));
		assertTrue(numberSayer.NumberSayer.sayNumber(-1001L).equals("Minus one thousand and one."));
		assertTrue(numberSayer.NumberSayer.sayNumber(-20000L).equals("Minus twenty thousand."));
		assertTrue(numberSayer.NumberSayer.sayNumber(-1033286L).equals(
				   "Minus one million, thirty-three thousand, two hundred and eighty-six."
		));
		assertTrue(numberSayer.NumberSayer.sayNumber(-12000013L).equals("Minus twelve million and thirteen."));
		assertTrue(numberSayer.NumberSayer.sayNumber(-90376000010012L).equals(
				   "Minus ninety trillion, three hundred and seventy-six billion, ten thousand and twelve."
		));
		assertTrue(numberSayer.NumberSayer.sayNumber(-999999999999999L).equals(
				   "Minus nine hundred and ninety-nine trillion, nine hundred and ninety-nine billion, "
				 + "nine hundred and ninety-nine million, nine hundred and ninety-nine thousand, "
				 + "nine hundred and ninety-nine."
		));		
	};
	
}


//////////////////////////////// THE END ///////////////////////////////////
