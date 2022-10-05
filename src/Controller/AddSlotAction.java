package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import Gui.MainFrame;
import Model.RuNodeComposite;
import Tree.RuTreeNode;

public class AddSlotAction extends AbstractRudokAction{

	public AddSlotAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON,loadIcon("images/addslot.png"));
		putValue(SHORT_DESCRIPTION,"Add slot");
	}
	  @Override
	    public void actionPerformed(ActionEvent e) {
		  MainFrame.getInstance().slotStateManager.setAddState();
	  System.out.println();
	  }
	  
	  

}
