package Model;

import java.awt.List;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import Controller.Akcije;
import Gui.MainFrame;
import Gui.PrezentacijaGui;
import Gui.PrezentacijaMainView;
import observer.Sub;

public class PrezentacijaModel extends RuNodeComposite implements Serializable{


	private String autor;
    private String staroime;
    private String url;
	private transient boolean changed; 
	private File prezentacijaFile;
	private ArrayList<PrezentacijaModel> klonovi;


	public PrezentacijaModel(String name, RuNode parent, String autor, String staroime, String url) {
		super(name, parent);
		this.autor = autor;
		this.staroime = staroime;
		this.changed=true;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public PrezentacijaModel(String name, RuNode parent) {
        super(name, parent);
        this.autor = "Autor";
    }

	public PrezentacijaModel(String ime, String autor2, RuNode selektovani, URL urlimported) {
		// TODO Auto-generated constructor stub
		super(ime, selektovani);
        this.autor = autor2;
        this.staroime=this.getParent().getName() + "/" +name;
        String putanja=urlimported.toString();
        putanja=putanja.substring(5);
        this.url=putanja;
        this.changed=true;
	}

	public String getStaroime() {
		return staroime;
	}
	
	public void setStaroime(String staroime) {
		this.staroime = staroime;
	}
	
    public String getAutor() {
        return autor;
    }
    
    public ArrayList<PrezentacijaModel> getKlonovi() {
		return klonovi;
	}

	public void setKlonovi(ArrayList<PrezentacijaModel> klonovi) {
		this.klonovi = klonovi;
	}

	public void setAutor(String autor) {
        this.autor = autor;
        notifySub(Akcije.APDEJTUJ);
        this.getParent().notifySub(Akcije.APDEJTUJ);
        ((ProjekatModel)this.getParent()).setChanged(true);;
        this.setChanged(true);
    }
	
    public boolean isChanged() {
		return changed;
	}

	public void setChanged(boolean changed) {
		this.changed = changed;
		if(changed)((ProjekatModel)this.getParent()).setChanged(true);
	     SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());

	}

	public File getPrezentacijaFile() {
		return prezentacijaFile;
	}

	public void setPrezentacijaFile(File prezentacijaFile) {
		this.prezentacijaFile = prezentacijaFile;
	}

}
