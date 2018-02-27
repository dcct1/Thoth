package dcct1.Thoth.menu;

import java.util.Map;


public abstract class MenuWidget {
	
	public void add(MenuWidget menuComponent) {
		
		throw new UnsupportedOperationException();
		
	}

		public void remove(MenuWidget menuComponent) {
			
			throw new UnsupportedOperationException();
		}
		
		public MenuWidget getChild(int i) {
			
			throw new UnsupportedOperationException();
		}
		
		public int getID() {
			
			throw new UnsupportedOperationException();
		}
		
		public String getDisplayName() {
			
			throw new UnsupportedOperationException();
		}
		
		public String getDescription() {
			
			throw new UnsupportedOperationException();
		}
		
		public boolean isEcxecutable() {
			
			throw new UnsupportedOperationException();
		}
		
		public String getExecutor() {
			
			throw new UnsupportedOperationException();
		}
		
		public Map<Integer, String> getExecutorList(){
			
			throw new UnsupportedOperationException();
		}
		
		
		public void display () {
			
			throw new UnsupportedOperationException();
		}
		
		public void print() {
			
			throw new UnsupportedOperationException();
		}
}
