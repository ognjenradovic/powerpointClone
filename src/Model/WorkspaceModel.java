package Model;



import java.io.Serializable;

import Controller.Akcije;
import Gui.MainFrame;



public class WorkspaceModel extends RuNodeComposite implements Serializable {
    public WorkspaceModel(String name, RuNode parent) {
        super(name, parent);
    }
    @Override
	public void addChild(RuNode child){
        if(!children.contains(child) && !(child instanceof PrezentacijaModel)){
            this.children.add(child);
            child.setParent(this);
            super.notifySub(Akcije.DODAJ);
            if(this.getParent()!=null) {
            	this.getParent().notifySub(Akcije.DODAJ);
            	if(this.getParent().getParent()!=null) {
            		this.getParent().getParent().notifySub(Akcije.DODAJ);
            	}
            }
            
        }
    }

}
