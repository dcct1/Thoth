package dcct1.Thoth;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.io.File;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;


import joptsimple.OptionException;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dcct1.Thoth.menu.MenuBuilder;
import dcct1.Thoth.data.DataManagerSQLite;


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
    
    private Scanner someInput;
    private Date today;
    	
    private static String VERSION = "0.5";
    
    
   // private String	databaseFile = "jdbc:sqlite:C://Users/Declan/OneDrive - Concern Worldwide/CCT/Software Semester 2/_dev/Thoth/database/oreallyoreilly.db";
    private String dbURL;
    
    
    private static Logger LOG;
    
    
    public App(String dbURL, Level logLevel)
    {
    	
    	this.dbURL = dbURL;
    	
    	LOG = LogManager.getLogger(App.class);
    	Configurator.setLevel(LOG.getName(), logLevel);
    	
    	LOG.info("Commandline requested log level:" + logLevel);
    	LOG.info("Commandline requested log level:"+ LOG.isDebugEnabled());
    	
    	
    	//test the logging
    	//testLogOutput();
    	
    	this.someInput = new Scanner(System.in);
    	
    	DataManagerSQLite.getInstance().setDataFile(this.dbURL);
    	
    	
    	MenuBuilder	theMenu	=	new	MenuBuilder();
		
		theMenu.getMenu().display();
    	
    	
    	
    	
    	
    	//showListOfUsers();

    	
    	
    System.out.println("\n Press enter to exit program");
    this.someInput.nextLine();
    
    
    System.exit(0);
    
    }
    
    public App(String dbFile) {
		this(dbFile, Level.INFO);
	}

    public String getDtabaseName()
    {
    	return this.dbURL;
    }
	
    public static void actionCommandlineInput (String args[]) 
	{
		String	filename	=	null;
		String	dbType	=	null;
		String	dbURL	=	null;
		
		try
	
		{	
			final	OptionParser	optionParser	=	new	OptionParser();
													
			optionParser.acceptsAll(Arrays.asList("v",	"verbose"),	"Set logging level to DEBUG to see all levels of log messages").forHelp();


			optionParser.acceptsAll(Arrays.asList("h",	"help"), "Display help/usage information").forHelp();
			
			optionParser.acceptsAll(Arrays.asList("r",	"version"),	"Display program version information").forHelp();
			
			optionParser.acceptsAll(Arrays.asList("d", "database"),	"Path and name of database file.")
			
			.withRequiredArg()
			
			.ofType(String.class)
			
			.describedAs("SQlite database");
			
			
			
			final OptionSet	options	= optionParser.parse(args);
			
			
			
			if	(options.has("help"))
			
			{
			
				System.out.println("This	program	takes	an	SQL	database	with	a	User	table	as	displays	the	users.");
				
				System.out.println("It	is	provided	as	an	example	for	teaching	Java	programming.");
				
				printUsage(optionParser);
				
				System.exit(0);
				
			}
										
			
			if	(options.has("version"))
				
			{
			
				System.out.println("Pythia	version	:	"	+	VERSION);
			
				System.exit(0);
				
			}
													
			if	(!options.has("database"))
			
			{
			
				System.out.println("Option	\"-d	database\"	is	required");
				
				System.out.println("expecting	the	filename	to	be	specified	as	follows:	jdbc:sqlite:filepath\filename");
														
				
				System.exit(0);
				
			}
			
			else
			
			{
														
				
				dbURL	=	(String)	options.valueOf("database");
				
														
				
				filename	=	dbURL.substring(dbURL.lastIndexOf(':')+1);
				
														
				
				dbType	=	dbURL.substring(dbURL.indexOf(':')+1,	dbURL.lastIndexOf(':'));
				
				
			}
										
										
			
			if	(	dbType.equals("sqlite"))
			
			{
			
				if	(!new	File(filename).isFile())
				
				{
																	
					System.out.println("ERROR:	Database	file	does	not	exist	:	"	+	(String)options.valueOf("database"));
					
					System.out.println("If	the	file	is	in	the	same	directory	as	the	JAR	then	the	location	would	be:	databaseFileName.Extention");
					
					
					System.out.println("for	windows	the	database	file	location	would	be:	C://folder/folder/databaseFileName.Extention");
					
					System.out.println("for	MAC	the	database	file	location	would	be:	/Volumes/VolumeName/folder/folder/databaseFileName.Extention");
					
					System.exit(0);
				
				}	 	 	 	 	 	
				
			}
			
			else if	(	dbType.equals("mysql"))
				
			{
				System.out.println("Support	for	mySQL is coming	soon. Please	use	an	SQLite	database");
			 	
				System.exit(0);		 	 	 	
				
			}
			
			else
			
			{
			
				System.out.println("Unsupported	database type requested	"	+	dbType);
				
				System.exit(0);
				
			}
										
			
										
			
			if	(options.has("database") &&	options.has("verbose"))
			
			{
			
				Level logLevel = Level.DEBUG;
				
				System.out.println("RUN	WITH: Database:	" + dbURL + " logging level	requested:	" +	logLevel);
				
				App	anApp	=	new	App(dbURL, logLevel);
				
			}
			
			else
			
			{
			
				System.out.println("RUN	WITH:	Database:	"	+	dbURL	+	"	logging	as	per	main/resources/Log4J2.xml");
				
				App	anApp	=	new	App(dbURL);
				
			}	 			
									
			
		}
		
		catch	(OptionException	argsEx)
		
		{
		
			System.out.println("ERROR:	Arguments\\parameter	is	not	valid.	"	+	argsEx);
			
			System.exit(0);
			
		}
		
		catch	(IndexOutOfBoundsException	iobEx)
		
		{
		
			System.out.println("ERROR:	invalid	database	name	format	provided	"	+	iobEx);
			
			System.out.println("expecting	the	filename	to	be	specified	as	follows	>	jdbc:sqlite:filepath\filename");
			
			System.exit(0);	
			
		}
}
    
    private static void printUsage(final	OptionParser	parser)
	{
			try
			{
				parser.printHelpOn(System.out);		
			}
			
			catch	(IOException ioEx) {
			
						LOG.error("ERROR:	Unable	to	print	usage	-	"	+	ioEx);
			}
	}	
    

    public static void seeCommandlineInput (String args[])
    {
    	if (args.length == 0)
    	{
    		System.out.println("There was no commands passed");
    		
    	}
    	else
    	{
    		
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


