package factory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Controller.ENumError;
import Controller.ErrorFactory;
import Model.PrezentacijaModel;
import Model.RuNode;

public class PrezentacijaFactory extends RuNodeFactory {

	@Override
	protected RuNode createRuNode(RuNode parent) {
		// TODO Auto-generated method stub
		String ime = JOptionPane.showInputDialog(null, "Unesi ime prezentacije:");
		String autor = JOptionPane.showInputDialog(null, "Unesi ime autora:");
    	if(ime==null|| autor==null) {
    		ErrorFactory.getInstance().generateError(ENumError.NEDOSTAJE_IME_AUTOR);
    	}
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(fc);
		URL url = null;
		try {
			File file=fc.getSelectedFile();
			if(file==null) {
				ErrorFactory.getInstance().generateError(ENumError.NEDOSTAJE_SLIKA);
			}
			url=file.toURL();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			ErrorFactory.getInstance().generateError(ENumError.NEDOSTAJE_SLIKA);
		}
        return new PrezentacijaModel(ime,autor,parent,url);
	}

}
