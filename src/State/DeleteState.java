package State;

import java.awt.Point;

import Gui.SlajdGui;
import Gui.SlideshowView;
import Gui.SlotGUI;
import Model.PrezentacijaModel;
import Model.RuNode;
import Model.SlajdModel;
import Model.SlotModel;

public class DeleteState implements SlotState {

	@Override
	public void mousePressed(SlajdModel slajdModel, Point point,SlajdGui slajdGui) {
		// TODO Auto-generated method stub
		for(RuNode ruNode:slajdModel.getChildren()) {
			int x=((SlotModel)ruNode).getX();
			int y=((SlotModel)ruNode).getY();
			int width=((SlotModel)ruNode).getWidth();
			int height=((SlotModel)ruNode).getHeight();
	
			if(point.x>=x && point.x<=x+width && point.y>=y && point.y<=y+height) {
				slajdModel.removeChild(ruNode);
				break;
			}
		}
	}

	@Override
	public void mouseDragged(SlajdModel slajdModel, Point point,SlotGUI slotGUI) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(SlajdModel slajdModel, Point point,SlajdGui slajdGui) {
		// TODO Auto-generated method stub
		
	}




}