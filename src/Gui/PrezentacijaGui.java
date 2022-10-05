package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import Commands.CommandManager;
import Controller.Akcije;
import Model.PrezentacijaModel;
import Model.ProjekatModel;
import Model.RuNode;
import Model.SlajdModel;
import Tree.RuTreeNode;
import observer.Sub;

public class PrezentacijaGui extends JPanel implements Sub {
	private String ime;
	private String autor;
	private String url;
	private JPanel prezentacija=new JPanel();
//	private JPanel prezentacijaPreview=new JPanel();
	private JLabel labelIme=new JLabel();
	private PrezentacijaPreview preview;
	private PrezentacijaMainView mainView;
	private CommandManager commandManager;
	
	public PrezentacijaMainView getMainView() {
		return mainView;
	}
	public void setMainView(PrezentacijaMainView mainView) {
		this.mainView = mainView;
	}
	public CommandManager getCommandManager() {
		return commandManager;
	}
	public void setCommandManager(CommandManager commandManager) {
		this.commandManager = commandManager;
	}
	private JLabel labelAutor=new JLabel();
	//private List<ImagePanel> slajdovi;
	
	private JScrollPane scrollprezentacija= new JScrollPane(prezentacija,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private PrezentacijaModel Model;
	 
	
public PrezentacijaGui(PrezentacijaModel prezentacijaModel) {
	SlotToolbar toolbar=new SlotToolbar();
	commandManager=new CommandManager();
	//setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	setLayout(new BorderLayout());
	add(toolbar,BorderLayout.NORTH);
	this.Model=prezentacijaModel;
	this.Model.addSub(this);
	prezentacijaModel.addSub(this);
	this.ime=prezentacijaModel.getName();
	this.url= prezentacijaModel.getUrl();
	this.preview=new PrezentacijaPreview(prezentacijaModel);
	this.mainView=new PrezentacijaMainView(prezentacijaModel);
	JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,preview,mainView);
	split.setDividerLocation(150);
	add(split,BorderLayout.CENTER);
}
public String getIme() {
	return ime;
}
public PrezentacijaModel getModel() {
	return Model;
}
public void setModel(PrezentacijaModel model) {
	Model = model;
}
public void setIme(String ime) {
	this.ime = ime;
}
public void refresh(PrezentacijaModel prezentacijaModel) {
		for(RuNode prosledjeni:prezentacijaModel.getChildren()) {
			SlajdModel slajdModel=(SlajdModel)prosledjeni;
			preview.addPrezentacija(slajdModel);
			mainView.addPrezentacija(slajdModel);
		}
		this.updateUI();
	}
@Override
public void update(Object notification) {
	if(MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent()!=null) {
		Object selektovani= MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		RuNode ruNode=((RuTreeNode)selektovani).getNode();
		if(ruNode instanceof PrezentacijaModel || ruNode instanceof SlajdModel) {
			PrezentacijaModel prezentacijaModel;
			if(ruNode instanceof SlajdModel) {
				prezentacijaModel=(PrezentacijaModel) ((SlajdModel)ruNode).getParent();
			}
			else {
				prezentacijaModel=(PrezentacijaModel)ruNode;
			}
			mainView.emptyPrezentacije();
			preview.emptyPrezentacije();
			for(RuNode prosledjeni:prezentacijaModel.getChildren()) {
				SlajdModel slajdModel=(SlajdModel)prosledjeni;
				preview.addPrezentacija(slajdModel);
				mainView.addPrezentacija(slajdModel);
			}
			this.updateUI();
		}
	}
	
	updateUI();
}

}
