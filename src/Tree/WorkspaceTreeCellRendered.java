package Tree;



import java.awt.Component;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import Model.PrezentacijaModel;
import Model.ProjekatModel;
import Model.RuNode;
import Model.SlajdModel;
import Model.WorkspaceModel;

public class WorkspaceTreeCellRendered extends DefaultTreeCellRenderer{

	public WorkspaceTreeCellRendered() {
		
		// TODO Auto-generated constructor stub
	}

	  public Component getTreeCellRendererComponent(
              JTree tree, //u kom stablu
              Object value,
              boolean sel,
              boolean expanded,
              boolean leaf,
              int row,
              boolean hasFocus) {
                  super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row,hasFocus);//damo mu model i on ce na osnovnu toga nacrtati
                  
             
             if (((RuTreeNode)value).getNode() instanceof PrezentacijaModel ) {//menjamo ikonicu u zavisnosti od tipa klase
                 URL imageURL = getClass().getResource("images/prezentacija.png");
                 Icon icon = null;
                 if (imageURL != null)                       
                     icon = new ImageIcon(imageURL);
                 setIcon(icon);
	          } else if (((RuTreeNode)value).getNode() instanceof SlajdModel ) {
		           URL imageURL = getClass().getResource("images/slajd.png");
		           Icon icon = null;
		           if (imageURL != null)            
		               icon = new ImageIcon(imageURL);
		           setIcon(icon);   
			  } else if (((RuTreeNode)value).getNode() instanceof WorkspaceModel ) {
		          URL imageURL = getClass().getResource("images/workspace.png");
		          Icon icon = null;
		          if (imageURL != null)                       
		              icon = new ImageIcon(imageURL);
		          setIcon(icon);   
			     } 
				  else if (((RuTreeNode)value).getNode() instanceof ProjekatModel ) {
			          URL imageURL = getClass().getResource("images/project.png");
			          Icon icon = null;
			          RuNode ruNode=((RuTreeNode)value).getNode();
			          ProjekatModel projekatModel=(ProjekatModel)ruNode;
			          if(projekatModel.isChanged()) {
			        	     this.setName("*"+((RuTreeNode)value).getNode().getName());
					          this.setText("*"+((RuTreeNode)value).getNode().getName());
			          }
			          if (imageURL != null)                       
			              icon = new ImageIcon(imageURL);
			          setIcon(icon);   
			     } 
       
            return this;//vraca mi jlabel
}

	  }  
