package Commands;


import java.util.ArrayList;

import Gui.MainFrame;


public class CommandManager {
	

	private ArrayList<Command> commandStack = new ArrayList<Command>();
	private int current = 0;
	
	
	public void addCommand(Command command){
		
		while(current < commandStack.size()) {
			commandStack.remove(current);
		}
		
		commandStack.add(command);
		doCommand();
	}
	
	public void doCommand(){
		
		if(current < commandStack.size()){
			commandStack.get(current).doCommand();
			current++;
			MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);
		}
		
		if(current==commandStack.size()){
			MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
		}
		
	}

	public void undoCommand(){
		
		if(current > 0){
			MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);
			current--;
			commandStack.get(current).undoCommand();
		}
		if(current==0){
			MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
		}
		
	}

}
