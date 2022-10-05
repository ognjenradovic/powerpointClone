package Gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;



import Commands.CommandManager;
import Controller.ActionManager;
import Controller.Akcije;
import Controller.AutoSaveListener;
import Controller.ENumError;
import Controller.ErrorFactory;
import Controller.MyFileFilter;
import Model.PrezentacijaModel;
import Model.ProjekatModel;
import Model.RuNode;
import Model.RuNodeComposite;
import Model.SlajdModel;
import Model.SlotModel;
import Model.WorkspaceModel;
import State.SlotStateManager;
import State.StateManager;
import Tree.RuTreeNode;
import Tree.WorkspaceTree;
import factory.Factory;
import factory.RuNodeFactory;
import observer.Sub;

public class MainFrame extends JFrame implements Sub {//on je sub workspacemodela
	
	private static MainFrame instance=null;
	private Menu menu;
	private ActionManager actionManager;
	private JTabbedPane blank;
	private JPanel placeholder;
	private JSplitPane split;
	private JScrollPane stablo;
	private Toolbar toolbar;
	private WorkspaceModel workspaceModel;//ne moramo model
    private WorkspaceTree workspaceTree;
	public StateManager stateManager;//getter za state manager
	public SlotStateManager slotStateManager;
	public Factory factory;
	private CommandManager commandManager;
	private SlajdGui lastAdded;
	private RuTreeNode shareParent;
	private PrezentacijaModel share;
	private boolean stariKontekst=false;

	public CommandManager getCommandManager() {
		return commandManager;
	}

	public RuTreeNode getShareParent() {
		return shareParent;
	}

	public void setShareParent(RuTreeNode shareParent) {
		this.shareParent = shareParent;
	}

	public SlajdGui getLastAdded() {
		return lastAdded;
	}
	public void setLastAdded(SlajdGui lastAdded) {
		this.lastAdded = lastAdded;
	}
	public Factory getFactory() {
		return factory;
	}
	public void setFactory(Factory factory) {
		this.factory = factory;
	}
	public SlotStateManager getSlotStateManager() {
		return slotStateManager;
	}
	public void setSlotStateManager(SlotStateManager slotStateManager) {
		this.slotStateManager = slotStateManager;
	}
	public StateManager getStateManager() {
		return stateManager;
	}
	public void setStateManager(StateManager stateManager) {
		this.stateManager = stateManager;
	}
	public void startAddState() {this.stateManager.setEditState(); this.slotStateManager.setAddState();}// add nam je current
    public void calculate() {
    	//setuj tekst onog polja na
    	this.stateManager.getCurrent().Slideshow(null);
    }

    
	private MainFrame(){	 
	}
	
	private void initialise() {
		commandManager=new CommandManager();
		placeholder=new JPanel();
		placeholder.setLayout(new GridLayout(0, 1)); 
		actionManager=new ActionManager();
		stateManager=new StateManager();
		factory=new Factory();
		
		slotStateManager=new SlotStateManager();
		Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize =kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
   	   // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("RuDok oradovic6920rn");
        Image img=kit.getImage("images/logo.jpg");
		setIconImage(img);
		menu=new Menu();
		setJMenuBar(menu);
		toolbar=new Toolbar();
		add(toolbar,BorderLayout.NORTH);
		blank=new JTabbedPane();
		JScrollPane stablo=new JScrollPane(workspaceTree,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,stablo,blank);
		split.setDividerLocation(230);
		placeholder.add(split);
		add(placeholder);
		this.addWindowListener(new AutoSaveListener());
		workspaceModel.addSub(this);
		this.update(workspaceModel);
		SwingUtilities.updateComponentTreeUI(workspaceTree);
	}
	
	private void empty() {
		menu=new Menu();
		setJMenuBar(menu);
	}
	
