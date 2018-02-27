package dcct1.Thoth.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Feb 2018
 *  @author Declan
 *	ref CCT Softwrae Dev lab 06 code 
 */

public class MenuHeading extends MenuWidget {

		ArrayList<MenuWidget> menu = new ArrayList<MenuWidget>();
		
		
		String name;
		String description;
		int headingID;
		
		
		//constructors
		
		public MenuHeading(int id, String name , String description) {
			
			this.headingID =id;
			this.name = name;
			this.description = description;
		}
		
		//methods
		
		public void add(MenuWidget menuWidget) {
			
			this.menu.add(menuWidget);
		}
		
		public void remove(MenuWidget menuWidget) {
			
			this.menu.remove(menuWidget);
		}
		
		public MenuWidget getChild(int i) {
			
			return (MenuWidget) this.menu.get(i);
		}
		
		public int getID() {
			
			return this.headingID;
		}
		
		public String getDescription() {
			
			return this.description;
		}
		
		public Map<Integer, String> getExecutorList()
		{
			Map<Integer, String> menuOfExecutors = new HashMap<Integer, String>();
			
			
			Iterator<MenuWidget> iterator = this.menu.iterator();
			
			int headerNumber = this.headingID * 10;
		
		
		while(iterator.hasNext())
		{
			MenuWidget menuWidget = (MenuWidget)iterator.next();
		
			menuOfExecutors.put((headerNumber + menuWidget.getID()), menuWidget.getExecutor());
		}
		
		return menuOfExecutors;
		
		}
		
		
		public void display()
		{
			
			Iterator<MenuWidget> iterator = this.menu.iterator();
			
			int headerNumber = this.headingID * 10;
			
			
			while (iterator.hasNext())
			{
				
				MenuWidget menuWidget = (MenuWidget)iterator.next();
				
				System.out.println((headerNumber + menuWidget.getID()) +".   " + menuWidget.getDisplayName());
				
				
			}
			
		}
		
	public void print ()
	{
		
		System.out.println("\n--------------------------------");
		System.out.print("HID: " + getID());
		System.out.print(",  Display: " + getDisplayName());
		System.out.println(",  " + getDescription());
		System.out.println("--------------------------------");
		
		
		Iterator<MenuWidget> iterator = this.menu.iterator();
		
		while(iterator.hasNext()) {
			
			MenuWidget menuWidget = (MenuWidget)iterator.next();
			menuWidget.print();
			
			
		}	
		
	}
	
	public String toString()
	{
		
		StringBuffer sb = new StringBuffer(String.format("HEADING: %x %s, %s \n ", getID(), getDisplayName(), getDescription()));
		
		Iterator<MenuWidget> iterator = this.menu.iterator();
		
		
		while(iterator.hasNext())
		{
			MenuWidget menuWidget = (MenuWidget)iterator.next();
			
			sb.append(menuWidget.toString());
		}
		
		return sb.toString();
	}
	
	
}
