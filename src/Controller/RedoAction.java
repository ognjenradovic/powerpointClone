package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import Gui.MainFrame;
import Gui.ProjekatGui;
import Gui.SlajdGui;

public class RedoAction extends AbstractRudokAction{

	public RedoAction() {
		putValue(SMALL_ICON,loadIcon("images/redo.png"));
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
		putValue(NAME,"");
		putValue(SHORT_DESCRIPTION,"Redo");
		
	}
	  @Override
	    public void actionPerformed(ActionEvent e) {
		  MainFrame.getInstance().getCommandManager().doCommand();
		  }
	    }

