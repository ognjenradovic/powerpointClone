package State;

public class SlotStateManager {

	private SlotState currentState;
	private AddState addState;
	private DeleteState deleteState;
	private SelectState selectState;
	private MoveState moveState;
	
	public SlotStateManager() {
		initStates();
	}

	private void initStates() {
		// TODO Auto-generated method stub
		addState=new AddState();
		deleteState=new DeleteState(); 
		selectState=new SelectState();
		moveState=new MoveState();
		currentState=addState;//cisto da stavimo neku pocetnu defaultnu vrednost da ne bi doslo do greske
	}
	public SlotState getCurrent() {return currentState;}
	public void setAddState() {currentState=addState;}
	public void setDeleteState() {currentState=deleteState;}
	public void setSelectState() {currentState=selectState;}
	public void setMoveState() {currentState=moveState;}
}
