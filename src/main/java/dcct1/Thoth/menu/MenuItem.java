package dcct1.Thoth.menu;

/**
 * Feb 2018
 *  @author Declan
 *	ref CCT Softwrae Dev lab 06 code 
 */

public class MenuItem extends MenuWidget 
{
 
	String name;
	String description;
	int itemID;
	boolean executable;
	String executor;
	
	
	//constructors
	
	public MenuItem(int id, String name, String description) {
		
		this ( id, name, description, "sayInvalidOption", false);
			
	}
	
	public MenuItem(int id, String name, String description, String classname) {
		
		this (id, name, description, classname, true);
	}
	
	//methods
	
	private MenuItem(int id, String name, String description, String classname, boolean canExecute)
	{
	
		this.itemID = id;
		this.name =name;
		this.description = description;
		this.executable = canExecute;
		
	}
	
	public int getID() {
		
		return this.itemID;
	}
	
	public String getDisplayName() {
		
		return this.name;
	}
	
	public String getDescription()
	{
		
		return this.description;
	}

	public boolean isExecutable()
	{
		return this.executable;
	}
	
	public String getExecutor()
	{
		
		return this.executor;
	}
	public	void print()	{
		System.out.print("IID:	"	+	getID());
		System.out.print(",	Display:	"	+	getDisplayName());
		System.out.print(",	"+	getDescription());
		System.out.print(",	"+	isExecutable());
		System.out.println(",	Class:"+	getExecutor());
		
}

public	String	toString()
{			
	 return String.format(	"ID:	%x	Display:	%s,	%s,	%b,	Class:	%s	\n",	getID(),	getDisplayName(),	getDescription(),	isExecutable(),	getExecutor());
}
}
