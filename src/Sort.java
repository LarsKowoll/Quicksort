import java.util.Random;

public class Sort {

	static int counter;

	public static int quicksort(Datensatz[] a, int ilinks, int irechts, String pivotPos) {

		counter++;
		int i, j, pivot = 0;
		
		if (irechts > ilinks) {
			
			i = ilinks;
			j = irechts - 1;

			if (pivotPos.equals("RECHTES_ELEMENT")) {
				
				pivot = a[irechts].key;
				
			} else if (pivotPos.equals("MEDIAN_OF_THREE")) {
				
				int links = a[ilinks].key;
				int mitte = a[irechts / 2].key;
				int rechts = a[irechts].key;

				if (((links >= mitte) && (links <= rechts)) || (links <= mitte) && (links >= rechts)) {
					pivot = links;
					swap(a, ilinks, irechts);
				} else if (((rechts >= mitte) && (rechts <= links)) || (rechts <= mitte) && (rechts >= links)) {
					pivot = rechts;
					swap(a, irechts, irechts);
				} else {
					pivot = mitte;
					swap(a, irechts / 2, irechts);
				}
				
			} else if (pivotPos.equals("ZUFALLSSTRATEGIE")) {
				Random x = new Random();
				swap(a, ilinks + x.nextInt(irechts - ilinks), irechts);
				pivot = a[irechts].key;
			}

			while (true) {
				counter++;
				while (a[i].key < pivot) {
					counter++;
					i++;
				}
	
				while (j > 0 && a[j].key >= pivot) {
					counter++;
					j--;
				}
					// Vorsicht:
				// Stop-Element einbauen
				if (i >= j)
					break;// in der Mitte getroffen
				swap(a, i, j);// vertauschen
			}
			
			swap(a, i, irechts);// Pivotelement in die Mitte tauschen
			quicksort(a, ilinks, i - 1, pivotPos);
			quicksort(a, i + 1, irechts, pivotPos);

		}
		return counter;
	}

	private static void swap(Datensatz[] a, int i, int j) {
		Datensatz tmp;
		tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static int getCounter() {
		int temp = counter;
		counter = 0;
		return temp;
	}
}
