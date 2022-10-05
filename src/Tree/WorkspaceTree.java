package Tree;




import java.awt.Component;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;

public class WorkspaceTree extends JTree {

	public WorkspaceTree(DefaultTreeModel TreeModel) {
		setModel(TreeModel);
	    setCellEditor(new WorkspaceTreeEditor(this,new DefaultTreeCellRenderer()));
	    setCellRenderer(new WorkspaceTreeCellRendered());
	    setEditable(true);
	    this.addMouseListener(new TreeMouseListener());
	}

	
	/**
	 * Metoda za dodavanje novog projekta u workspace 
	 * @param project
	 */
	public void addChild(RuTreeNode node) {
        ((RuTreeNode)getModel().getRoot()).addChild(node);
        SwingUtilities.updateComponentTreeUI(this);
    }

	
}
