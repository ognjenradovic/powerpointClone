package State;

public class StateManager {

	private State currentState;
	private EditState editState;
	private SlideshowState slideshowState;
	
	public StateManager() {
		initStates();
	}

	private void initStates() {
		// TODO Auto-generated method stub
		editState=new EditState();
		slideshowState=new SlideshowState();
		currentState=editState;//cisto da stavimo neku pocetnu defaultnu vrednost da ne bi doslo do greske
	}
	public State getCurrent() {return currentState;}
	public void setEditState() {currentState=editState;}
	public void setSlideshowState() {currentState=slideshowState; System.out.println("Set slidshowstate");}
}
