package service;

import java.util.Arrays;

import datastr.MyArrayList;
import datastr.SortingType;

public class MainService {

	public static void main(String[] args) {
		MyArrayList myList = new MyArrayList();
		
		try {
		myList.append('a');		
		myList.append('g');		
		myList.append('e');		
		
		myList.print();  //age
		myList.appendAtIndex('z', 0);	
		myList.print(); //zage
		
		myList.deleteAtIndex(1);
		myList.print(); //zge
		System.out.println("Elements 1. indeksā - " + myList.getElementAtIndex(1));
		
		myList.append('a');		
		myList.append('z');		
		myList.append('j');		// ievietojot šeit, saraksts tiek palielināts
		myList.append('z');		
		
		System.out.println(Arrays.toString(myList.search('z'))); //0 4 6
		System.out.println(Arrays.toString(myList.searchForRightNeighbour('z'))); //g j
		System.out.println(Arrays.toString(myList.sort(SortingType.ASC)));
		System.out.println(Arrays.toString(myList.sort(SortingType.DESC)));


		myList.makeEmpty();
		myList.print();
		myList.append('a');
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
