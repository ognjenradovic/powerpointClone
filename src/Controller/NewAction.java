package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
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




public class NewAction extends AbstractRudokAction{

	public NewAction() {
		putValue(SMALL_ICON,loadIcon("images/add.png"));
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		putValue(NAME,"New");
		putValue(SHORT_DESCRIPTION,"New");
	}
	  @Override
	    public void actionPerformed(ActionEvent e) {
	        Object objekat= MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
	        
	        if(objekat==null)
	        	ErrorFactory.getInstance().generateError(ENumError.NEDOSTAJE_IME_AUTOR);
	        else if(objekat instanceof RuTreeNode){
	        	RuNode selektovani = ((RuTreeNode)objekat).getNode();
	        	Factory factory=MainFrame.getInstance().getFactory();
	        	RuNodeFactory ruNodeFactory=factory.createFactory(selektovani);
	        	RuNode ruNode=ruNodeFactory.getRuNode(selektovani);
	        	RuTreeNode novi=new RuTreeNode(ruNode);
	        	//((RuTreeNode)objekat).addChild(novi);
				MainFrame.getInstance().getCommandManager().addCommand(new AddCommand(novi,ruNode));
				SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
                MainFrame.getInstance().getJtab().updateUI();
	        }
	        
	    }

}
