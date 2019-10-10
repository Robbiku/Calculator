package Setup;

public class Commands {

	public static final String custom = "--custom";
	public static final String big = "--big";
	public static final String help = "--help";
	
	
	public static final String Manual = String.format
				( "%s - custom multiplication,\n"
				+ "%s - BigInteger multiplication.\n\n "
				+ "Numbers need to be sepparated by comma.\n\n"
				+ "Examples:\n"
				+ "%s 55,32\n",
				Commands.custom,Commands.big,Commands.custom,Commands.big);

}
