import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SortTest {

	public enum Pivotversuchsverfahren {
		RECHTES_ELEMENT, MEDIAN_OF_THREE, ZUFALLSSTRATEGIE
	}

	@Test
	void quicksortTest() {
		
		String testcase = "Null";

		for (Pivotversuchsverfahren pivot : Pivotversuchsverfahren.values()) {

			String pivotPos = "" + pivot;
			System.out.print(pivotPos + ": \t");
			
			for (int i = 0; i < 7; i++) {
				int n = (int) Math.pow(10, i);

				int counter = 0;

				Datensatz[] testArray = new Datensatz[n];

				for (int j = 0; j < testArray.length; j++) {
					testArray[j] = new Datensatz(n);
					// System.out.println(testArray[i].key);
				}
				
				testcase = "random";
				System.out.println(testcase);
				Sort.quicksort(testArray, 0, testArray.length - 1, pivotPos);
				counter = Sort.getCounter();

				System.out.print(counter + "\t");

				for (int j = 0; j < testArray.length - 1; j++) {
					// System.out.println(testArray[j].key);
					int prev = testArray[j].key;
					int next = testArray[j + 1].key;
					assertFalse((prev > next));
				}
				// System.out.println(testArray[testArray.length - 1].key);
			}
			
			System.out.println();
		}
	}
}
