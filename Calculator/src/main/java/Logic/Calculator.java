package Logic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import Output.Output;
import Setup.Parametres;

public class Calculator extends JCommander {
	
	//check for bad inputs
	public Calculator(Parametres object, String... args) {
		try {
			new JCommander(object, args);
		}catch(ParameterException e) {
			Output.UnknownCommandError();
			return;
		}

		if(object.help) {
			Output.Help();
		}else {
			try {
				if(!object.big.isEmpty()) {
					Output.Print(Calculate(object.big.get(0),object.big.get(1)));
				}
				if(!object.custom.isEmpty()) {
					Output.Print(Custom(object.custom.get(0),object.custom.get(1)));
				}
			}catch(IndexOutOfBoundsException | NumberFormatException e) {
				Output.ParametersError();
				return;
			}
		}
	}
	
	
	//multiplication integers by BigInteger
	public static String Calculate(String a, String b) {
		BigInteger result = new BigInteger((a)).multiply(new BigInteger(b));
		return String.valueOf(result);
	}
	
	
	//custom multiplication
	//create lists of digits from strings
	//add digits to list backwards
	public static String Custom(String a, String b) {
		
		List<Integer> listA = new ArrayList<Integer>();
		List<Integer> listB = new ArrayList<Integer>();

		for(char ch : a.toCharArray()) {
			listA.add(0,Character.getNumericValue(ch));
		}
		
		for(char ch : b.toCharArray()) {
			listB.add(0,Character.getNumericValue(ch));
		}
		
		return CustomMultiplier.Multiplicate(listA, listB);
	}
	

}
