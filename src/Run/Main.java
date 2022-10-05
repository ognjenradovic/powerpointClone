package Run;

import Gui.MainFrame;
import observer.Sub;

//implements sub
public class Main {

	public static void main(String[] args) {
		MainFrame mainFrame=MainFrame.getInstance();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true); 
	}

}
