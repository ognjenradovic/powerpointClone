package Commands;

import java.awt.Color;
import java.awt.geom.Point2D;

import Gui.MainFrame;
import Model.PrezentacijaModel;
import Model.RuNode;
import Model.RuNodeComposite;
import Model.SlajdModel;
import Model.SlotModel;
import Run.Main;
import Tree.RuTreeNode;

import javax.swing.*;

public class EditCommand extends Command {
	private RuNode child;
	private String staroIme;
	private String ime;
	private String autor;
	private String stariAutor;


	public EditCommand(RuNode selektovani, String ime, String autor) {
		this.child=selektovani;
		this.ime=ime;
		this.autor=autor;
		this.staroIme=selektovani.getName();
		if(selektovani instanceof PrezentacijaModel) {
			PrezentacijaModel temp=(PrezentacijaModel)selektovani;
			this.stariAutor=temp.getAutor();
		}
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
		MainFrame.getInstance().getBlank().updateUI();
	}

	@Override
	public void doCommand() {
			child.setName(ime);
			if(child instanceof PrezentacijaModel) {
				PrezentacijaModel temp=(PrezentacijaModel)child;
				temp.setAutor(autor);
			}
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
			MainFrame.getInstance().getBlank().updateUI();
	}

	@Override
	public void undoCommand() {
		child.setName(staroIme);
		if(child instanceof PrezentacijaModel) {
			PrezentacijaModel temp=(PrezentacijaModel)child;
			temp.setAutor(stariAutor);
		}
		MainFrame.getInstance().getBlank().updateUI();
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
	}

}
