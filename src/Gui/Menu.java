package Gui;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar {
	public Menu (){
		
		JMenu file=new JMenu("File");
		JMenuItem New=new JMenuItem(MainFrame.getInstance().getActionManager().getNewProjectAction());
		JMenuItem info=new JMenuItem(MainFrame.getInstance().getActionManager().getInfoAction());
		JMenuItem edit=new JMenuItem(MainFrame.getInstance().getActionManager().getEditAction());
		JMenuItem delete=new JMenuItem(MainFrame.getInstance().getActionManager().getDeleteAction());
		JMenuItem save=new JMenuItem(MainFrame.getInstance().getActionManager().getSaveAction());
		JMenuItem saveAs=new JMenuItem(MainFrame.getInstance().getActionManager().getSaveAsAction());
		add(file);
		file.add(New);
		file.addSeparator();
		file.add(delete);
		file.addSeparator();
		file.add(save);
		file.addSeparator();
		file.add(saveAs);
		file.addSeparator();
		file.add(save);
		add(file);
		
	}
	
}

