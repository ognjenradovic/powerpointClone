package Gui;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.List;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Commands.CommandManager;
import Model.PrezentacijaModel;
import Model.RuNode;
import Model.SlajdModel;
import Model.SlotModel;
import State.AddState;
import State.DeleteState;
import State.SelectState;
import State.SlotState;
import observer.Sub;

public class SlajdGui extends JPanel implements Sub {

		  private Image img;
		  private String tekst;
		  private SlajdModel slajdModel;
		  private SlajdGui slajdGui=this;
		  private ArrayList<SlotGUI> slotovi;
		  private CommandManager commandManager;

		  public CommandManager getCommandManager() {
			return commandManager;
		}

		public void setCommandManager(CommandManager commandManager) {
			this.commandManager = commandManager;
		}

		public SlajdModel getSlajdModel() {
			return slajdModel;
		}

		public void setSlajdModel(SlajdModel slajdModel) {
			this.slajdModel = slajdModel;
		}

		public SlajdGui getSlajdGui() {
			return slajdGui;
		}

		public void setSlajdGui(SlajdGui slajdGui) {
			this.slajdGui = slajdGui;
		}

		public SlajdGui(SlajdModel slajdModel) {
			slotovi=new ArrayList<>();
		  		PrezentacijaModel parent=(PrezentacijaModel)(slajdModel.getParent());
			   /* File file=new File(parent.getUrl());
			    try {
					this.img=ImageIO.read(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
		  		this.img=new ImageIcon(parent.getUrl()).getImage();
			    MouseController mouseController=new MouseController();
			    MouseDraggedController mouseDraggedController=new MouseDraggedController();
			    MouseReleasedController mouseReleasedController=new MouseReleasedController();
			    this.addMouseListener(mouseController);
			    this.addMouseListener(mouseReleasedController);
			    this.addMouseMotionListener(mouseDraggedController);
			    this.slajdModel=slajdModel;
			    this.slajdModel.addSub(this);
			    this.setBackground(Color.white);
			  }

		  public void paintComponent(Graphics g) {
			Graphics2D g2=(Graphics2D)g;
		    g2.drawImage(img, (int)(this.getSize().getWidth()-img.getWidth(null))/2,
		    				 (int)(this.getSize().getHeight()-img.getHeight(null))/2, null);
		    g2.setPaintMode();
		    g2.setColor(Color.white);
		    if(slajdModel.getChildren()!=null) {
				 for(RuNode slotModel:slajdModel.getChildren()) {
					 SlotGUI slotGUI=new SlotGUI((SlotModel)slotModel);
					 slotGUI.paint(g2);
				 }
			 }
			
		  }
		  
		  private class MouseController extends MouseAdapter{
			  	@Override		
				public void mousePressed(MouseEvent e) {
					SlotState slotState=MainFrame.getInstance().getSlotStateManager().getCurrent();
					if (e.getButton()==MouseEvent.BUTTON1){
						slotState.mousePressed(slajdModel,e.getPoint(),slajdGui);
			
						updateUI();
					}
			
				}
		  }
			  					
				  private class MouseDraggedController extends MouseAdapter{
						@Override
						public void mouseDragged(MouseEvent e) {
							SlotState slotState=MainFrame.getInstance().getSlotStateManager().getCurrent();
							if (e.getButton()==MouseEvent.MOUSE_DRAGGED){
								slotState.mouseDragged(slajdModel, e.getPoint(),(SlotGUI)e.getSource());
								updateUI();
								
							}
					

							updateUI();
						}
			
			}
				  private class MouseReleasedController extends MouseAdapter{
						@Override
						public void mouseReleased(MouseEvent e) {
							SlotState slotState=MainFrame.getInstance().getSlotStateManager().getCurrent();
								slotState.mouseReleased(slajdModel,e.getPoint(),slajdGui);
				
								updateUI();
							
						

							updateUI();
						}
			
			}
				@Override
				public void update(Object notification) {
					if(slajdModel.getChildren()!=null) {
						slotovi.removeAll(slotovi);
						 for(RuNode slotModel:slajdModel.getChildren()) {
							 SlotGUI slotGUI=new SlotGUI((SlotModel)slotModel);
							 if(!slotovi.contains(slotGUI)) {
								 slotovi.add(slotGUI); 
							 }
							 
							 
						 }
					}
					updateUI();
				}




		  	
			
}
