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

public class PrezentacijaMainView extends JPanel {
	private String ime;
	private String autor;
	private String url;
	private Integer brslajdova=1;
	private JPanel prezentacija=new JPanel();
	private JLabel labelIme=new JLabel();
	private JLabel labelAutor=new JLabel();
	
	private JScrollPane scrollprezentacija= new JScrollPane(prezentacija,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private PrezentacijaModel Model;
	
	
public PrezentacijaMainView(PrezentacijaModel prezentacijaModel) {
	
		this.Model=prezentacijaModel;
		setLayout(new BorderLayout());
		this.ime=prezentacijaModel.getName();
	 	prezentacija.setLayout(new BoxLayout(prezentacija,BoxLayout.Y_AXIS));
		labelIme.setText(prezentacijaModel.getName());
		labelAutor.setText(prezentacijaModel.getAutor());
		this.url= prezentacijaModel.getUrl().substring(1);
		labelIme.setFont(new java.awt.Font("Arial", Font.BOLD, 25));
		labelAutor.setFont(new java.awt.Font("Arial", Font.PLAIN, 18));
		labelIme.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelAutor.setAlignmentX(Component.CENTER_ALIGNMENT);
		prezentacija.add(labelIme);
	//	prezentacija.setBackground(Color.GRAY);
		prezentacija.add(labelAutor);
        add(scrollprezentacija, BorderLayout.CENTER);
        
        
  
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
	this.prezentacija.removeAll();
	brslajdova=1;
	labelIme.setText(Model.getName());
	labelAutor.setText(Model.getAutor());
	prezentacija.add(labelIme);
	prezentacija.add(labelAutor);
}
public void addPrezentacija(SlajdModel slajdModel) {
	SlajdGui slajdGui = new SlajdGui(slajdModel);
	int width=this.getParent().getWidth();
	slajdGui.setPreferredSize(new Dimension(450,360));
	slajdGui.setMaximumSize(new Dimension(950,700));
	this.prezentacija.add(slajdGui);
	JLabel brojLabel=new JLabel(this.brslajdova.toString());
	brojLabel.setFont(new java.awt.Font("Arial", Font.PLAIN, 20));
	brojLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	this.prezentacija.add(brojLabel);
	this.brslajdova++;
	updateUI();
}
public JPanel getPrezentacija() {
	return prezentacija;
}
public void setPrezentacija(JPanel prezentacija) {
	this.prezentacija = prezentacija;
}

}
