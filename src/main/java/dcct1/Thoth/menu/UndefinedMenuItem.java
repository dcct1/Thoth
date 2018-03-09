package dcct1.Thoth.menu;

/**
 * Date March 2018
 * Author DCCT1
 * Lab code copied in here
 */

import	java.util.Scanner;
public class UndefinedMenuItem implements IExecuatable	
{
				
	
	
	Scanner	input	=	new	Scanner(System.in);
				
	public	UndefinedMenuItem(){}
				
	
	public void	execute()	{	 	
						
		System.out.println("The	class " + UndefinedMenuItem.class.getName()	+	" is a placeholder menu item.");
		
		System.out.println("\n	Press enter return to the main menu");
		
		this.input.nextLine();
							}
}