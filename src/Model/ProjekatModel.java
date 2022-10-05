package Model;



import java.io.File;
import java.io.Serializable;

import javax.swing.SwingUtilities;

import Controller.Akcije;
import Gui.MainFrame;
import observer.Sub;


public class ProjekatModel extends RuNodeComposite implements Serializable {
	
	private transient boolean changed;
	private File projekatFile;
    public ProjekatModel(String name, RuNodeComposite parent) {
        super(name, parent);
        this.changed=true;
        
    }
	/*@Override
    public void removeChild(RuNode child){
  	  if(children == null||!children.contains(child))
            return;
        else {
            this.children.remove(child);
            super.notifySub(Akcije.OBRISI);
            PrezentacijaModel prezentacijaModel=(PrezentacijaModel)child;
            if(!prezentacijaModel.getKlonovi().isEmpty()) {
            	for(PrezentacijaModel klon:prezentacijaModel.getKlonovi()) {
            		//(ProjekatModel)klon.getParent();
            	}
            }
            child.notifySub(Akcije.OBRISI);
            if(getParent()!=null) {
                getParent().notifySub(Akcije.OBRISI);;
            }

        }
        if(this instanceof ProjekatModel) {
      	  ((ProjekatModel)this).setChanged(true);
        }
  }*/

	public File getProjekatFile() {
		return projekatFile;
	}


	public void setProjekatFile(File projekatFile) {
		this.projekatFile = projekatFile;
	}


	public boolean isChanged() {
		return changed;
	}

	public void setChanged(boolean changed) {
		this.changed = changed;
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
	}
    
    
}
