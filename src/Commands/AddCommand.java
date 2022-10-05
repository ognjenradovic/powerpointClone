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

public class AddCommand extends Command {
	private RuTreeNode child;
	private RuTreeNode parent;
	private RuNode childRuNode;


	public AddCommand(RuTreeNode child, RuNode childRuNode) {
		this.child = child;
		this.childRuNode = childRuNode;
		this.parent=(RuTreeNode) child.getParent();
	}
	public AddCommand(RuTreeNode child, RuNode childRuNode,RuTreeNode parent) {
		this.child = child;
		this.childRuNode = childRuNode;
		this.parent=parent;
	}

	@Override
	public void doCommand() {
		if(parent!=null){
			parent.addChild(child);
		}
				SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
				MainFrame.getInstance().getBlank().updateUI();
	}

	@Override
	public void undoCommand() {
		if(parent!=null){
			parent.remove(child);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
			MainFrame.getInstance().getBlank().updateUI();
		}
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
	}

}
