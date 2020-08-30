package telran.util;

import java.util.Arrays;

public class Array {
	private int[] array;
	private int size;
	private static int defaultCapacity = 10;

	public Array(int capacity) {
		array = new int[capacity];
	}

	public Array() {
		this(defaultCapacity);
	}

	public void add(int num) {
		if (size == array.length) {
			realLocate();
		}
		array[size++] = num;
	}

	public int size() {
		return size;
	}

	public void realLocate() {
		array = Arrays.copyOf(array, array.length + 1);
	}

	public int get(int index) {
		if (index < 0 || index >= size) {
			return -1;
		}

		return array[index];
	}

	public void printArray() {

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Sort algorithm methods =====>
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	/**
	 * 
	 * @return
	 */
	public boolean bubbleSort() {
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length - i; j++) {
				if (array[j - 1] > array[j]) {
					int tmp;

					tmp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = tmp;
				}
			}
		}
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public boolean selectionSort() { 
		for (int i = 0; i < array.length; i++) {
			int min = array[i];
			int minIndex = i;

			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < min) {
					min = array[j];
					minIndex = j;
				}

			}

			if (i != minIndex) {
				int tmp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = tmp;
			}

		}
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public boolean insertionSort() {
		for (int i = 0; i < array.length; i++) {
			int value = array[i];

			int j = i - 1;
			for (; j >= 0; j--) {
				if (value < array[j]) {
					array[j + 1] = array[j];
				} else {
					break;
				}
			}
			array[j + 1] = value;
		}

		return true;
	}

	/**
	 * 
	 * @return
	 */
	public boolean shuttleSort() {
		int tmp;
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				tmp = array[i];
				array[i] = array[i - 1];
				array[i - 1] = tmp;
				for (int j = i - 1; (j - 1) >= 0; j--) {
					if (array[j] < array[j - 1]) {
						tmp = array[j];
						array[j] = array[j - 1];
						array[j - 1] = tmp;
					} else {
						break;
					}
				}
			}
		}
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public boolean shellSort() {
		int gap = array.length / 2;
		while (gap >= 1) {
			for (int right = 0; right < array.length; right++) {
				for (int c = right - gap; c >= 0; c -= gap) {
					if (array[c] > array[c + gap]) {
						int tmp = array[c];
						array[c] = array[c + gap];
						array[c + gap] = tmp;
					}
				}
			}
			gap = gap / 2;
		}
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public static int[] mergeSort(int[] array, int low, int high) {
		if (high <= low)
			return array;
		int mid = low + (high - low) / 2;
		mergeSort(array, low, mid);
		mergeSort(array, mid + 1, high);

		int[] buf = Arrays.copyOf(array, array.length);

		for (int k = low; k <= high; k++)
			buf[k] = array[k];

		int i = low, j = mid + 1;
		for (int k = low; k <= high; k++) {

			if (i > mid) {
				array[k] = buf[j];
				j++;
			} else if (j > high) {
				array[k] = buf[i];
				i++;
			} else if (buf[j] < buf[i]) {
				array[k] = buf[j];
				j++;
			} else {
				array[k] = buf[i];
				i++;
			}
		}
		return array;
	}

	/**
	 * 
	 * @return
	 */
	public static int[] countigSort(int[] theArray, int maxValue) {
		// Массив со "счётчиками" размером от 0 до максимального значения
		int numCounts[] = new int[maxValue + 1];
		// В соответствующей ячейке (индекс = значение) увеличиваем счётчик
		for (int num : theArray) {
			numCounts[num]++;
		}

		// Подготавливаем массив для отсортированного результата
		int[] sortedArray = new int[theArray.length];
		int currentSortedIndex = 0;

		// идём по массиву со "счётчиками"
		for (int i = 0; i < numCounts.length; i++) {
			int count = numCounts[i];
			// идём по количеству значений
			for (int j = 0; j < count; j++) {
				sortedArray[currentSortedIndex] = i;
				currentSortedIndex++;
			}
		}

		return sortedArray;
	}

	/**
	 * 
	 * @return
	 */
	public static int[] quickSort(int[] source, int leftBorder, int rightBorder) {
		int leftMarker = leftBorder;
		int rightMarker = rightBorder;
		int pivot = source[(leftMarker + rightMarker) / 2];
		do {
			// Двигаем левый маркер слева направо пока элемент меньше, чем pivot
			while (source[leftMarker] < pivot) {
				leftMarker++;
			}
			// Двигаем правый маркер, пока элемент больше, чем pivot
			while (source[rightMarker] > pivot) {
				rightMarker--;
			}
			// Проверим, не нужно обменять местами элементы, на которые указывают маркеры
			if (leftMarker <= rightMarker) {
				// Левый маркер будет меньше правого только если мы должны выполнить swap
				if (leftMarker < rightMarker) {
					int tmp = source[leftMarker];
					source[leftMarker] = source[rightMarker];
					source[rightMarker] = tmp;
				}
				// Сдвигаем маркеры, чтобы получить новые границы
				leftMarker++;
				rightMarker--;
			}
		} while (leftMarker <= rightMarker);

		// Выполняем рекурсивно для частей
		if (leftMarker < rightBorder) {
			quickSort(source, leftMarker, rightBorder);
		}
		if (leftBorder < rightMarker) {
			quickSort(source, leftBorder, rightMarker);
		}

		return source;
	}

	/**
	 * 
	 * @return
	 */
	public boolean reverse() {
		for (int i = 0; i < array.length / 2; i++) {
			int tmp = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = tmp;
		}
		return true;
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Search algorithm methods =====>
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	/**
	 * 
	 * @param pattern
	 * @return
	 */
	public static int binarySearch(int[] sortedArray, int key, int low, int high) {
		int index = -1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (sortedArray[mid] < key) {
				low = mid + 1;
			} else if (sortedArray[mid] > key) {
				high = mid - 1;
			} else if (sortedArray[mid] == key) {
				index = mid;
				break;
			}
		}
		return index;
	}

	/**
	 * 
	 * @param integers
	 * @param elementToSearch
	 * @return
	 */
	public static int jumpSearch(int[] integers, int elementToSearch) {

		int arrayLength = integers.length;
		int jumpStep = (int) Math.sqrt(integers.length);
		int previousStep = 0;

		while (integers[Math.min(jumpStep, arrayLength) - 1] < elementToSearch) {
			previousStep = jumpStep;
			jumpStep += (int) (Math.sqrt(arrayLength));
			if (previousStep >= arrayLength)
				return -1;
		}
		while (integers[previousStep] < elementToSearch) {
			previousStep++;
			if (previousStep == Math.min(jumpStep, arrayLength))
				return -1;
		}

		if (integers[previousStep] == elementToSearch)
			return previousStep;
		return -1;
	}

	/**
	 * 
	 * @param integers
	 * @param elementToSearch
	 * @return
	 */
	public static int interpolationSearch(int[] integers, int elementToSearch) {

		int startIndex = 0;
		int lastIndex = (integers.length - 1);

		while ((startIndex <= lastIndex) && (elementToSearch >= integers[startIndex])
				&& (elementToSearch <= integers[lastIndex])) {

			int pos = startIndex + (((lastIndex - startIndex) / (integers[lastIndex] - integers[startIndex]))
					* (elementToSearch - integers[startIndex]));

			if (integers[pos] == elementToSearch)
				return pos;

			if (integers[pos] < elementToSearch)
				startIndex = pos + 1;

			else
				lastIndex = pos - 1;
		}
		return -1;
	}

}
