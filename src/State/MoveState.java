package State;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Point;

import javax.swing.JOptionPane;

import Commands.AddCommand;
import Gui.MainFrame;
import Gui.SlajdGui;
import Gui.SlotGUI;
import Model.RuNode;
import Model.SlajdModel;
import Model.SlotModel;

public class MoveState implements SlotState {
	RuNode currentSlot;

	@Override
	public void mousePressed(SlajdModel slajdModel, Point point,SlajdGui slajdGui) {
		// TODO Auto-generated method stub
	for(RuNode ruNode:slajdModel.getChildren()) {
			int x=((SlotModel)ruNode).getX();
			int y=((SlotModel)ruNode).getY();
			int width=((SlotModel)ruNode).getWidth();
			int height=((SlotModel)ruNode).getHeight();
			if(point.x>=x && point.x<=x+width && point.y>=y && point.y<=y+height) {
			currentSlot=ruNode;
			break;
			}
		}
	}

	@Override
	public void mouseDragged(SlajdModel slajdModel, Point point,SlotGUI slotGUI) {
		// TODO Auto-generated method stub
		((SlotModel)currentSlot).setX(point.x);
		((SlotModel)currentSlot).setY(point.y);
		
	}

	@Override
	public void mouseReleased(SlajdModel slajdModel, Point point,SlajdGui slajdGui) {
		MainFrame.getInstance().setLastAdded(slajdGui);
		//slajdGui.getCommandManager().addCommand(new AddCommand(slajdModel,point,1));
		((SlotModel)currentSlot).setX(point.x);
		((SlotModel)currentSlot).setY(point.y);
	}






}