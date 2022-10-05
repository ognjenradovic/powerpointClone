package Gui;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar {
	public Toolbar() {
		JButton New=new JButton(MainFrame.getInstance().getActionManager().getNewProjectAction());
		JButton info = new JButton(MainFrame.getInstance().getActionManager().getInfoAction());
		JButton edit=new JButton(MainFrame.getInstance().getActionManager().getEditAction());
		JButton delete=new JButton(MainFrame.getInstance().getActionManager().getDeleteAction());
		JButton slideshow=new JButton(MainFrame.getInstance().getActionManager().getSlideshow());
		JButton undo=new JButton(MainFrame.getInstance().getActionManager().getUndoAction());
		JButton redo=new JButton(MainFrame.getInstance().getActionManager().getRedoAction());
		JButton save=new JButton(MainFrame.getInstance().getActionManager().getSaveAction());
		JButton saveAs=new JButton(MainFrame.getInstance().getActionManager().getSaveAsAction());
		JButton open=new JButton(MainFrame.getInstance().getActionManager().getOpenAction());
		JButton share=new JButton(MainFrame.getInstance().getActionManager().getShareAction());
		JButton shareTo=new JButton(MainFrame.getInstance().getActionManager().getShareToAction());
		Toolkit kit=Toolkit.getDefaultToolkit();
		add(New);
		add(delete);
		add(edit);
		add(share);
		add(shareTo);
		addSeparator();
		add(open);
		add(save);
		add(saveAs);
		add(slideshow);
		addSeparator();
		add(undo);
		add(redo);
		addSeparator();
		add(info);
		this.setFloatable(false);
	}
}
