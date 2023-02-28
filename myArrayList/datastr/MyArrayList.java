package datastr;

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
		return(elementCount== arraySize);
	}
	
	public int howManyElements() {
		return elementCount;
	}
	
	public void increaseArrayList() {
		//1. noskaidrot, cik reizes lielāks būs masīvs
		int newArraySize = (elementCount>100) ? (int)(arraySize * 1.5) : arraySize * 2;
		arraySize = newArraySize;
		
		//2. izveidot jauno masīvu
		char[] newArrayForElements = new char[elementCount];
		
		//3. veikt visu elementu pārkopēšanu jaunajā masīvā
		for (int i = 0; i<elementCount; i++) {
			newArrayForElements[i] = elements[i];
		}
		//4. nomainīt referenci uz jauno masīvu
		elements = newArrayForElements;
	}
	
	public void append(char inputElement) {
		//1. Pārbauda, vai pilns
		if (isFull()) {
			
		// ja pilns - palielinām
			increaseArrayList();
		}
		
		//2. ieliekam jauno elementu pēc pēdējā elementa
		elements[elementCount] = inputElement;
		// var arī elements[elementCount++] = inputElement;						
		
		//3. palielināt elementu skaitu
		elementCount++; 
	}
	
	public void appendAtIndex(char inputElement, int index) throws Exception{
		// 1. jānoskaidro, vai ir atbilstošs index
		
		// index ir negatīvs vai lielāks par elementu skaitu +1 - metīsim izņēmumu
		if (index < 0 || index > elementCount+1) {
			throw new Exception("Nav atbilstošs indekss");
		}
		
		// index ir vienāds ar elementu skaitu - ieliekam kā pēdējo
		else if ( index == elementCount) {
			append(inputElement);
		}
		
		//index ir derīgs, bet nav vienāds ar elementu skaitu
		else {
			
			//veicam elementu kopēšanu, ņēmot vērā index - sākam no aizmugures
			for (int i = 0; i > index; i--) {
				
				//ievietojam jauno elementu konkrētajā indexā
				elements[i+1] = elements[i];
				
				//palielinām elementu skaitu
				elementCount++;
			}
		}
	}
	//1.32 test////
	
	
	
	

}
