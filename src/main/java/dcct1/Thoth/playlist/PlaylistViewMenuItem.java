package dcct1.Thoth.playlist;

import java.util.Scanner;

import dcct1.Thoth.menu.ConsoleControls;
import dcct1.Thoth.menu.IExecuatable;

public class PlaylistViewMenuItem implements IExecuatable {

	Scanner input = new Scanner(System.in);
	 
	public PlaylistViewMenuItem() {}

	
	public void execute() {
		
		System.out.println( ConsoleControls.ANSI_RED_BRIGHT + "... PLAYLIST VIEWER ..." + ConsoleControls.ANSI_RESET);
		System.out.println("\n" + PlaylistViewMenuItem.class.getName() + " has no MVC implementation.");
        System.out.println(" \n Press enter return to the main menu");
		this.input.nextLine();
	}
}

