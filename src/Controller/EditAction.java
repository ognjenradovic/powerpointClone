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

import Commands.EditCommand;
import Commands.RemoveCommand;
import Gui.MainFrame;
import Gui.PrezentacijaGui;
import Model.PrezentacijaModel;
import Model.ProjekatModel;
import Model.RuNode;
import Model.SlajdModel;
import Model.WorkspaceModel;
import Tree.RuTreeNode;



public class EditAction extends AbstractRudokAction{

	public EditAction() {
		putValue(SMALL_ICON,loadIcon("images/edit.png"));
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		putValue(NAME,"Edit");
		putValue(SHORT_DESCRIPTION,"Edit");
	}
	  @Override
	    public void actionPerformed(ActionEvent e) {
     RuTreeNode objekat= (RuTreeNode) MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
     RuNode selektovani = objekat.getNode();
	        if(selektovani instanceof PrezentacijaModel){
	        	String ime = JOptionPane.showInputDialog(null, "Promeni ime prezentacije");
	        	String autor = JOptionPane.showInputDialog(null, "Promeni autora");
	        	if(ime=="" || autor=="") {
            		ErrorFactory.getInstance().generateError(ENumError.NEDOSTAJE_IME_AUTOR);
            		return;
            	}
	        	MainFrame.getInstance().getCommandManager().addCommand(new EditCommand(selektovani,ime,autor));
	        }
	        else {
	        	String ime = JOptionPane.showInputDialog(null, "Promeni ime");
            	if(ime=="") {
            		ErrorFactory.getInstance().generateError(ENumError.NEDOSTAJE_IME_AUTOR);
            		return;
            	}
            	MainFrame.getInstance().getCommandManager().addCommand(new EditCommand(selektovani,ime,""));
	        	
	        }
           SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
	    }

}
