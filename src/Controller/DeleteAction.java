package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import Commands.AddCommand;
import Commands.RemoveCommand;
import Gui.MainFrame;
import Gui.PrezentacijaGui;
import Model.PrezentacijaModel;
import Model.ProjekatModel;
import Model.RuNode;
import Model.RuNodeComposite;
import Model.SlajdModel;
import Model.WorkspaceModel;
import Tree.RuTreeNode;



public class DeleteAction extends AbstractRudokAction{

	public DeleteAction() {
		putValue(SMALL_ICON,loadIcon("images/delete.png"));
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		//putValue(SMALL_ICON,loadIcon("images/add.png"));
		putValue(NAME,"Delete");
		putValue(SHORT_DESCRIPTION,"Delete");
	}
	  @Override
	    public void actionPerformed(ActionEvent e) {
      		RuTreeNode objekat= (RuTreeNode) MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
	        if(objekat!=null) {
			        RuNodeComposite parent=(RuNodeComposite) objekat.getNode().getParent();
		    		MainFrame.getInstance().getCommandManager().addCommand(new RemoveCommand(objekat));
		        	 SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
		        	 MainFrame.getInstance().getJtab().updateUI();
		  
		        }else {
			        	ErrorFactory.getInstance().generateError(ENumError.NEDOSTAJE_IME_AUTOR);
		        }
	    }

}
