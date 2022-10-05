package factory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Controller.ENumError;
import Controller.ErrorFactory;
import Model.PrezentacijaModel;
import Model.ProjekatModel;
import Model.RuNode;
import Model.RuNodeComposite;

public class ProjekatFactory extends RuNodeFactory {

	@Override
	protected RuNode createRuNode(RuNode parent) {
		String ime = JOptionPane.showInputDialog(null, "Unesi ime projekta:");
    	if(ime.isEmpty()) {
    		ErrorFactory.getInstance().generateError(ENumError.NEDOSTAJE_IME_AUTOR);
    	}
        return new ProjekatModel(ime,(RuNodeComposite)parent);
	}

}
