package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

class AlgoritmTests {
	int[] arrayInt = { 3, 5, 7, 1, 9, 2, 4, 6, 0, 8 };
	int[] sortedArray = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	Array array = new Array();

	/**
	 * 
	 * 
	 * Search algorithm tests ====>
	 * 
	 * 
	 */

	@Test
	void testBinarySearch() {
		int low = 0;
		int high = arrayInt.length;

		assertEquals(5, Array.binarySearch(sortedArray, 5, low, high));
	}

	@Test
	void testJumpSearch() {
		assertEquals(5, Array.jumpSearch(sortedArray, 5));
	}

	@Test
	void testInterpolationSearch() {
		assertEquals(5, Array.interpolationSearch(sortedArray, 5));
	}

	/**
	 * 
	 * 
	 * Sort algorithm tests ====>
	 * 
	 * 
	 */

	//
	//
	//

	/*
	 * Initialisation array for tests
	 */
	@BeforeEach
	void setUp() {
		for (int i = 0; i < arrayInt.length; i++) {
			array.add(arrayInt[i]);
		}
	}

	@Test
	void testBubbleSort() {
		assertTrue(array.bubbleSort());

		for (int i = 0; i < sortedArray.length; i++) {
			assertEquals(sortedArray[i], array.get(i));
		}
	}

	@Test
	void testSelectionSort() {
		assertTrue(array.selectionSort());
		for (int i = 0; i < sortedArray.length; i++) {
			assertEquals(sortedArray[i], array.get(i));
		}
	}

	@Test
	void testInsertionSort() {
		assertTrue(array.insertionSort());
		for (int i = 0; i < sortedArray.length; i++) {
			assertEquals(sortedArray[i], array.get(i));
		}
	}

	@Test
	void testShuttleSort() {
		assertTrue(array.shuttleSort());
		for (int i = 0; i < sortedArray.length; i++) {
			assertEquals(sortedArray[i], array.get(i));
		}
	}

	@Test
	void testShellSort() {
		assertTrue(array.shellSort());
		for (int i = 0; i < sortedArray.length; i++) {
			assertEquals(sortedArray[i], array.get(i));
		}
	}

	@Test
	void testReverse() {
		int[] expReverse = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		array.bubbleSort();

		assertTrue(array.reverse());
		for (int i = 0; i < expReverse.length; i++) {
			assertEquals(expReverse[i], array.get(i));
		}
	}

	/**
	 * 
	 * 
	 * Simple algorithm tests ====>
	 * 
	 * 
	 */

	@Test
	void testFactorial() {
		assertEquals(120, SimpleAlgoritms.factorial(5));
		assertEquals(362880, SimpleAlgoritms.factorial(9));
		assertEquals(1, SimpleAlgoritms.factorial(0));
		assertEquals(-1, SimpleAlgoritms.factorial(-7));
	}

	@Test
	void testFibonacci() {
		assertEquals(34, SimpleAlgoritms.fibonacci(10));
		assertEquals(4181, SimpleAlgoritms.fibonacci(20));
		assertEquals(0, SimpleAlgoritms.fibonacci(-5));
		assertEquals(1, SimpleAlgoritms.fibonacci(2));
	}

	@Test
	void testHasSumTwo() {
		int [] ar = {100};
//		assertTrue(SimpleAlgoritms.hasSumTwo(arrayInt, 10));
//		assertTrue(SimpleAlgoritms.hasSumTwo(arrayInt, 4));
//		assertFalse(SimpleAlgoritms.hasSumTwo(arrayInt, 100));
//		assertFalse(SimpleAlgoritms.hasSumTwo(arrayInt, 0));
//		assertFalse(SimpleAlgoritms.hasSumTwo(ar, 1));
	}

//	@Test
//	void testMaxNegativePattern() {
//		int[] array1 = { 1, 10, -7, 3, 7, -3, -10 };//10
//		int[] array2 = { 1, 10, -8, -3 };//-1 no number with negative pattern
//		
//		assertEquals(10, SimpleAlgoritms.maxNegativePattern(array1));
//		assertEquals(-1, SimpleAlgoritms.maxNegativePattern(array2));
//
//	}
	
	@Test
	void testRandomMinMax() {
			int randomNum = SimpleAlgoritms.randomMinMax(0, 5);
	}

	@Test
	void testSwapWithOutThirdVariable() {
		assertTrue(SimpleAlgoritms.swapWithoutThirdVariable(5, 7));
		assertTrue(SimpleAlgoritms.swapWithoutThirdVariable(-5, 7));

	}
	
	

	@Test
	void testCountDigits() {
		assertEquals(5, SimpleAlgoritms.countDigits(12345));
		assertEquals(1, SimpleAlgoritms.countDigits(7));
		assertEquals(1, SimpleAlgoritms.countDigits(0));
		assertEquals(5, SimpleAlgoritms.countDigits(-12345));

	}

	@Test
	void testSumDigits() {
		assertEquals(6, SimpleAlgoritms.sumDigits(123));
		assertEquals(7, SimpleAlgoritms.sumDigits(7));
		assertEquals(0, SimpleAlgoritms.sumDigits(0));
		assertEquals(6, SimpleAlgoritms.sumDigits(-123));

	}
	
	@Test
	void testMaxNegativePattern() {
		short[] array1 = {1, 10, -7, 3, 7, -3, -10}; //10
		short[] array2 = {1, 10, -8, -3}; //-1 no number with the negative pattern
		short[] array3 = {0, -1, 1, -2, -10};
		assertEquals(10, SimpleAlgoritms.maxNegativePattern(array1));
		assertEquals(-1, SimpleAlgoritms.maxNegativePattern(array2));
		assertEquals(1,SimpleAlgoritms.maxNegativePattern(array3));
	}
	
	
	@Test
	void textX() {
		//System.out.println(letter);
		int pos = 0;
		int length = 10;
		
		char letters[] = new char[length];
		
		for (int i = 0; i < length; i++) {
			letters[i] = getRandomalLetter();
		}
		
		
		for (int i = 0; i < letters.length; i++) {
			System.out.print(letters[i]);
		}
		
	}
	
	public static char getRandomalLetter() {
		char letter = (char)((int)'a' + Math.random()*((int)'z'-(int)'a'+1));
		return letter;

		}

}








