package Gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Controller.Akcije;
import Model.PrezentacijaModel;
import Model.ProjekatModel;
import Model.RuNode;
import Model.SlajdModel;
import Model.WorkspaceModel;
import Tree.RuTreeNode;
import observer.Sub;

public class ProjekatGui extends JPanel implements Sub  {
	//private String ime;
	private JPanel prezentacija=new JPanel();
	private ProjekatModel model;
    private List<PrezentacijaGui> prezentacije= new ArrayList<PrezentacijaGui>();
    private List<RuNode> modeli = new ArrayList<RuNode>();
	private JTabbedPane jtab;
	
	public JTabbedPane getJtab() {
		return jtab;
	}

	public void setJtab(JTabbedPane jtab) {
		this.jtab = jtab;
	}

	public ProjekatGui(ProjekatModel projekatModel) {
		this.model=projekatModel;
		this.setPreferredSize(new Dimension(600,600));
		model.addSub(this);
		this.model.addSub(this);
		this.setLayout(new BoxLayout(this,1));
		jtab= new JTabbedPane();
        add(jtab);
	}
	
	public void refresh(ProjekatModel projekatModel) {
		for(RuNode prosledjeni:projekatModel.getChildren()) {
			PrezentacijaGui prezentacijaGui = new PrezentacijaGui((PrezentacijaModel)prosledjeni);
			prezentacijaGui.refresh((PrezentacijaModel)prosledjeni);
			prezentacije.add(prezentacijaGui);
			String path=(prezentacijaGui.getIme());
			jtab.addTab(path, prezentacijaGui);
			prezentacije.add(prezentacijaGui);
		}
		this.updateUI();
	}
	
	@Override
	public void update(Object notification) throws ArrayIndexOutOfBoundsException  {
		Object selektovani= MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		if(selektovani!=null) {
		RuNode ruNode=((RuTreeNode)selektovani).getNode();
		ruNode.addSub(this);
		if(ruNode!=null) {
			if(ruNode instanceof ProjekatModel) {
				jtab.removeAll();
				
				ProjekatModel projekatModel=(ProjekatModel)ruNode;
				for(RuNode prosledjeni:projekatModel.getChildren()) {
					PrezentacijaGui prezentacijaGui = new PrezentacijaGui((PrezentacijaModel)prosledjeni);
					prezentacijaGui.refresh((PrezentacijaModel)prosledjeni);
					prezentacije.add(prezentacijaGui);
					String path=(prezentacijaGui.getIme());
					jtab.addTab(path, prezentacijaGui);
					prezentacije.add(prezentacijaGui);
				}
				modeli.add(ruNode);
				this.updateUI();
			}
		}
		}
	}
	}


