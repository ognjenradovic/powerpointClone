package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import Gui.MainFrame;
import Gui.PrezentacijaGui;
import Gui.ProjekatGui;
import Gui.SlajdGui;

public class UndoAction extends AbstractRudokAction{

	public UndoAction() {
		putValue(SMALL_ICON,loadIcon("images/undo.png"));
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK));
		putValue(NAME,"");
		putValue(SHORT_DESCRIPTION,"Undo");
		
	}
	  @Override
	    public void actionPerformed(ActionEvent e) {
			  MainFrame.getInstance().getCommandManager().undoCommand();
	    }

}
