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
	 	void BigMultiTesting(){
		 assertEquals("100", Calculator.BigCalculator("10","10"));
		 assertEquals("0", Calculator.BigCalculator("0","10"));
		 assertEquals("-100", Calculator.BigCalculator("-10","10"));
	 }
	 
	 @Test
	 	void CustomMultiTesting(){
		 assertEquals("100", Calculator.CustomCalculator("10","10"));
		 assertEquals("0", Calculator.CustomCalculator("0","10"));
		 assertEquals("-100", Calculator.CustomCalculator("10","-10"));
	 }
	 
	 
	 @Test
	 	void CompareTesting(){
		 assertEquals(Calculator.BigCalculator("12124412","12412412421"),(Calculator.CustomCalculator("12124412","12412412421")));
		 assertEquals(Calculator.BigCalculator("0","0"),(Calculator.CustomCalculator("0","0")));
		 assertEquals(Calculator.BigCalculator("-10","10"),(Calculator.CustomCalculator("-10","10")));
		 assertEquals(Calculator.BigCalculator("-10","-10"),(Calculator.CustomCalculator("-10","-10")));
		 assertEquals(Calculator.BigCalculator("-10","0"),(Calculator.CustomCalculator("-10","0")));
	 }
	 
}
