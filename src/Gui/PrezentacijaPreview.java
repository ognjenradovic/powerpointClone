package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Controller.Akcije;
import Model.PrezentacijaModel;
import Model.SlajdModel;
import observer.Sub;

public class PrezentacijaPreview extends JPanel implements Sub {
	private String ime;
	private String autor;
	private String url;
	private Integer brslajdova=1;
	private JPanel prezentacija=new JPanel();
//	private JPanel prezentacijaPreview=new JPanel();
	private JLabel labelIme=new JLabel();
	private JLabel labelAutor=new JLabel();
	//private List<ImagePanel> slajdovi;
	
	private JScrollPane scrollprezentacija= new JScrollPane(prezentacija,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private PrezentacijaModel Model;
	
	
public PrezentacijaPreview(PrezentacijaModel prezentacijaModel) {
	//JScrollPane scrollPreview= new JScrollPane(prezentacijaPreview,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.Model=prezentacijaModel;
		this.Model.addSub(this);
		prezentacijaModel.addSub(this);
		setLayout(new GridLayout(0, 1));
		//setLayout(new BorderLayout());
		this.ime=prezentacijaModel.getName();
	 	prezentacija.setLayout(new BoxLayout(prezentacija,BoxLayout.Y_AXIS));
		this.url= prezentacijaModel.getUrl().substring(1);
	//	add(prezentacijaPreview, BorderLayout.WEST);
        add(scrollprezentacija, BorderLayout.EAST);
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
public Integer getBrslajdova() {
	return brslajdova;
}
public void setBrslajdova(Integer brslajdova) {
	this.brslajdova = brslajdova;
}
public void emptyPrezentacije() {
	// TODO Auto-generated method stub
	this.prezentacija.removeAll();
	brslajdova=1;
}

public void addPrezentacija(SlajdModel slajdModel) {
	SlajdGui slajdGui = new SlajdGui(slajdModel);
	slajdGui.setPreferredSize(new Dimension(70,45));
	slajdGui.setMaximumSize(new Dimension(130,75));
	this.prezentacija.add(slajdGui);
	JLabel brojLabel=new JLabel(this.brslajdova.toString());
	brojLabel.setFont(new java.awt.Font("Arial",Font.PLAIN, 16));
	brojLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	this.prezentacija.add(brojLabel);
	this.brslajdova++;
	updateUI();
}
@Override
public void update(Object notification) {

}
}