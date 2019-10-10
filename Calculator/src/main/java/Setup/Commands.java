package Setup;

public class Commands {

	public static final String custom = "--custom";
	public static final String big = "--big";
	public static final String help = "--help";
	
	
	public static final String Manual = String.format
				( "%s - multiplicate 2 numbers up to 18 digits,\n"
				+ "%s - multiplicate 2 numbers more than 18 digits.\n\n "
				+ "Numbers need to be sepparated by comma.\n\n"
				+ "Examples:\n"
				+ "%s 55,32\n",
				Commands.custom,Commands.big,Commands.custom,Commands.big);

}
