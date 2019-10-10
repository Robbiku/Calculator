package Setup;

import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.Parameter;

public class Parametres {

	@Parameter(names = Commands.big, description="BigInteger calculator")
	  public List<String> big = new ArrayList<String>();
	  
	@Parameter(names = Commands.custom, description="Custom calculator")
	  public List<String> custom = new ArrayList<String>();
	
	@Parameter(names = Commands.help, description="Show manual")
	  public boolean help = false;
}
