package dcct1.Thoth;

import java.util.Date;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Date: Feb 2018
 * @author Declan.Kenny
 * 
 * The Purpose of this is to show an example of 
 * 
 * The use of development tools : GIT MAVEN ECLIPSE
 * How to use Eclipse
 * Provides a refresher OOP in Java
 * Provide an introduction to project file structure layout - MAEN Archetype
 */
public class App 
{
    public static void main( String[] args )
    {
       //To view the arguments being created
    	seeCommandlineInput(args);
    	
    	//to instantiate App class based in the parameters entered at the commandline
    	actionCommandlineInput(args);
    }
    	//DATA
    	// define attributes
    
    private Scanner someInput;
    private Date today;
    
    private static Logger LOG;
    
    
    //Constructors
    
    public App()
    {
    //associate logging with this class so we know the message comes from this class
    	
    	LOG = LogManager.getLogger(App.class);
    	
    	//test the logging
    	testLogOutput();
    	
    	
    this.someInput = new Scanner(System.in);
    
    //do something
    System.out.println("\n Sooon.... stuff will happen here ");
    
    //pause before exit
    System.out.println("\n Press enter to exit program");
    this.someInput.nextLine();
    
    //close the program without error
    System.exit(0);
    
    }
    
    /**
     * action the arguments presented on the command line 
     * instantiate the App class based on the arguments passed 
     */
    
    public static void actionCommandlineInput (String args[]) 
    {
    	
    	App anApp = new App();
    	
    }

    public static void seeCommandlineInput (String args[])
    {
    	if (args.length == 0)
    	{
    		System.out.println("There was no commands passed");
    		
    	}
    	else
    	{
    		//dispaly the command line text entered
    		for(int i=0; i <args.length; i++)
    		{
    			System.out.println(args[i]);
    		}
    	}
    }
    
    /**
     * test the Log4j2 logging
     */
    
    private static void testLogOutput()
    {
    	LOG.debug("Log test: Test printed info");
    	LOG.info("Log test: Test printed info");
    	LOG.warn("Log test: Test printed warn");
    	LOG.error("Log test: Test printed error");
    	LOG.fatal("Log test: Test printed fatal");
    	
    	LOG.info("Appending string: {}.", "Application log test message - hi ");
    	
    	
    }
    
}


