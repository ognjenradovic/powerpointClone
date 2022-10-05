package Model;

import java.awt.Dimension;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Controller.Akcije;
import observer.Publisher;
import observer.Sub;

public class SlajdModel extends RuNodeComposite implements Publisher,Serializable {
	 

	private transient List<Sub> subscribers;
	
	
/*	public List<SlotModel> getSlotovi() {
		return slotovi;
	}

	public void setSlotovi(List<SlotModel> slotovi) {
		this.slotovi = slotovi;
	}
	public void addSlot(SlotModel slotModel) {
		slotovi.add(slotModel);
	}*/

	private String tekst;


    public SlajdModel(String name, RuNode parent) {
        super(name, parent);
    }

    public SlajdModel(String name, int broj, RuNode parent) {
		super(name, parent);
		this.tekst=""+broj;
	}

	public SlajdModel(String name, RuNode parent, String tekst) {
		super(name, parent);
		this.tekst = tekst;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public void setPreferredSize(Dimension dimension) {
		// TODO Auto-generated method stub
		
	}

    
	}
    