	private void autoLoad() {
		SelectWorkspaceView selectWorkspace=new SelectWorkspaceView(this);
			RuTreeNode ruTreeNode = null;
			if(stariKontekst) {
				workspaceModel=new WorkspaceModel("Workspace",null);
				Reader input;
				try {
				    Scanner scanner = new Scanner(new File((this.getClass().getProtectionDomain().getCodeSource().getLocation()+"workspace.txt").substring(5)));
				    while (scanner.hasNextLine()) {
				    	try {
				    		String file=scanner.nextLine();
        					ObjectInputStream outputStream = new ObjectInputStream(new FileInputStream(file));
        					ProjekatModel projekatModel=null;
        					try {
        						projekatModel = (ProjekatModel) outputStream.readObject();
        						projekatModel.setProjekatFile(new File(file));
        					} catch (ClassNotFoundException exception) {
        						// TODO Auto-generated catch block
        						exception.printStackTrace();
        					}
        					workspaceModel.addChild(projekatModel);
        				} catch (FileNotFoundException e1) {
        					e1.printStackTrace();
        				} catch (IOException e1) {
        					e1.printStackTrace();
        				} 
				    }
				    scanner.close();
				        
				} catch (FileNotFoundException ex) {
				    ex.printStackTrace();
				}
			} 
			else {
				JFileChooser jFileChooser = new JFileChooser();
				if(jFileChooser.showOpenDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
					try {
						ObjectInputStream outputStream = new ObjectInputStream(new FileInputStream(jFileChooser.getSelectedFile()));
						try {
							workspaceModel = (WorkspaceModel) outputStream.readObject();
						} catch (ClassNotFoundException exception) {
							workspaceModel=new WorkspaceModel("Workspace",null);
							exception.printStackTrace();
						}
						ruTreeNode =new RuTreeNode(workspaceModel);
						DefaultTreeModel model=new DefaultTreeModel(ruTreeNode);
						workspaceTree=new WorkspaceTree(model);					      
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} 
			}
			}
			ruTreeNode = new RuTreeNode(workspaceModel);
			DefaultTreeModel model=new DefaultTreeModel(ruTreeNode);
			workspaceTree=new WorkspaceTree(model);
	}
	
	public Menu getMenu() {
		return menu;
	}


	public JToolBar getToolbar() {
		return toolbar;
	}
	public ActionManager getActionManager() {
		return actionManager;
	}

	public void setActionManager(ActionManager actionManager) {
		this.actionManager = actionManager;
	}
	public static MainFrame getInstance() {
		if(instance==null) {
			instance= new MainFrame();
			
			instance.autoLoad();
		instance.initialise();
		}
 		return instance;
	}

	public WorkspaceTree getWorkspaceTree() {
		return workspaceTree;
	}
	public void setWorkspaceTree(WorkspaceTree workspaceTree) {
		this.workspaceTree = workspaceTree;
	}
	public WorkspaceModel getWorkspaceModel() {
		return workspaceModel;
	}
	public void setWorkspaceModel(WorkspaceModel workspaceModel) {
		this.workspaceModel = workspaceModel;
	}
	@Override
	public void update(Object notification) throws ArrayIndexOutOfBoundsException {
			blank.removeAll();
		for(RuNode ruNode:this.workspaceModel.getChildren()){
			ProjekatModel projekatModel=(ProjekatModel)ruNode;
			ProjekatGui projekatGui=new ProjekatGui(projekatModel);
			projekatGui.refresh(projekatModel);
			blank.add(projekatGui,projekatModel.getName());
			
		}
		blank.updateUI();
		}
    public JTabbedPane getJtab() {
		return blank;
	}
    
	public PrezentacijaModel getShare() {
		return share;
	}

	public void setShare(PrezentacijaModel share) {
		this.share = share;
	}

	public void startSlideshow(Object object) {
		stateManager.setSlideshowState();
		slotStateManager.setSelectState();
		placeholder.removeAll();
		placeholder.updateUI();
		SlideshowView slideshowView=new SlideshowView((PrezentacijaModel)object);
		placeholder.add(slideshowView);
		placeholder.updateUI();
	}
	public void cancelSlideshow() {
		placeholder.removeAll();
		JScrollPane stablo=new JScrollPane(workspaceTree,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,stablo,blank);
		split.setDividerLocation(230);
		placeholder.add(split);
		placeholder.updateUI();
	}
    public JPanel getPlaceholder() {
		return placeholder;
	}
	public JTabbedPane getBlank() {
		return blank;
	}

	public boolean isStariKontekst() {
		return stariKontekst;
	}

	public void setStariKontekst(boolean stariKontekst) {
		this.stariKontekst = stariKontekst;
	}
	
}
	
	
	


