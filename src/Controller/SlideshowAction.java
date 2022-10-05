package Controller;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import Gui.MainFrame;
import Model.PrezentacijaModel;
import Model.ProjekatModel;
import Model.RuNode;
import Model.RuNodeComposite;
import Model.SlajdModel;
import Model.WorkspaceModel;
import State.EditState;
import Tree.RuTreeNode;




public class SlideshowAction extends AbstractRudokAction{

	public SlideshowAction() {
		putValue(SMALL_ICON,loadIcon("images/slideshow.png"));
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		putValue(NAME,"Change mode");
		putValue(SHORT_DESCRIPTION,"Change mode");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent()!=null) {
			RuTreeNode ruTreeNode= (RuTreeNode)(MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent());
			RuNode ruNode=ruTreeNode.getNode();
			if( ruNode instanceof PrezentacijaModel) {
				if(MainFrame.getInstance().getStateManager().getCurrent() instanceof EditState) {
					MainFrame.getInstance().getStateManager().setSlideshowState();
					MainFrame.getInstance().getStateManager().getCurrent().Slideshow((PrezentacijaModel)ruNode);
				}
				else {
					MainFrame.getInstance().getStateManager().setEditState();
					MainFrame.getInstance().getStateManager().getCurrent().Slideshow((PrezentacijaModel)ruNode);
				}
				
				
			}
			else {
				ErrorFactory.getInstance().generateError(ENumError.NIJE_SELEKTOVANA_PREZENTACIJA);
			}
		}
	}

	 
}
