package Gui;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import Controller.ENumError;
import Controller.ErrorFactory;
import Model.SlotModel;
import Model.TipSlota;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class EditSlotView extends JDialog {
	JTextPane textPane;
	SlotModel slotModel;
	URL tempURL;	
	JLabel imgPreview=new JLabel();
	String tempURL1;
    public EditSlotView(Frame parent,SlotModel slotModel) throws BadLocationException{
        super(parent);
        JButton potvrdi = null;
        potvrdi=new JButton("Potvrdi");
        JButton izaberi=new JButton("Izaberi sliku");
        JButton potvrdiImg=new JButton("Potvrdi");
        this.slotModel=slotModel;
        setLocationRelativeTo(parent);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        
        setSize(width/3,height/5);
            if(slotModel.getTipSlota().equals(TipSlota.NEODREDJENO)) {
            	String[] tipSlota = {"Tekst", "Slika"};
                String izabraniTip = (String) JOptionPane.showInputDialog(
                        null,
                        "Izaberi tip slota",
                        "Izaberi tip slota",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        tipSlota,
                        tipSlota[0]);
                if(izabraniTip.equals("Tekst")) {
                	slotModel.setTipSlota(TipSlota.TEKST);
                }
                else {
                	slotModel.setTipSlota(TipSlota.SLIKA);
                }
            }
        if(slotModel.getTipSlota().equals(TipSlota.TEKST)) {	
        	  JPanel fontBar=new JPanel();
              fontBar.setLayout(new BoxLayout(fontBar, BoxLayout.X_AXIS));
              JPanel bottomBar=new JPanel();
              bottomBar.setLayout(new BoxLayout(bottomBar, BoxLayout.X_AXIS));
              JButton bold=new JButton("Bold");
              JButton italic=new JButton("Italic");
              JButton underline=new JButton("Underline");
              JButton clearFormatting=new JButton("Clear Formatting");
              textPane = new JTextPane();            
              if(slotModel.getText()!="" && slotModel.getText()!=null) {
            	  Document doc = textPane.getStyledDocument();
            	  String text=slotModel.getText();
            	  for(int i=0;i<text.length();i++) {
            		  MutableAttributeSet attributeSet=new SimpleAttributeSet();
            		  boolean boldTag=false;
                   	  boolean italicTag=false;
                   	  boolean underlineTag=false;
            		 if(text.charAt(i)=='*') {
                         StyleConstants.setBold(attributeSet, true);
                         i++;
                         boldTag=true;
            		 }
            		 if(text.charAt(i)=='%') {
                         StyleConstants.setItalic(attributeSet, true);
                         i++;
                         italicTag=true;
            		 }
            		 if(text.charAt(i)=='&') {
                         StyleConstants.setUnderline(attributeSet, true);
                         i++;
                         underlineTag=true;
            		 }
            		 doc.insertString(doc.getLength(),text.charAt(i)+"", attributeSet);
            		 if(underlineTag)i++;
            		 if(italicTag)i++;
            		 if(boldTag)i++;
            		 
            	  }    	
              }   
              fontBar.add(bold);
              fontBar.add(italic);
              fontBar.add(underline);
              fontBar.add(clearFormatting);
          //    Document doc = textPane.getStyledDocument();
          //    doc.insertString(doc.getLength(), "To Java ", attributeSet);
              add(fontBar,BorderLayout.NORTH);
              add(textPane,BorderLayout.CENTER);
              bottomBar.add(potvrdi);
              add(bottomBar,BorderLayout.SOUTH);
              setVisible(true);
              
              potvrdi.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                	  StringBuilder sb=new StringBuilder();
                	 for(int i=0;i<textPane.getText().length();i++) {
                	  boolean bold=false;
                   	  boolean italic=false;
                   	  boolean underline=false;
              		AttributeSet attributeSet=new SimpleAttributeSet();
                		attributeSet=textPane.getStyledDocument().getCharacterElement(i).getAttributes();
                		 if(StyleConstants.isBold(attributeSet)) {
                			 sb.append("*");bold=true;
                		 }
                		 if(StyleConstants.isItalic(attributeSet)) {
                			 sb.append("%");italic=true;
                		 }
                		 if(StyleConstants.isUnderline(attributeSet)) {
                			 sb.append("&");underline=true;
                		 }
                		 sb.append(textPane.getText().charAt(i));
                		 if(underline)sb.append("&");
                		 if(italic)sb.append("%");
                		 if(bold)sb.append("*");
                	 }
                  	slotModel.setText(sb.toString());
                      setVisible(false);
                  }
              });
              bold.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent e) {
                	 SimpleAttributeSet attributeSet = new SimpleAttributeSet();
                     StyleConstants.setBold(attributeSet, true);
                	 textPane.getStyledDocument().setCharacterAttributes(textPane.getSelectionStart(),textPane.getSelectionEnd()-textPane.getSelectionStart(), attributeSet, true);
                     textPane.updateUI();
                     //Nisam mogao da osposobim karakter po karakter iz nekog razloga
                             /*for(int i=textPane.getSelectionStart(); i<textPane.getSelectionEnd(); i++) {
                           	  MutableAttributeSet attributeSet = new SimpleAttributeSet();
                           	  attributeSet.addAttributes(textPane.getStyledDocument().getCharacterElement(i).getAttributes());
                              StyleConstants.setBold(attributeSet, true);
                              textPane.getStyledDocument().setCharacterAttributes(i,1, attributeSet, true);
                              textPane.updateUI();
                             }*/
                 }} );
              italic.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent e) {
                        	  SimpleAttributeSet attributeSet = new SimpleAttributeSet();
                              StyleConstants.setItalic(attributeSet, true);
                        	 textPane.getStyledDocument().setCharacterAttributes(textPane.getSelectionStart(),textPane.getSelectionEnd()-textPane.getSelectionStart(), attributeSet, true);
                             textPane.updateUI();
                  }} );
              underline.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent e) {
                        	  SimpleAttributeSet attributeSet = new SimpleAttributeSet();
                              StyleConstants.setUnderline(attributeSet, true);
                        	 textPane.getStyledDocument().setCharacterAttributes(textPane.getSelectionStart(),textPane.getSelectionEnd()-textPane.getSelectionStart(), attributeSet, true);
                             textPane.updateUI();
                  }} );
              clearFormatting.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent e) {
                        	 SimpleAttributeSet attributeSet = new SimpleAttributeSet();
                        	 textPane.getStyledDocument().setCharacterAttributes(textPane.getSelectionStart(),textPane.getSelectionEnd()-textPane.getSelectionStart(), attributeSet, true);
                             textPane.updateUI();
                  }} );
              
              }
        else if(slotModel.getTipSlota().equals(TipSlota.SLIKA)){
      	  	JPanel buttonBar=new JPanel();
      	  	buttonBar.setLayout(new BoxLayout(buttonBar, BoxLayout.Y_AXIS));
            if(slotModel.getUrl()!=null) {
    		    tempURL1=slotModel.getUrl().toString();
    		    imgPreview.setIcon(new ImageIcon(tempURL1));
            	add(imgPreview,BorderLayout.CENTER);
            }
            buttonBar.add(izaberi);
            buttonBar.add(potvrdiImg);
            add(buttonBar,BorderLayout.EAST);
            add(imgPreview,BorderLayout.CENTER);           
            setVisible(true);
     
        }
        
        izaberi.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	JFileChooser fc = new JFileChooser();
        		fc.showOpenDialog(fc);
        		URL url = null;
        		try {
        			File file=fc.getSelectedFile();
        			if(file==null) {
        				ErrorFactory.getInstance().generateError(ENumError.NEDOSTAJE_SLIKA);
        			}
        			url=file.toURL();
        			tempURL=url;
        		    tempURL1=tempURL.toString().substring(5);
        		    imgPreview.setIcon(new ImageIcon(tempURL1));
        			
        		} catch (MalformedURLException e1) {
        			// TODO Auto-generated catch block
        			ErrorFactory.getInstance().generateError(ENumError.NEDOSTAJE_SLIKA);
        		}    
            }
            });
        
        potvrdiImg.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	if(tempURL!=null) {
                	slotModel.setUrl(tempURL.toString());
            	}
            	 setVisible(false);
            }
            });
        
        potvrdi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(slotModel.getText()!="") {
            		slotModel.setText(textPane.getText());
                    setVisible(false);
            	}
            }
        });
    }
}
