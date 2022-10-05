package Tree;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTabbedPane;

import Gui.MainFrame;
import Gui.PrezentacijaGui;
import Gui.ProjekatGui;
import Model.PrezentacijaModel;
import Model.ProjekatModel;
import Model.RuNode;

public class TreeMouseListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
			if (e.getClickCount()==2){
				Object objekat= MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
				if(objekat instanceof RuTreeNode){
		        	RuNode selektovani = ((RuTreeNode)objekat).getNode();
		        	if(selektovani instanceof ProjekatModel) {
		        		MainFrame.getInstance().getJtab().setSelectedIndex(MainFrame.getInstance().getJtab().indexOfTab(((ProjekatModel) selektovani).getName()));
					}
		        	if(selektovani instanceof PrezentacijaModel) {		
		        		MainFrame.getInstance().getJtab().setSelectedIndex(MainFrame.getInstance().getJtab().indexOfTab(((ProjekatModel) (selektovani.getParent())).getName()));
					}
				}
			}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
