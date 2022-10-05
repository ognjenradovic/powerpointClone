package Controller;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import Gui.MainFrame;

public class ActionManager{
private NewAction newProjectAction;
private InfoAction infoAction;
private EditAction editAction;
private DeleteAction deleteAction;
private SlideshowAction slideshowAction;
private AddSlotAction addSlotAction;
private DeleteSlotAction deleteSlotAction;
private SelectSlotAction selectSlotAction;
private MoveSlotAction moveSlotAction;
private UndoAction undoAction;
private RedoAction redoAction;
private SaveAsAction saveAsAction;
private SaveAction saveAction;
private OpenAction openAction;
private ShareAction shareAction;
private ShareToAction shareToAction;

public EditAction getEditAction() {
	return editAction;
}

public void setEditAction(EditAction editAction) {
	this.editAction = editAction;
}

public ActionManager() {initialiseActions();}

private void initialiseActions() {
	newProjectAction=new NewAction();
	infoAction=new InfoAction();
	editAction=new EditAction();
	deleteAction=new DeleteAction();
	slideshowAction=new SlideshowAction();
	addSlotAction= new AddSlotAction();
	deleteSlotAction = new DeleteSlotAction();
	selectSlotAction = new SelectSlotAction();
	moveSlotAction = new MoveSlotAction();
	undoAction = new UndoAction();
	redoAction = new RedoAction();
	saveAction = new SaveAction();
	saveAsAction = new SaveAsAction();
	openAction = new OpenAction();
	shareAction=new ShareAction();
	shareToAction=new ShareToAction();
	shareToAction.setEnabled(false);
	
	
}

public ShareToAction getShareToAction() {
	return shareToAction;
}

public void setShareToAction(ShareToAction shareToAction) {
	this.shareToAction = shareToAction;
}

public ShareAction getShareAction() {
	return shareAction;
}

public void setShareAction(ShareAction shareAction) {
	this.shareAction = shareAction;
}

public OpenAction getOpenAction() {
	return openAction;
}

public void setOpenAction(OpenAction openAction) {
	this.openAction = openAction;
}

public SaveAsAction getSaveAsAction() {
	return saveAsAction;
}

public void setSaveAsAction(SaveAsAction saveAsAction) {
	this.saveAsAction = saveAsAction;
}

public SaveAction getSaveAction() {
	return saveAction;
}

public void setSaveAction(SaveAction saveAction) {
	this.saveAction = saveAction;
}

public DeleteAction getDeleteAction() {
	return deleteAction;
}

public void setDeleteAction(DeleteAction deleteAction) {
	this.deleteAction = deleteAction;
}

public InfoAction getInfoAction() {
	return infoAction;
}

public void setInfoAction(InfoAction infoAction) {
	this.infoAction = infoAction;
}
public NewAction getNewProjectAction() {
	return newProjectAction;
}

public void setNewProjectAction(NewAction newProjectAction) {
	this.newProjectAction = newProjectAction;
}

public SlideshowAction getSlideshow() {
	return slideshowAction;
}

public AddSlotAction getAddSlotAction() {
	// TODO Auto-generated method stub
	return addSlotAction;
}

public SlideshowAction getSlideshowAction() {
	return slideshowAction;
}

public void setSlideshowAction(SlideshowAction slideshowAction) {
	this.slideshowAction = slideshowAction;
}

public DeleteSlotAction getDeleteSlotAction() {
	return deleteSlotAction;
}

public void setDeleteSlotAction(DeleteSlotAction deleteSlotAction) {
	this.deleteSlotAction = deleteSlotAction;
}

public SelectSlotAction getSelectSlotAction() {
	return selectSlotAction;
}

public void setSelectSlotAction(SelectSlotAction selectSlotAction) {
	this.selectSlotAction = selectSlotAction;
}

public MoveSlotAction getMoveSlotAction() {
	return moveSlotAction;
}

public UndoAction getUndoAction() {
	return undoAction;
}

public void setUndoAction(UndoAction undoAction) {
	this.undoAction = undoAction;
}

public RedoAction getRedoAction() {
	return redoAction;
}

public void setRedoAction(RedoAction redoAction) {
	this.redoAction = redoAction;
}

public void setMoveSlotAction(MoveSlotAction moveSlotAction) {
	this.moveSlotAction = moveSlotAction;
}

public void setAddSlotAction(AddSlotAction addSlotAction) {
	this.addSlotAction = addSlotAction;
}






}
