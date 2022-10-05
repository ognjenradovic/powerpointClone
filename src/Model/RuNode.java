package Model;
//nema sta da se menja
import observer.Publisher;
import observer.Sub;

import javax.swing.tree.TreeNode;

import Controller.Akcije;
import Tree.RuTreeNode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class RuNode implements Publisher,Serializable  {
    String name;
    transient List<Sub> Subs;
    RuNode parent;
    ArrayList<RuTreeNode> klon=new ArrayList<>();


    public RuNode(String name, RuNode parent) {
        this.name = name;
        this.parent = parent;
        Subs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
      this.name = name;
      if(this.getParent()!=null)this.getParent().notifySub(Akcije.APDEJTUJ);
      if(this.getParent().getParent()!=null)this.getParent().getParent().notifySub(Akcije.APDEJTUJ);
      if(this instanceof ProjekatModel) {
    	  ((ProjekatModel)this).setChanged(true);
      }
      if(this instanceof PrezentacijaModel) {
    	  ((PrezentacijaModel)this).setChanged(true);
    	  ((ProjekatModel)this.getParent()).setChanged(true);
      }

    }

    public RuNode getParent() {
        return parent;
    }

    public void setParent(RuNode parent) {
        this.parent = parent;
        parent.notifySub(Akcije.DODAJ);
    }

    public List<Sub> getSubs() { 
        return Subs;
    }
    @Override
    public void addSub(Sub sub) {
        if (sub != null) {
            if (this.Subs == null) {
            	
                this.Subs = new ArrayList();
                
            }
            if (!this.Subs.contains(sub)) {
            	
                this.Subs.add(sub);
                
            }
        }
    }
    

    public ArrayList<RuTreeNode> getKlon() {
		return klon;
	}

	public void setKlon(ArrayList<RuTreeNode> klon) {
		this.klon = klon;
	}

	@Override
    public void removeSub(Sub sub) {
        if (sub != null && this.Subs != null && this.Subs.contains(sub)) {
            this.Subs.remove(sub);
            notifySub(Akcije.OBRISI);
        }
    }

    @Override
    public void notifySub(Object notification) {
        if (notification != null &&  !(this.Subs==null)) {
        	
            for(int i=0;i< Subs.size();i++){
                Subs.get(i).update(notification);
            }
            
        }
    }
}

