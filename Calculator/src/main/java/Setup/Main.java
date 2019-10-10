package Setup;

import Logic.Calculator;
import Output.Output;

public class Main {
	
	
	public static void main(String[] args) {
		
		//check if input is not empty otherwise run calculator.
		if(args.length == 0) {
			Output.EmptyError();
		}else {
		new Calculator(new Parametres(), args);
		}
		
	}
	

}
