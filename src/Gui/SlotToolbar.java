package Gui;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class SlotToolbar extends JToolBar {
	public SlotToolbar() {
		JButton addSlot=new JButton(MainFrame.getInstance().getActionManager().getAddSlotAction());
		JButton deleteSlot=new JButton(MainFrame.getInstance().getActionManager().getDeleteSlotAction());
		JButton selectSlot=new JButton(MainFrame.getInstance().getActionManager().getSelectSlotAction());
		JButton moveSlot=new JButton(MainFrame.getInstance().getActionManager().getMoveSlotAction());
		Toolkit kit=Toolkit.getDefaultToolkit();
		add(addSlot);
		add(deleteSlot);
		add(selectSlot);
		add(moveSlot);
		this.setFloatable(false);
	}
}
