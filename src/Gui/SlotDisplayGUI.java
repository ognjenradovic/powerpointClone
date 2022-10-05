package Gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.Stroke;
import java.awt.font.TextAttribute;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import Model.SlotModel;
import Model.TipSlota;

public class SlotDisplayGUI extends JFrame {
	
	private static final String AttributedString = null;
	private static final String AttributedCharacter = null;
	private SlotModel slotModel;
	private java.text.AttributedString attributedString;

	public SlotDisplayGUI(SlotModel slotModel) {
		Graphics g = null;
		this.slotModel=slotModel;
		StringBuilder output=new StringBuilder();
		if(slotModel.getText()!=null) {
			String placeholder=slotModel.getText();
			for(int i=0;i<placeholder.length();i++) {
				if(placeholder.charAt(i)=='%'||placeholder.charAt(i)=='&'||placeholder.charAt(i)=='*') {
				//*bold* &italic& !underline!
				//bold italic underline
				}
				else {
					output.append(placeholder.charAt(i));
				}
			}
			//bold italic underline
			//
			int j=0;
			attributedString = new java.text.AttributedString(output.toString());
			for(int i=0;i<slotModel.getText().length();i++) {
				String text=slotModel.getText();
        		  boolean boldTag=false;
               	  boolean italicTag=false;
               	  boolean underlineTag=false;
        		 if(text.charAt(i)=='*') {			
                     i++;
                     boldTag=true;
        		 }
        		 if(text.charAt(i)=='%') {		 
                     i++;
                     italicTag=true;
        		 }
        		 if(text.charAt(i)=='&') {
                     i++;
                     underlineTag=true;
        		 }
        		 if(text.charAt(i)==' ') {
        			 j++;
        		 }
        		 if(underlineTag) {
        			 attributedString.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON, j, j+1);
        			 attributedString.addAttribute(TextAttribute.SIZE, 18, j, j+1);
        			 j++;
        			 i++;
        		 }
        		 if(italicTag) {
        			 attributedString.addAttribute(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE, j, j+1);
        			 attributedString.addAttribute(TextAttribute.SIZE, 18, j, j+1);
        			 j++;
        			 i++;
        		 }
        		 if(boldTag) {
        			 attributedString.addAttribute(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD, j, j+1);
        			 attributedString.addAttribute(TextAttribute.SIZE, 18, j, j+1);
        			 j++;
        			 i++;
        		 }
        		 
        		 
        	  } 
			}
       // test1.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER, 5, 16);
       // test1.addAttribute(TextAttribute.FONT, bold, 21, 25);
		}
	
	

	public void paint(Graphics2D g2) {
	g2.setColor(Color.BLACK);
	g2.setFont(new java.awt.Font("Arial", Font.PLAIN, 20));
	if(slotModel.getTipSlota()!=null) {
		if(slotModel.getTipSlota().equals(TipSlota.TEKST)) {
			if(slotModel.getText()!=null) {
			//g2.drawString(slotModel.getText(), slotModel.getX(), slotModel.getY());
			g2.drawString(attributedString.getIterator(), slotModel.getX(), slotModel.getY());
			}
			//g2.drawString(AttributedCharacterIterator, slotModel.getX(), slotModel.getY());
		}
		else {
			if(slotModel.getUrl()!=null) {
				ImageIcon imageIcon=new ImageIcon(slotModel.getUrl());
				Image image=imageIcon.getImage();
				g2.drawImage(image,slotModel.getX(),slotModel.getY() ,null);
				Graphics g;
			}
		}
	}
	
		//g2.drawImage(new ImageIcon(slotModel.getUrl()));
	
	}

}

