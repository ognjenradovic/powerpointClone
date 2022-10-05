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




public class ShareToAction extends AbstractRudokAction{

	public ShareToAction() {
		putValue(SMALL_ICON,loadIcon("images/shareto.png"));
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		putValue(NAME,"Share To");
		putValue(SHORT_DESCRIPTION,"Share To");
	}
	  @Override
	    public void actionPerformed(ActionEvent e) {
	       
		  Object objekat= MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();

		  RuNode ruNode=MainFrame.getInstance().getShare();
		  Factory factory=MainFrame.getInstance().getFactory();
	        if(objekat==null)
	        	ErrorFactory.getInstance().generateError(ENumError.NEDOSTAJE_IME_AUTOR);
	        else if(((RuTreeNode)objekat).getNode() instanceof ProjekatModel){
	        	RuTreeNode selektovani = ((RuTreeNode)objekat);
	        	RuTreeNode novi=new RuTreeNode(ruNode); 
	        	MainFrame.getInstance().getCommandManager().addCommand(new AddCommand(novi,ruNode,selektovani));
	  		  this.setEnabled(false);
			  MainFrame.getInstance().getActionManager().getShareAction().setEnabled(true);
				SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
				MainFrame.getInstance().getJtab().updateUI();
              
	        }
	        
	    }
}


