

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class MainPanel implements ActionListener{
	
	// create Java swing components
	private JFrame frameMain = new JFrame("Admin Control Panel");
	
	
	Node root = new Node("Root");
	DefaultTreeModel treeModel = new DefaultTreeModel(root);
	
	private JTree tree = new JTree(treeModel);

	private JPanel panelTree = new JPanel();
	private JPanel panelUser = new JPanel();
	private JPanel panelStats = new JPanel();
	
	private JTextField textAddUser = new JTextField();
	private JTextField textAddGroup = new JTextField();
	   	
	private JButton buttonAddUser = new JButton("Add User");
	private JButton buttonAddGroup = new JButton("Add Group");
	private JButton buttonOpenUserView = new JButton("Open User View");
	private JButton buttonShowTotalUser = new JButton("Show Total User");
	private JButton buttonShowTotalGroup = new JButton("Show Total Group");
	private JButton buttonShowTotalMessages = new JButton("Show Total Messages");
	private JButton buttonShowPositivePercentage = new JButton("Show Positive Percentage");
	
	public MainPanel()
	{    	
		
		// set tree properties
		tree.setEditable(true);
		tree.setShowsRootHandles(true);
		
    	// set text fields properties
    	textAddUser.setPreferredSize(new Dimension(270, 30));
    	textAddGroup.setPreferredSize(new Dimension(270, 30));
    	
    	// set buttons properties
    	buttonAddUser.setPreferredSize(new Dimension(100, 30));	
    	buttonAddUser.setFocusable(false);
    	buttonAddUser.addActionListener(this);
    	buttonAddGroup.setPreferredSize(new Dimension(100, 30));
    	buttonAddGroup.setFocusable(false);
    	buttonAddGroup.addActionListener(this);
    	buttonOpenUserView.setPreferredSize(new Dimension(375, 30));
    	buttonOpenUserView.setFocusable(false);
    	buttonOpenUserView.addActionListener(this);
    	buttonShowTotalUser.setPreferredSize(new Dimension(200, 30));
    	buttonShowTotalUser.setFocusable(false);
    	buttonShowTotalUser.addActionListener(this);
    	buttonShowTotalGroup.setPreferredSize(new Dimension(200, 30));
    	buttonShowTotalGroup.setFocusable(false);
    	buttonShowTotalGroup.addActionListener(this);
    	buttonShowTotalMessages.setPreferredSize(new Dimension(200, 30));
    	buttonShowTotalMessages.setFocusable(false);
    	buttonShowTotalMessages.addActionListener(this);
    	buttonShowPositivePercentage.setPreferredSize(new Dimension(200, 30));
    	buttonShowPositivePercentage.setFocusable(false);
    	buttonShowPositivePercentage.addActionListener(this);
    		
    	// set panels properties
    	panelTree.setBackground(new Color(225, 232, 237));
    	panelTree.setBounds(0, 0, 400, 600);
    	panelTree.add(tree);
    	
    	panelUser.setBackground(new Color(29, 161, 242));
    	panelUser.setBounds(400, 0, 400, 400);
    	panelUser.setLayout(new FlowLayout(FlowLayout.LEFT));
    	panelUser.add(textAddUser);
    	panelUser.add(buttonAddUser);
    	panelUser.add(textAddGroup);
    	panelUser.add(buttonAddGroup);
    	panelUser.add(buttonOpenUserView);
    	  	
    	panelStats.setBackground(new Color(245, 248, 250));
    	panelStats.setBounds(400, 400, 400, 200);
    	panelStats.add(buttonShowTotalUser);
    	panelStats.add(buttonShowTotalGroup);
    	panelStats.add(buttonShowTotalMessages);
    	panelStats.add(buttonShowPositivePercentage);
    	
    	// set frame properties
    	frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frameMain.setResizable(false);
    	frameMain.setSize(800, 600);
    	frameMain.setLayout(null);
    	frameMain.add(panelTree);
    	frameMain.add(panelUser);
    	frameMain.add(panelStats);
    	tree.setPreferredSize(new Dimension(380, 550));
    	frameMain.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonAddUser)
		{
			Node selectedNode = (Node) tree.getLastSelectedPathComponent();
			selectedNode.add(new Node("New User"));
			treeModel.reload();
		}
		
		if (e.getSource() == buttonAddGroup)
		{
			Node selectedNode = (Node) tree.getLastSelectedPathComponent();
			selectedNode.add(new Node("New Group"));
			treeModel.reload();
		}
		
		if (e.getSource() == buttonOpenUserView)
		{
			new UserPanel((Node) tree.getLastSelectedPathComponent());
		}
		
	}
	
}
