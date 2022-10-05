package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;



public class InfoAction extends AbstractRudokAction{

	public InfoAction() {
		
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_F4,ActionEvent.ALT_MASK));
		putValue(SMALL_ICON,loadIcon("images/info.png"));
		putValue(NAME,"Info");
		putValue(SHORT_DESCRIPTION,"Information");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Ognjen Radovic 69/20RN");
	}

}
