package State;

import Gui.MainFrame;
import Gui.SlideshowView;
import Model.PrezentacijaModel;

public class SlideshowState implements State {

	@Override
	public void Slideshow(Object object) {
	MainFrame.getInstance().startSlideshow(object);
	}

}