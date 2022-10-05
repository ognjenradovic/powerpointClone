package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import Gui.MainFrame;
import Gui.PrezentacijaGui;
import Gui.ProjekatGui;
import Gui.SlajdGui;
import Model.PrezentacijaModel;
import Model.ProjekatModel;
import Model.RuNode;
import Model.TipSlota;
import Tree.RuTreeNode;
import factory.Factory;

public class OpenAction extends AbstractRudokAction{

	public OpenAction() {
		putValue(SMALL_ICON,loadIcon("images/open.png"));
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
		putValue(NAME,"Open");
		putValue(SHORT_DESCRIPTION,"Open");
		
	}
	  @Override
	    public void actionPerformed(ActionEvent e) {
			JFileChooser jFileChooser = new JFileChooser();
			
            	String[] tipSlota = {"Projekat", "Prezentaciju"};
                String izabraniTip = (String) JOptionPane.showInputDialog(
                        null,
                        "Otvori",
                        "Otvori",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        tipSlota,
                        tipSlota[0]);
                if(izabraniTip.equals("Projekat")) {
        			jFileChooser.setFileFilter(new MyFileFilter());
        			if(jFileChooser.showOpenDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
        				try {
        					ObjectInputStream outputStream = new ObjectInputStream(new FileInputStream(jFileChooser.getSelectedFile()));
        					ProjekatModel projekatModel=null;
        					try {
        						projekatModel = (ProjekatModel) outputStream.readObject();
        					} catch (ClassNotFoundException exception) {
        						// TODO Auto-generated catch block
        						exception.printStackTrace();
        					}
        				   
        				      MainFrame.getInstance().getWorkspaceTree().addChild(new RuTreeNode(projekatModel));
        				      
        				} catch (FileNotFoundException e1) {
        					e1.printStackTrace();
        				} catch (IOException e1) {
        					e1.printStackTrace();
        				} 
        		}
                }
                else {
                	jFileChooser.setFileFilter(new PrezentacijaFileFilter());
        			if(jFileChooser.showOpenDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
        				try {
        					ObjectInputStream outputStream = new ObjectInputStream(new FileInputStream(jFileChooser.getSelectedFile()));
        					PrezentacijaModel prezentacijaModel=null;
        					try {
        						prezentacijaModel = (PrezentacijaModel) outputStream.readObject();
        					} catch (ClassNotFoundException exception) {
        						// TODO Auto-generated catch block
        						exception.printStackTrace();
        					}
        					  Object objekat= MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
        					  RuNode ruNode=MainFrame.getInstance().getShare();
        					  Factory factory=MainFrame.getInstance().getFactory();
        				        if(objekat==null)
        				        	ErrorFactory.getInstance().generateError(ENumError.NEDOSTAJE_IME_AUTOR);
        				        else if(((RuTreeNode)objekat).getNode() instanceof ProjekatModel){
        				        	RuTreeNode selektovani = ((RuTreeNode)objekat);
        				        	selektovani.addChild(new RuTreeNode(prezentacijaModel));	
        							SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
        							MainFrame.getInstance().getJtab().updateUI();
        				        }
        				      
        				} catch (FileNotFoundException e1) {
        					e1.printStackTrace();
        				} catch (IOException e1) {
        					e1.printStackTrace();
        				} 
        				
                }
            

		  }
	    }
}

