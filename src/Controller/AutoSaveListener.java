package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import Gui.MainFrame;
import Model.ProjekatModel;
import Model.RuNode;

public class AutoSaveListener extends WindowAdapter implements WindowListener {
	@Override
    public void windowClosing(WindowEvent we)
    { 
    	boolean warning=false;
		for(RuNode ruNode:MainFrame.getInstance().getWorkspaceModel().getChildren()) {
			if(((ProjekatModel)ruNode).isChanged()) {
				warning=true;
				break;
			}
		}
		if(warning) {
			String ObjButtons[] = {"Da","Ne"};
	        int PromptResult = JOptionPane.showOptionDialog(null,"Niste sacuvali sve projekte,da li ste sigurni da zelite da izadjete?","Izlazak",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
	        if(PromptResult==JOptionPane.YES_OPTION)System.exit(0);
		}
		else {
			 PrintWriter writer1 =null;      
	         try {
				writer1 = new PrintWriter(new File((this.getClass().getProtectionDomain().getCodeSource().getLocation()+"workspace.txt").substring(5)));
			} catch (FileNotFoundException e) {		
				System.out.println("Failed");
			e.printStackTrace();
			}  
	          for(RuNode ruNode:MainFrame.getInstance().getWorkspaceModel().getChildren()) {
	        	  ProjekatModel projekatModel=(ProjekatModel)ruNode;
	        		System.out.println(projekatModel);
	        		System.out.println(projekatModel.getProjekatFile());
	        	  if(projekatModel.getProjekatFile()!=null)  writer1.println(projekatModel.getProjekatFile().toString());         	
	          }                                           
	         writer1.flush();  
	         writer1.close();  
			System.exit(0);
			
		}
        
    }
}

