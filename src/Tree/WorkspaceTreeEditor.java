package Tree;



import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

import Model.PrezentacijaModel;
import Model.SlajdModel;
import Model.ProjekatModel;
import Model.RuNode;

public class WorkspaceTreeEditor  extends DefaultTreeCellEditor implements ActionListener{
	
	
    private Object stavka=null;
    private JTextField edit=null;
    
	public WorkspaceTreeEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
		super(arg0, arg1);
	}
//i sto kao tree cell renderer
	public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {

		//super.getTreeCellEditorComponent(arg0,arg1,arg2,arg3,arg4,arg5);
		stavka=arg1;//cvor koji zelimo da editujemo
		
		edit=new JTextField(arg1.toString());//pocetni tekst je ono sto je vec pisalo u tom polju
		edit.addActionListener(this);
		return edit;//vracamo tekstualno polje
	}



	public boolean isCellEditable(EventObject arg0) {
		if (arg0 instanceof MouseEvent)
			if (((MouseEvent)arg0).getClickCount()==3){
				return true;
				
			}
				return false;
	}

	

	public void actionPerformed(ActionEvent e){
		RuNode selektovani = ((RuTreeNode)stavka).getNode();
		selektovani.setName(e.getActionCommand());
	}



}
