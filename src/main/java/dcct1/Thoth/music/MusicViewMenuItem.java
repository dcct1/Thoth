package dcct1.Thoth.music;

import java.util.Scanner;

import dcct1.Thoth.menu.ConsoleControls;
import dcct1.Thoth.menu.IExecuatable;

public class MusicViewMenuItem implements IExecuatable {

	Scanner input = new Scanner(System.in);
	 
	public MusicViewMenuItem() {}

	public void execute() {
		
		System.out.println( ConsoleControls.ANSI_YELLOW_BRIGHT + "... MUSIC VIEWER ..." + ConsoleControls.ANSI_RESET);
		System.out.println("\n"+ MusicViewMenuItem.class.getName() + " has no MVC implementation.");
        System.out.println(" \n Press enter return to the main menu");
		this.input.nextLine();
	}

}
