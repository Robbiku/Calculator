package Calc;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import Logic.Calculator;
import Setup.Parametres;


public class JunitTest {
	 
	
	 @Test
	 	void OneParameterErrorHandling(){
		 Setup.Parametres setup = new Parametres();
		 assertDoesNotThrow(()->new Calculator(setup, new String[] {"--custom", "12"}));
	 }
	 
	 @Test
	 	void NotIntegersErrorHandling(){
		 Setup.Parametres setup = new Parametres();
		 assertDoesNotThrow(()->new Calculator(setup, new String[] {"--custom", "ss,dd"}));
	 }
	 
	 @Test
	 	void MultiplicationTesting(){
		 assertEquals("100", Calculator.Calculate("10","10"));
		 assertEquals("100", Calculator.Calculate("10","10"));
		 assertEquals(Calculator.Calculate("12124412","12412412421"),(Calculator.Custom("12124412","12412412421")));
	 }
	 
}
