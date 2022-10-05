package State;

import java.awt.Point;

import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;

import Gui.EditSlotView;
import Gui.MainFrame;
import Gui.SlajdGui;
import Gui.SlotGUI;
import Model.RuNode;
import Model.SlajdModel;
import Model.SlotModel;

public class SelectState implements SlotState {

	@Override
	public void mousePressed(SlajdModel slajdModel, Point point,SlajdGui slajdGui) {
		// TODO Auto-generated method stub
		for(RuNode ruNode:slajdModel.getChildren()) {
			int x=((SlotModel)ruNode).getX();
			int y=((SlotModel)ruNode).getY();
			int width=((SlotModel)ruNode).getWidth();
			int height=((SlotModel)ruNode).getHeight();
	
			if(point.x>=x && point.x<=x+width && point.y>=y && point.y<=y+height) {
				try {
					EditSlotView editSlot=new EditSlotView(MainFrame.getInstance(),(SlotModel)ruNode);
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void mouseDragged(SlajdModel slajdModel, Point point,SlotGUI slotGUI) {

		
	}

	@Override
	public void mouseReleased(SlajdModel slajdModel, Point point,SlajdGui slajdGui) {

		
	}






}