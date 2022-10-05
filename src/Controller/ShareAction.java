package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import Commands.AddCommand;
import Gui.MainFrame;
import Model.PrezentacijaModel;
import Model.ProjekatModel;
import Model.RuNode;
import Model.RuNodeComposite;
import Model.SlajdModel;
import Model.WorkspaceModel;
import Tree.RuTreeNode;
import factory.Factory;
import factory.RuNodeFactory;




public class ShareAction extends AbstractRudokAction{

	public ShareAction() {
		putValue(SMALL_ICON,loadIcon("images/share.png"));
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		putValue(NAME,"Share");
		putValue(SHORT_DESCRIPTION,"Share");
	}
	  @Override
	    public void actionPerformed(ActionEvent e) {
		   Object objekat= MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
	        
	        if(objekat==null)
	        	ErrorFactory.getInstance().generateError(ENumError.NEDOSTAJE_IME_AUTOR);
	        else if(((RuTreeNode)objekat).getNode() instanceof PrezentacijaModel){
	        	RuNode selektovani = ((RuTreeNode)objekat).getNode();
	        	MainFrame.getInstance().setShare((PrezentacijaModel)selektovani);
	        	MainFrame.getInstance().setShareParent((RuTreeNode)objekat);
                MainFrame.getInstance().getJtab().updateUI();
		  JOptionPane.showMessageDialog(null, "Izaberi objekat u koji želiš da šeruješ");
		  this.setEnabled(false);
		  MainFrame.getInstance().getActionManager().getShareToAction().setEnabled(true);  
	        }        
	    }
}


