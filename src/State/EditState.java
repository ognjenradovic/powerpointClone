package State;

import Gui.MainFrame;

public class EditState implements State {

	@Override
	public void Slideshow(Object object) {
		MainFrame.getInstance().cancelSlideshow();
	}

}