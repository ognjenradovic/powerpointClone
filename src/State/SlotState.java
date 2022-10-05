package State;

import java.awt.Point;

import Gui.SlajdGui;
import Gui.SlotGUI;
import Model.SlajdModel;
import Model.SlotModel;

public interface SlotState {
  void mousePressed(SlajdModel slajdModel, Point point, SlajdGui slajdGui);
  void mouseDragged(SlajdModel slajdModel,Point point,SlotGUI slotGUI);
  void mouseReleased(SlajdModel slajdModel,Point point,SlajdGui slajdGui);
}
