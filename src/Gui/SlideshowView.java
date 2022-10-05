package Gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.PrezentacijaModel;
import Model.RuNode;
import Model.SlajdModel;
import State.StateManager;

	public class SlideshowView extends JPanel   
	{  
	    
	private int currCard = 1;   
	private CardLayout cardLayout;  
	  
	// constructor of the class  
	public SlideshowView(PrezentacijaModel object) { 
		StateManager stateManager = new StateManager();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JPanel cPanel = new JPanel();  
		cardLayout = new CardLayout();  
		cPanel.setLayout(cardLayout);  
		for(RuNode ruSlajd:object.getChildren()) {
		SlajdModel slajdModel=(SlajdModel)ruSlajd;
			SlajdDisplayGUI slajdGui=new SlajdDisplayGUI(slajdModel);
			slajdGui.setPreferredSize(new Dimension(950,620));
			cPanel.add(slajdGui);
		} 
		JPanel btnPanel = new JPanel();     
		JButton nextButton = new JButton(">");  
		JButton previousButton = new JButton("<");   
		//JButton cancel = new JButton("Cancel");   
		btnPanel.add(previousButton);
		btnPanel.add(nextButton);     
		//btnPanel.add(cancel);     
		nextButton.addActionListener(new ActionListener()  
		{  
		public void actionPerformed(ActionEvent ae)  
		{  
		if (currCard < object.getChildren().size())  
		{
		currCard = currCard + 1;  
		cardLayout.next(cPanel);
		updateUI();
		}  
		}  
		});  
		  
		previousButton.addActionListener(new ActionListener()  
		{  
		public void actionPerformed(ActionEvent ae)  
		{  
		  
		if (currCard > 1)   
		{    
		currCard = currCard - 1;  
		cardLayout.previous(cPanel);
		}  
		}  
		}); 
		
		/*cancel.addActionListener(new ActionListener()  
		{  
		public void actionPerformed(ActionEvent ae)  
		{  
			 stateManager.setEditState();
             stateManager.getCurrent();
             MainFrame.getInstance().cancelSlideshow();
		}  
		});  */

	
		this.add(cPanel);
		this.add(btnPanel);
		this.updateUI();
	}
	}
	

