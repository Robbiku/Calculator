package Logic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


//pattern of multiplication
		//  111
		//  111
		//_____
		//  111
		// 111
		//111
		//_____
		//12321
////////////////////////////
public class CustomMultiplier {
	
	static List<List<Integer>> listOfDigitLists;
	
	
	public static String Multiplicate(String a, String b) {
		List<Integer> listA = new ArrayList<Integer>();
		List<Integer> listB = new ArrayList<Integer>();
		listOfDigitLists = new ArrayList<List<Integer>>();
		Boolean isNegative = false;
		
		//check if number is negative
		if(a.charAt(0) == '-') {
			isNegative = !isNegative;
			a = a.substring(1);
		}
		if(b.charAt(0) == '-') {
			isNegative = !isNegative;
			b= b.substring(1);
		}
		
		//convert strings to lists
		for(char ch : a.toCharArray()) {
			listA.add(0,Character.getNumericValue(ch));
		}
		for(char ch : b.toCharArray()) {
			listB.add(0,Character.getNumericValue(ch));
		}
		
		
		//switch lists by size to increase performance
		if(listA.size() > listB.size()) {
			DigitMultiplication(listA, listB);
		}else {
			DigitMultiplication(listB, listA);
		}
		
		String result = Transform(DigitSummation());
		
		if(isNegative && result != "0") {		
			result = "-" + result;
		}
		return result;
	}

	//multiplying each digit
	static void DigitMultiplication(List<Integer> listA, List<Integer> listB) {
		for(int b:listB) {
			List<Integer> list = new ArrayList<Integer>();
			AddZeroAtTheBeginning(list, listOfDigitLists.size());
			int addition = 0;
			for(int a : listA) {
				int result = ((a*b)%10) + addition;
				list.add(result);
				addition = (a*b)/10;
			}
			if(addition > 0)list.add(addition);
			listOfDigitLists.add(list);
			AddZeroAtTheEnd(listOfDigitLists.size());
		}
	}


	//add 0 to the end and beginning to fulfill diagonal writing.
	//00111
	//01110
	//11100
	static void AddZeroAtTheEnd(int size) {
		for(int i = size-2; i >= 0; i--) {
			listOfDigitLists.get(i).add(0);
		}
	}
	static void AddZeroAtTheBeginning(List<Integer>list, int size) {
		for(int i = 0; i < size; i++) {
			list.add(0);
		}
	}
	
	
	
	//sum digits vertically with each list
	static List<Integer> DigitSummation() {
		List<Integer> result = new ArrayList<Integer>();
		int digitCount = listOfDigitLists.get(0).size();
		int addition = 0;
		
		for(int i = 0; i<digitCount;i++) {
			int sum = 0;
			
			for(List<Integer> list : listOfDigitLists) {
				sum += list.get(i);
			}
			sum += addition;
			addition = sum/10;
			sum = sum%10;
			
			result.add(sum);
		}
		if(addition > 0)result.add(addition);
		
		return result;
	}
	
	//add digits to string backwards (back to normal)
	static String Transform(List<Integer> list) {
		String result = "";
		for(int i = list.size()-1;i >=0; i--) {
			result += list.get(i);
		}
		result = RemoveUnnecessaryZeroes(result);
		return result;
	}
	
	
	static String RemoveUnnecessaryZeroes(String s) {
	    for (int i = 0; i < s.length(); i++) {
	        char ch = s.charAt(i);
	        if (ch != '0') {
	            return s.substring(i);
	        }
	    }
	    return "0";
	}
	
}