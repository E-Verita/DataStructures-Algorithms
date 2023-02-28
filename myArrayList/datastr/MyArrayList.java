package datastr;

import javax.xml.transform.Templates;

public class MyArrayList {
	private char[] elements;
	private final int DEFAULT_ARRAY_SIZE = 5;
	private int arraySize = DEFAULT_ARRAY_SIZE;
	private int elementCount = 0;

	// konstruktori

	public MyArrayList() {
		elements = new char[arraySize];
	}

	public MyArrayList(int inputArraySize) {
		if (inputArraySize > 0) {
			arraySize = inputArraySize;
		}
		elements = new char[arraySize];
	}

	// TODO: GET&SET

	// funkcijas

	public boolean isEmpty() {
		return (elementCount == 0);
	}

	public boolean isFull() {
		return (elementCount == arraySize);
	}

	public int howManyElements() {
		return elementCount;
	}

	public void increaseArrayList() {
		// 1. noskaidrot, cik reizes lielāks būs masīvs
		int newArraySize = (elementCount > 100) ? (int) (arraySize * 1.5) : arraySize * 2;
		arraySize = newArraySize;

		// 2. izveidot jauno masīvu
		char[] newArrayForElements = new char[elementCount];

		// 3. veikt visu elementu pārkopēšanu jaunajā masīvā
		for (int i = 0; i < elementCount; i++) {
			newArrayForElements[i] = elements[i];
		}
		// 4. nomainīt referenci uz jauno masīvu
		elements = newArrayForElements;
	}

	public void append(char inputElement) {
		// 1. Pārbauda, vai pilns
		if (isFull()) {

			// ja pilns - palielinām
			increaseArrayList();
		}

		// 2. ieliekam jauno elementu pēc pēdējā elementa
		elements[elementCount] = inputElement;
		// var arī elements[elementCount++] = inputElement;

		// 3. palielināt elementu skaitu
		elementCount++;
	}

	public void appendAtIndex(char inputElement, int index) throws Exception {
		// 1. jānoskaidro, vai ir atbilstošs index

		// index ir negatīvs vai lielāks par elementu skaitu +1 - metīsim izņēmumu
		if (index < 0 || index > elementCount + 1) {
			throw new Exception("Nav atbilstošs indekss");

		} else {
			if (isFull()) {
				increaseArrayList();
			}

			// index ir vienāds ar elementu skaitu - ieliekam kā pēdējo
			if (index == elementCount) {
				append(inputElement);
			}

			// index ir derīgs, bet nav vienāds ar elementu skaitu
			else if (index < elementCount) {
				// veicam elementu kopēšanu, ņēmot vērā index - sākam no aizmugures
				for (int i = elementCount; i > index; i--) {
					elements[i + 1] = elements[i];
				}

				// ievietojam jauno elementu konkrētajā indexā
				elements[index] = inputElement;

				// palielinām elementu skaitu
				elementCount++;
			}
		}
	}

	public void deleteAtIndex(int index) throws Exception {

		// Pārbauda, vai tukšs
		if (isEmpty()) {
			throw new Exception("Nav ko dzēst, saraksts ir tukšs!");
		}

		// ja nav tukšs - pārbauda, vai atbilstošs index
		else if (index < 0 || index >= elementCount) {
			throw new Exception("Nevar dzēst, neatbilstošs index!");
		}

		// ja atbilstošs - veikt kopēšanu
		for (int i = index + 1; i >= elementCount; i++) {
			elements[i - 1] = elements[i];
		}
		elements[elementCount - 1] = ' ';
		elementCount--;
	}

	public char getElementAtIndex(int index) throws Exception {
		if (isEmpty()) {
			throw new Exception("Saraksts ir tukšs!");
		} else if (index < 0 || index >= elementCount) {
			throw new Exception("Nekorekts index!");
		} else {
			return elements[index];
		}
	}

