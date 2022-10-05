package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;

import Gui.MainFrame;
import Model.PrezentacijaModel;
import Model.ProjekatModel;
import Model.RuNode;
import Tree.RuTreeNode;

public class SaveAction extends AbstractRudokAction{

	public SaveAction() {
		putValue(SMALL_ICON,loadIcon("images/save.png"));
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		putValue(NAME,"Save");
		putValue(SHORT_DESCRIPTION,"Save");
		
	}
	  @Override
	    public void actionPerformed(ActionEvent e) {


			
	        Object objekat= MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
	        
	        if(objekat instanceof RuTreeNode) {
	        	RuTreeNode ruTreeNode=(RuTreeNode)objekat;
	        	
	        	if(ruTreeNode.getNode() instanceof ProjekatModel) {
	    			JFileChooser jFileChooser = new JFileChooser();
	        		jFileChooser.setFileFilter(new MyFileFilter());
	        			ProjekatModel projekat=(ProjekatModel)ruTreeNode.getNode();
	        			File projekatFile=projekat.getProjekatFile();
	        			if (!projekat.isChanged()){
	        				return;
	        			}
	        			
	        			if (projekat.getProjekatFile()==null){
	        				if(jFileChooser.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
	        					projekatFile=new File(jFileChooser.getSelectedFile()+".rudok"); 
	        					
	        			}
	        				else  	 
	        			{
	        				return; 
	        			}         
	        			}     
	        			ObjectOutputStream outputStream;
	        			try {
	        				outputStream = new ObjectOutputStream(new FileOutputStream(projekatFile));
	        				outputStream.writeObject(projekat);
	        				projekat.setProjekatFile(projekatFile);
	        				projekat.setChanged(false);
	        			} catch (FileNotFoundException exception) {
	        				exception.printStackTrace();
	        			} catch (IOException exception2) {
	        				exception2.printStackTrace();
	        			}
	        	}
	        	else if(ruTreeNode.getNode() instanceof PrezentacijaModel) {
	        		JFileChooser jFileChooser = new JFileChooser();
	        		jFileChooser.setFileFilter(new PrezentacijaFileFilter());
        			PrezentacijaModel prezentacija=(PrezentacijaModel)ruTreeNode.getNode();
        			File prezentacijaFile=prezentacija.getPrezentacijaFile();
        			if (!prezentacija.isChanged()){
        				return;
        			}
        			
        			if (prezentacija.getPrezentacijaFile()==null){
        				if(jFileChooser.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
        					prezentacijaFile=new File(jFileChooser.getSelectedFile()+".prezentacija"); 
        					
        			}
        				else  	 
        			{
        				return; 
        			}         
        			}     
        			ObjectOutputStream outputStream;
        			try {
        				outputStream = new ObjectOutputStream(new FileOutputStream(prezentacijaFile));
        				outputStream.writeObject(prezentacija);
        				prezentacija.setPrezentacijaFile(prezentacijaFile);
        				prezentacija.setChanged(false);
        			} catch (FileNotFoundException exception) {
        				exception.printStackTrace();
        			} catch (IOException exception2) {
        				exception2.printStackTrace();
        			}
        	}
	        }		
	    }


}
