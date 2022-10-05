package Commands;

import java.awt.Color;
import java.awt.geom.Point2D;

import Gui.MainFrame;
import Model.RuNode;
import Model.RuNodeComposite;
import Model.SlajdModel;
import Model.SlotModel;
import Run.Main;
import Tree.RuTreeNode;

import javax.swing.*;

public class RemoveCommand extends Command {
	private RuTreeNode child;
	private RuTreeNode parent;
	private RuNode childRuNode;


	public RemoveCommand(RuTreeNode child) {
		this.child = child;
		this.childRuNode = child.getNode();
		this.parent=(RuTreeNode) child.getParent();
	}

	@Override
	public void doCommand() {
		if(parent!=null){
			child.removeFromParent();
			parent.remove(child);
		/*	for(RuNode projMod:MainFrame.getInstance().getWorkspaceModel().getChildren()) {
					if((ProjekatModel)projMod.getKlon().contains(child)) {
						child.setParent(projMod);
					}
			}
			*/
			((RuNodeComposite)childRuNode.getParent()).removeChild(childRuNode);
		}
	
				SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
				MainFrame.getInstance().getBlank().updateUI();
	}

	@Override
	public void undoCommand() {
		if(parent!=null){
			parent.addChild(child);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
			MainFrame.getInstance().getBlank().updateUI();
		}
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
	}

}
