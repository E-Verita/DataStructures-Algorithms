package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import datastr.MyArrayList;
import datastr.MyArrayListT;
import datastr.SortingType;

public class MainService {

	public static void main(String[] args) {
		MyArrayListT myList = new MyArrayListT();

		try {
			myList.append('a');
			myList.append('g');
			myList.append('e');

			myList.print(); // age
			myList.appendAtIndex('z', 0);
			myList.print(); // zage

			myList.deleteAtIndex(1);
			myList.print(); // zge
			System.out.println("Elements 1. indeksā - " + myList.getElementAtIndex(1));

			myList.append('a');
			myList.append('z');
			myList.append('j'); // ievietojot šeit, saraksts tiek palielināts
			myList.append('z');

			System.out.println(Arrays.toString(myList.search('z'))); // 0 4 6
			System.out.println(Arrays.toString(myList.searchForRightNeighbour('z'))); // g j
			System.out.println(Arrays.toString(myList.sort(SortingType.ASC)));
			System.out.println(Arrays.toString(myList.sort(SortingType.DESC)));

			myList.makeEmpty();
			myList.print();
			myList.append('a');
			
			System.out.println("Darbības ar txt:");
			MyArrayListT listFromFile = createListFromFile("resources/numbers.txt");
			listFromFile.append('š');
			listFromFile.print();
			System.out.println("žā");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static MyArrayListT createListFromFile(String pathToFile) throws FileNotFoundException {
		File myFile = new File(pathToFile);
		FileInputStream myStream = new FileInputStream(myFile);
		Scanner myScanner = new Scanner(myStream);
		MyArrayListT listFromFile = new MyArrayListT();

		while (myScanner.hasNext()) {
			String line = myScanner.nextLine();
			char element = line.charAt(0);
			listFromFile.append(element);
		}

		myScanner.close();
		return listFromFile;

	}

}