	public int[] search(char inputElement) throws Exception {
		if (isEmpty()) {
			throw new Exception("Saraksts ir tukšs!");
		} else {
			// Noskaidrot, cik reizes sarakstā var atrast meklēto elementu
			int count = 0;
			for (int i = 0; i < elementCount; i++) {
				if (elements[i] == inputElement) {
					count++;
				}
			}

			// Izveido tik lielu masīvu, cik ir atrasto elementu skaits
			int[] indexes = new int[count];

			if (count == 0) {
				throw new Exception("Elements nav atrasts!");

			} else {
				int j = 0;
				// aizpilda indexu masīvu, pārmeklējot sarakstu vēlreiz
				for (int i = 0; i < elements.length; i++) {
					if (elements[i] == inputElement) {
						indexes[j++] = i;
						// j++
					}
				}
				// atgriežam indexu masīvu
				return indexes;
			}
		}
	}

	public char[] searchForRightNeighbour(char inputElement) throws Exception {
		if (isEmpty()) {
			throw new Exception("Saraksts ir tukšs!");
		} else {
			// Vai meklētais elements eksistē sarakstā
			// Ja neeksistē - try and catch
			try {
				// ja eksistē - tad iegūstam indexus
				int[] indexes = search(inputElement);

				// noskaidrojam, vai meklētais simbols nav kā pēdējais
				char[] rightNeighbours;

				// ja ir, tad kaimiņu rezultatīvais masīvs būs par vienu šūnu mazāks kā indekss
				if (indexes[indexes.length] == elementCount) {
					rightNeighbours = new char[indexes.length - 1];

					// ja nav, tad kaimiņu masīva izmērs būs tāds pats kā indeksiem
				} else {
					rightNeighbours = new char[indexes.length];
				}

				// izveido masīvu kaimiņiem
				// aizpildīt kaimiņu masīvu - cikls, kas iet cauri
				for (int i = 0; i < rightNeighbours.length; i++) {

					int inWhichIndex = indexes[i]; // noskaidrojam meklētā simbola index
					char rightNeighbourTemp = elements[inWhichIndex + 1]; // dabūjam kaimiņu elementu
					rightNeighbours[i] = rightNeighbourTemp; // ieleikam kaimiņu elementu masīvā
				}

				// atgriežam kaimiņu masīvu
				return rightNeighbours;

			} catch (Exception e) {
				throw new Exception("Kaimiņus nevar atrast, jo meklētais elements neeksistē sarakstā!");
			}
		}
	}

	public void print() {
		if (isEmpty()) {
			System.err.println("Saraksts ir tukšs");
		}

		for (int i = 0; i < elementCount; i++) {
			System.out.print(elements[i] + " ");
		}
		System.out.println();
	}

	public void makeEmpty() {
		arraySize = DEFAULT_ARRAY_SIZE;
		elements = new char[arraySize];
		elementCount = 0;
	}

	public char[] sort(SortingType type) throws Exception {
		if (isEmpty()) {
			throw new Exception("Saraksts ir tukšs!");
		}

		else {
			// izveidot jaunu masīvu, kuru pēc tam kārtosim
			char[] sortedArray = new char[elementCount];

			// veikt elementu kopēšanu jaunajā masīvā
			for (int i = 0; i < elementCount; i++) {
				sortedArray[i] = elements[i];
			}

			// pārbaude, kādā secībā kārtot
			// izvēlēties kārtošanas algoritmu, Bubble Sort
			// realizēt kārtošanas algoritmus abos gadījumos (asc, desc)
			if (type == SortingType.ASC) {

				for (int i = 0; i < sortedArray.length; i++) {
					for (int j = 0; j < sortedArray.length; j++) {
						if (sortedArray[i] < sortedArray[j]) {
							char temp = sortedArray[i];
							sortedArray[i] = sortedArray[j];
							sortedArray[j] = temp;
						}
					}
				}
			} else if (type == SortingType.DESC) {
				for (int i = 0; i < sortedArray.length; i++) {
					for (int j = 0; j < sortedArray.length; j++) {
						if (sortedArray[i] > sortedArray[j]) {
							char temp = sortedArray[i];
							sortedArray[i] = sortedArray[j];
							sortedArray[j] = temp;
						}
					}
				}
			}		
			// atgriezt sakārtoto masīvu
			return sortedArray;
		}
	}
}
