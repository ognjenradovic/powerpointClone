package State;



import java.awt.Color;
import java.awt.Paint;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.concurrent.Flow.Subscriber;

import Commands.AddCommand;
import Commands.Command;
import Gui.MainFrame;
import Gui.PrezentacijaGui;
import Gui.PrezentacijaMainView;
import Gui.SlajdGui;
import Gui.SlotGUI;
import Model.RuNode;
import Model.SlajdModel;
import Model.SlotModel;
import observer.Sub;


public class AddState implements SlotState {



	@Override
	public void mousePressed(SlajdModel slajdModel, Point point,SlajdGui slajdGui) {
		// TODO Auto-generated method stub
		Paint fill = new Color(255,255,255);
		SlotModel pravougaonik=new SlotModel("Rectangle",(RuNode)slajdModel,point.x,point.y,150,100,Color.black) ;
		slajdModel.addChild((RuNode)pravougaonik);
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