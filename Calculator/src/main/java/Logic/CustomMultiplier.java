package Logic;

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
	
	static List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
	
	public static String Multiplicate(List<Integer> listA, List<Integer> listB) {
		
		DigitMultiplication(listA, listB);
		
		String result = Transform(DigitSummation());
		return result;
	}
	
	//multiplying each digit
	static void DigitMultiplication(List<Integer> listA, List<Integer> listB) {
		
		for(int b:listB) {
			List<Integer> list = new ArrayList<Integer>();
			AddZeroAtTheBeginning(list, listOfLists.size());
			int addition = 0;
			for(int a : listA) {
				int res = ((a*b)%10) + addition;
				list.add(res);
				addition = (a*b)/10;
			}
			if(addition > 0)list.add(addition);
			listOfLists.add(list);
			AddZeroAtTheEnd(listOfLists.size());
		}
	}


	//add 0 to the end and beginning to fulfill diagonal writing.
	//00111
	//01110
	//11100
	static void AddZeroAtTheEnd(int size) {
		for(int i = size-2; i >= 0; i--) {
			listOfLists.get(i).add(0);
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
		int digitCount = listOfLists.get(0).size();
		int addition = 0;
		
		for(int i = 0; i<digitCount;i++) {
			int sum = 0;
			
			for(List<Integer> list : listOfLists) {
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
	static String Transform(List<Integer> res) {
		String result = "";
		for(int i = res.size()-1;i >=0; i--) {
			result += res.get(i);
		}
		return result;
	}
	
}