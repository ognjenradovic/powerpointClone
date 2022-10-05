package Gui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import Model.SlotModel;
import observer.Sub;

public class SlotGUI implements Sub  {
	
	private SlotModel slotModel;

	public SlotGUI(SlotModel slotModel) {
		this.slotModel=slotModel;
	}

	public void paint(Graphics2D g2) {
		g2.setColor(slotModel.getColor());
		g2.setStroke(new BasicStroke(3.0f));
		g2.drawRect(slotModel.getX(),slotModel.getY(),slotModel.getWidth(),slotModel.getHeight());
	}

	@Override
	public void update(Object notification) {
		// TODO Auto-generated method stub
	
	}

}
