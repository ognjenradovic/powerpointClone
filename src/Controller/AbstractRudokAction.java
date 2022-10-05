package Controller;



import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public abstract class AbstractRudokAction extends AbstractAction {
public Icon loadIcon(String fileName) {
	URL imageURL=getClass().getResource(fileName);
	Icon icon=null;
	
	if(imageURL != null) {
		icon= new ImageIcon(imageURL);
	}
	else {
		System.out.println("Resource not found " + fileName);
	}
	return icon;
	
	
}
}