package GUI;

import java.awt.*;
import javax.swing.*;

public class MainPanel {
	
	public MainPanel()
	{
		// create Java swing components
    	JFrame frameMain = new JFrame("Admin Control Panel");

    	JPanel panelTree = new JPanel();
    	JPanel panelUser = new JPanel();
    	JPanel panelStats = new JPanel();
    	
    	JTextField textAddUser = new JTextField();
    	JTextField textAddGroup = new JTextField();
    	   	
    	JButton buttonAddUser = new JButton("Add User");
    	JButton buttonAddGroup = new JButton("Add Group");
    	JButton buttonOpenUserView = new JButton("Open User View");
    	JButton buttonShowTotalUser = new JButton("Show Total User");
    	JButton buttonShowTotalGroup = new JButton("Show Total Group");
    	JButton buttonShowTotalMessages = new JButton("Show Total Messages");
    	JButton buttonShowPositivePercentage = new JButton("Show Positive Percentage");
    	
    	// set text fields properties
    	textAddUser.setPreferredSize(new Dimension(270, 30));
    	textAddGroup.setPreferredSize(new Dimension(270, 30));
    	
    	// set buttons properties
    	buttonAddUser.setPreferredSize(new Dimension(100, 30));
    	buttonAddGroup.setPreferredSize(new Dimension(100, 30));
    	buttonOpenUserView.setPreferredSize(new Dimension(375, 30));
    	buttonShowTotalUser.setPreferredSize(new Dimension(200, 30));
    	buttonShowTotalGroup.setPreferredSize(new Dimension(200, 30));
    	buttonShowTotalMessages.setPreferredSize(new Dimension(200, 30));
    	buttonShowPositivePercentage.setPreferredSize(new Dimension(200, 30));
    		
    	// set panels properties
    	panelTree.setBackground(new Color(245, 248, 250));
    	panelTree.setBounds(0, 0, 400, 600);
    	
    	panelUser.setBackground(new Color(29, 161, 242));
    	panelUser.setBounds(400, 0, 400, 400);
    	panelUser.setLayout(new FlowLayout(FlowLayout.LEFT));
    	panelUser.add(textAddUser);
    	panelUser.add(buttonAddUser);
    	panelUser.add(textAddGroup);
    	panelUser.add(buttonAddGroup);
    	panelUser.add(buttonOpenUserView);
    	  	
    	panelStats.setBackground(new Color(225, 232, 237));
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
    	frameMain.setVisible(true);
	}

}
