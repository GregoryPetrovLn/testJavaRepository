package telran.util;

public class SimpleAlgoritms {

	/**
	 * 
	 * @param number
	 * @return
	 */
	public static int factorial(int number) {
		if (number < 0) {
			return -1;
		}
		int factorial = 1;
		for (int i = 1; i <= number; i++) {
			factorial *= i;
		}

		return factorial;
	}

	/**
	 * 
	 * Only for numbers starts from 0!
	 * 
	 * @param number
	 * @return
	 */
	public static int fibonacci(int number) {
		if (number <= 1)
			return 0;
		if (number == 2)
			return 1;

		int fibonacci = fibonacci(number - 1) + fibonacci(number - 2);
		return fibonacci;
	}

	/**
	 * 
	 * @param array
	 * @param sum
	 * @return
	 */
	public static boolean hasSumTwo(int[] array, int sum) {
		boolean[] helper = new boolean[sum + 1];

		for (int i = 0; i < array.length; i++) {
			int heplerIndex = sum - array[i];

			if (heplerIndex < 0) {
				System.out.println("i=" + i);
				System.out.println("array[i]=" + array[i]);
				System.out.println(helper[i]);
				System.out.println("continue");
				System.out.println("========");
				continue;
			}

			
			if (helper[sum - array[i]]) {
				helper[array[i]] = true;

				System.out.println("i=" + i);
				System.out.println("array[i]=" + array[i]);
				System.out.println(helper[array[i]]);
				System.out.println("return true");
				System.out.println("==========================>");
		
				return true;
			}
			

			helper[array[i]] = true;
			System.out.println("i=" + i);
			System.out.println("array[i]=" + array[i]);
			System.out.println(helper[array[i]]);
			System.out.println("========");
		}

		return false;
	}

	/**
	 * 
	 * @param array
	 * @return
	 */
	public static int maxNegativePattern(int[] array) {
		// TODO

		

		return -1;
	}



	/**
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public static int randomMinMax(int min, int max) {
		int randomNum = min + (int)(Math.random() * ((max + 1) - min));
		return randomNum;
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean swapWithoutThirdVariable(int a, int b) {
		int aBefore = a;
		int bBefore = b;

		a = a + b;
		b = a - b;
		a = a - b;

		if (aBefore == b && bBefore == a)
			return true;

		return false;
	}

	/**
	 * 
	 * @param number
	 * @return
	 */
	public static int countDigits(int number) {
		if (number < 0) {
			number *= -1;
		}
		int digits = 0;

		do {
			digits++;
			number /= 10;

		} while (number > 0);

		return digits;
	}

	/**
	 * 
	 * @param number
	 * @return
	 */
	public static int sumDigits(int number) {
		if (number < 0) {
			number *= -1;
		}

		int sum = 0;

		do {
			sum += number % 10;
			number /= 10;

		} while (number > 0);

		return sum;
	}
	
	
	public static short maxNegativePattern(short[] array) {
		short [] helper = new short[Short.MAX_VALUE + 1];
		short res = 0;
		short number = 0;
		int indexHelper = -1;
		for(int i = 0; i < array.length; i++) {
			if (array[i] == 0 || array[i] == Short.MIN_VALUE) {
				continue;
			}
			indexHelper = Math.abs(array[i]);
			number = helper[indexHelper];
			if (array[i] < 0 && number > res) {
				res = number;
			} else if(array[i] > res && number < 0) {
				res = array[i];
			}
			helper[indexHelper] = array[i];
		}
		return res == 0 ? -1 : res;
	}
	
	
	
	
	
	
	
	

}
















