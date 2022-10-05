package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Controller.Akcije;


public abstract class RuNodeComposite extends RuNode implements Serializable {
    List<RuNode> children = new ArrayList<RuNode>();

    public RuNodeComposite(String name, RuNode parent) {
    	super(name,parent);
    }

	public void addChild(RuNode child){
        if(!children.contains(child)){
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
        if(this instanceof ProjekatModel) {
      	  ((ProjekatModel)this).setChanged(true);
        }
        if(this instanceof PrezentacijaModel) {
      	  ((PrezentacijaModel)this).setChanged(true);
      	  ((ProjekatModel)this.getParent()).setChanged(true);
        }
    }

    public void removeChild(RuNode child){
    	  if(children == null||!children.contains(child))
              return;
          else {
              this.children.remove(child);
              super.notifySub(Akcije.OBRISI);
              child.notifySub(Akcije.OBRISI);
              if(getParent()!=null) {
                  getParent().notifySub(Akcije.OBRISI);;
              }

          }
          if(this instanceof ProjekatModel) {
        	  ((ProjekatModel)this).setChanged(true);
          }
          if(this instanceof PrezentacijaModel) {
        	  ((PrezentacijaModel)this).setChanged(true);
        	  ((ProjekatModel)this.getParent()).setChanged(true);
          }
    }

    public List<RuNode> getChildren() {
        return children;
    }

    public void setChildren(List<RuNode> children) {
        this.children = children;
    }
}
