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
    private static String VERSION = "0.4";
    
    
    private String	databaseFile = "jdbc:sqlite:C://Users/Declan/OneDrive - Concern Worldwide/CCT/Software Semester 2/_dev/Thoth/database/oreallyoreilly.db";
    
    private Scanner someInput;
    private Date today;
    
    private static Logger LOG;
    
    
    //Constructors
    
    public App(Level logLevel)
    {
    	
    //associate logging with this class so we know the message comes from this class
    	
    	LOG = LogManager.getLogger(App.class);
    	Configurator.setLevel(LOG.getName(), logLevel);
    	
    	LOG.info("Commandline requested log level:" + logLevel);
    	LOG.info("Commandline requested log level:"+ LOG.isDebugEnabled());
    	
    	
    	//test the logging
    	//testLogOutput();
    	
    	MenuBuilder	theMenu	=	new	MenuBuilder();
		
		theMenu.getMenu().display();
    	
    	
    	this.someInput = new Scanner(System.in);
    	showListOfUsers();

    
    //do something
   // System.out.println("\n Sooon.... stuff will happen here ");
    
    //pause before exit
    	
    	
    System.out.println("\n Press enter to exit program");
    this.someInput.nextLine();
    
    //close the program without error
    
    System.exit(0);
    
    }
    
    public App() {
		this(Level.INFO);
	}

	
    public static void actionCommandlineInput (String args[]) 
    {
    	try {
    		
    		final OptionParser optionParser = new OptionParser();
    		
    		optionParser.acceptsAll(Arrays.asList("v","verbose"),"set logging level to DEBUG to see all logging levels").forHelp();
    		
    		optionParser.acceptsAll(Arrays.asList("h","help"),"display help usage information").forHelp();
    		optionParser.acceptsAll(Arrays.asList("r","version"),"display program version information").forHelp();
    	
    			final OptionSet options = optionParser.parse(args);
    			
    			if	(options.has("help"))
				{
								System.out.println("This	program	takes	an	SQL	database	with	a	User	table	as	displays	the	users.");
								System.out.println("It	is	provided	as	an	example	for	teaching	Java	programming.");
								printUsage(optionParser);
								System.exit(0);
				}
				
				if	(options.has("version"))
				{
								System.out.println("Thoth verion " + VERSION);
								System.exit(0);
				}
				
			if (options.has("verbose"))
			{
							Level logLevel	=	Level.DEBUG;
							System.out.println("RUN	WITH:	logging	level	requested:	" +logLevel);
							App	anApp	=	new	App(logLevel);
			}
			else
			{
							System.out.println("RUN	WITH:	logging	level	requested:	"	+	Level.INFO);
							App	anApp = new App();
			}

    	}
    			catch	(OptionException argsEx)
    		{
    					System.out.println("ERROR:	Arguments\\parameter	is	not	valid.	"	+	argsEx);
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
    		//display the command line text entered
    		for(int i=0; i <args.length; i++)
    		{
    			System.out.println(args[i]);
    		}
    	}
    }
	private static void printUsage(final	OptionParser	parser)
	{
			try
			{
				parser.printHelpOn(System.out);		
			}
			
			catch	(IOException ioEx)
					{							//	System.out.println("ERROR:	Unable	to	print	usage	-	"	+	ioEx);
						LOG.error("ERROR:	Unable	to	print	usage	-	"	+	ioEx);
					}
	}
	
	private void	showListOfUsers()
	{
	this.today	=	new	Date();
		LOG.debug("Getting	list	of	Users	from	Database	as	of	"	+	today);
					
	//if	log	level	id	debug	e.g.	-v	parameter	used	then	show	database	file	being	used
		LOG.debug("Database	file:"	+	this.databaseFile);
					
					//	Get	JDBC	connection	to	database
		Connection	connection	=	null;
					
		try
		{
		//	create	a	database	connection
		connection	=	DriverManager.getConnection(	this.databaseFile);
						
		Statement	statement	=	connection.createStatement();
		
		statement.setQueryTimeout(30);		//	set	timeout	to	30	sec.
							
		//	Run	the	query
							
		ResultSet	resultSet	=	statement.executeQuery("select	*	from	user");
							
		//	iterate	through	the	results	create	User	objects	put	in	the	ListArray
							
		while(resultSet.next())
			{
			LOG.debug(	"User	found:	"	+	resultSet.getString("userName")	);
			}
						 		
		}
		catch(SQLException e)
					
		{
	//	if	the	error	message	is	"out	of	memory",
		//	it	probably	means	no	database	file	is	found
		
		LOG.error(e.getMessage());
		}	
		finally
			{
		try
		
			{
		if(connection	!=	null)
			connection.close();
			}
		catch(SQLException	e)
			{
			//	connection	close
			LOG.error(e.getMessage());
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


