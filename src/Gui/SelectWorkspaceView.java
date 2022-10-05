package Gui;

import javax.swing.*;

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

public class SelectWorkspaceView extends JDialog {
    public SelectWorkspaceView(Frame parent){
        super(parent);
        JButton izaberi=new JButton("Izaberi sliku");
        JButton potvrdiImg=new JButton("Potvrdi");
        setLocationRelativeTo(parent);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        
        setSize(width/3,height/5);
            	String[] tipSlota = {"Prethodni kontekst", "Novi kontekst"};
                String izabraniTip = (String) JOptionPane.showInputDialog(
                        null,
                        "Izaberi kontekst",
                        "Izaberi kontekst",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        tipSlota,
                        tipSlota[0]);
                if(izabraniTip.equals("Prethodni kontekst")) {
                MainFrame.getInstance().setStariKontekst(true);
                }
                else {
                MainFrame.getInstance().setStariKontekst(false);
                }
    }
}
