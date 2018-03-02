package dcct1.Thoth.menu;

import	java.io.IOException;
import	java.util.ArrayList;
import	java.util.HashMap;
import	java.util.Iterator;
import	java.util.Map;
import	java.util.Scanner;
/*****************************************************************
*
*	 Date:	2018
*	 @author	Declan
*	
*****************************************************************/
public	class Menu extends MenuWidget {
	
	ArrayList<MenuWidget>	menu	=	new	ArrayList<MenuWidget>();
	
	String	name;
	String	description;
	
	int	selection;
	Scanner	input	=	new	Scanner(System.in);
	
	
	Factory	f	=	Factory.getFactory();
	
	
	MenuItemFactory	executorFactory	=	new	MenuItemFactory();
				
	

	public	Menu(String	name,	String	description)	{
					this.name	=	name;
					this.description	=	description;
	}
	
	
	public	void	add(MenuWidget	menuWidget)	{
					this.menu.add(menuWidget);
	}
	public	void	remove(MenuWidget	menuWidget)	{
					this.menu.remove(menuWidget);
	}
	public	MenuWidget	getChild(int	i)	{
					return	(MenuWidget)	this.menu.get(i);
	}
	public	String	getDisplayName()	{
					return this.name;
	}
	public	String	getDescription()	{
					return this.description;
	}
	
	public	void	display()
	{
				
		ConsoleControls.clearConsole();
			
		int	exitMenu	=	0;
		
		IExecuatable	exe;
					
		
		do	{
									
		
			Map<	Integer,	String>	menuOfExecutors	=	new	HashMap<	Integer,	String	>();
									
			
			Iterator<MenuWidget>	iterator	=	this.menu.iterator();
									
			
			while	(iterator.hasNext())	
			
			{
			
				MenuWidget	menuWidget	=	(MenuWidget)iterator.next();
													
				
				if(	Menu.class.isInstance(menuWidget))
				
				{
				
					System.out.println(menuWidget.getDisplayName());
					
				}
				
				else //(	MenuHeading.class.isInstance(menuWidget))
				
				{
				
					System.out.println("--------------------------------");
					
					System.out.println(menuWidget.getDisplayName());
					
					System.out.println("--------------------------------");
					
					menuWidget.display();
					
					menuOfExecutors.putAll(menuWidget.getExecutorList());
					
				}
													
				
			}
									
			
			System.out.println("\nEnter	0	to	exit	or	a	menu	number	to	select	that	function	-->	");
			
			this.selection	=	this.input.nextInt();
									
			
			ConsoleControls.clearConsole();
									
			
			if(		this.selection	==	0)
			
			{
			
				exitMenu	=	1;
				
			}
			
			else if(	menuOfExecutors.containsKey(this.selection))
			
			{
			
				if(menuOfExecutors.get(this.selection).equalsIgnoreCase("undefinedMenuItem"))
				
				{
				
					System.out.println(	ConsoleControls.ANSI_YELLOW	+	"picked	:	"	+	menuOfExecutors.get(this.selection)	+	ConsoleControls.ANSI_RESET);
					
				}
				
				else
				
				{
				
					ConsoleControls.clearConsole();
																	
					
					
												
					/*
					
						try										
						{
						
																					
						Object	obj		=	f.getObject(		menuOfExecutors.get(this.selection)	)
							exe	=	(IExecuatable)	obj;
						e.execute();
							}
						catch	(	FactoryException	fe)
						{
					System.out.println(ConsoleControls.ANSI_RED	+"Failed	to	create	instance	:	"	+	menuOfExecutors.get(this.selection)	+	Console
						Controls.ANSI_RESET);
						}
								*/
																
						//	Factory	Method	Pattern	version
				
					executorFactory.getMenuItem(menuOfExecutors.get(this.selection)).execute();
																	
					
				}
				
			}
			
			else
			
			{
			
				System.out.println(	ConsoleControls.ANSI_RED	+	"	>>	Invalid	option"	+	ConsoleControls.ANSI_RESET);
				
			}
					
			
		}
		
		while	(	exitMenu	==	0);
					
					
	}
	
		public	void print()	
	
		{
	
		
			System.out.println("\nMENU");
			
			System.out.println(getDisplayName());
			
			System.out.print(getDescription());

			
			Iterator<MenuWidget>	iterator	=	this.menu.iterator();
			
			while	(iterator.hasNext())	{
			
				MenuWidget	menuWidget	=	
				

						(MenuWidget)iterator.next();
						
				menuWidget.print();
				
			}
					
	
		}
	

		public	String	toString()	{			
		 	
		
			StringBuffer	sb	=	new StringBuffer("\nMENU	:	"	+	getDisplayName()	+	"\n");
		 	
			
			Iterator<MenuWidget>	iterator	=	this.menu.iterator();
					
			
			while	(iterator.hasNext())	{
			
				MenuWidget	menuWidget	=	(MenuWidget)iterator.next();
				
				sb.append(menuWidget.toString());	 	
				
			}
					
			
			return	sb.toString();
					
	
		}	
	

}
