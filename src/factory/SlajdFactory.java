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
import Model.SlajdModel;

public class SlajdFactory extends RuNodeFactory {

	@Override
	protected RuNode createRuNode(RuNode parent) {
		return new SlajdModel("Slajd ",1,parent);
	}

}
