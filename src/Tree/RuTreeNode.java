package Tree;

import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import Model.RuNodeComposite;
import Model.WorkspaceModel;
import Model.RuNode;

public class RuTreeNode implements MutableTreeNode {
	private RuNode node;

	public RuTreeNode(RuNode ruNode) {
		this.node=ruNode;
	}

	public RuNode getNode() {
		return node;
	}

	public void setNode(RuNode node) {
		this.node = node;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		List<RuNode> nodovi = ((RuNodeComposite) node).getChildren();
        RuNode ruNode = nodovi.get(childIndex);
        RuTreeNode treeNode = new RuTreeNode(ruNode);
        return treeNode;
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		if(node instanceof RuNodeComposite){
            return ((RuNodeComposite) node).getChildren().size();
        }else
            return 0;
	}

	@Override
	public TreeNode getParent() {
	     if(node instanceof WorkspaceModel)
	            return null;
	     RuTreeNode parent = new RuTreeNode(node.getParent());
	        return parent;
	}

	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		/*List<RuNode> nodovi = ((RuNodeComposite) node).getChilds();
        if(node instanceof RuTreeNode)
            return  nodovi.indexOf(((RuTreeNode)node).getNode());
        return -1;*/
		return 0;
	}

	@Override
	public boolean getAllowsChildren() {
	    if(node instanceof RuNodeComposite)
            return true;
        return false;
	}

	@Override
	public boolean isLeaf() {
		if(node instanceof RuNodeComposite)
            return false;
        return true;
	}

	@Override
	public Enumeration<? extends TreeNode> children() {
		 if(node instanceof RuNodeComposite)
	            return (Enumeration<? extends TreeNode>) ((RuNodeComposite) node).getChildren();
	        else
	            return null;
	}

	 public void addChild(RuTreeNode ruNode){
	        if( node instanceof RuNodeComposite){
	            ((RuNodeComposite)node).addChild(ruNode.getNode());
	        }

	    }

	    @Override
	    public String toString() {
	        return node.getName();
	    }
	    
	@Override
	public void insert(MutableTreeNode child, int index) {
		
	}

	@Override
	public void remove(int index) {


	}

	@Override
	public void remove(MutableTreeNode node) {
			RuNode ruNode=((RuTreeNode)node).getNode();
			((RuNodeComposite)ruNode.getParent()).removeChild(ruNode);
	}

	@Override
	public void setUserObject(Object object) {


	}

	@Override
	public void removeFromParent() {
		RuTreeNode parent=(RuTreeNode) getParent();
		parent.remove(this);
		RuNodeComposite ruParent=(RuNodeComposite) parent.getNode();
		ruParent.removeChild(node);
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		if(newParent!=null) {
			this.removeFromParent();
			((RuTreeNode)newParent).addChild(this);
		}
	}
	


}

