package Output;

import Setup.Commands;

public class Output {

	public static void Print(String result) {
		System.out.printf("%s\n", result);
	}
	
	public static void Help() {
		System.out.printf("%s\n", Manual);
	}
	
	public static void EmptyError() {
		System.out.printf("type %s for help\n", Commands.help);
	}
	
	public static void UnknownCommandError() {
		System.out.printf("Unknow command. Type %s for help\n", Commands.help);
	}
	
	public static void ParametersError() {
		System.out.printf("Command need 2 parameters. Type %s for help\n", Commands.help);
	}
	
	
	public static final String Manual = String.format
			( "%s - custom multiplication\n"
			+ "%s - BigInteger multiplication\n\n "
			+ "Numbers need to be sepparated by comma.\n\n"
			+ "Examples:\n"
			+ "%s 55,32\n",
			Commands.custom,Commands.big,Commands.custom,Commands.big);

}
