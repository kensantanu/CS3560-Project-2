package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UserPanel implements ActionListener{
	
	// create Java swing components
	private JFrame frameMain = new JFrame("User");
	
	private JPanel panelTop = new JPanel();
	private JPanel panelBottom = new JPanel();
	private JPanel panelFollow = new JPanel();
	private JPanel panelTweet = new JPanel();
	
	private JTextField textFollowUser = new JTextField();
	private JTextField textPostTweet = new JTextField();
	
	private JButton buttonFollowUser = new JButton("Follow User");
	private JButton buttonPostTweet = new JButton("Post Tweet");

	public UserPanel()
	{    	
    	// set text fields properties
    	textFollowUser.setPreferredSize(new Dimension(270, 30));
    	textPostTweet.setPreferredSize(new Dimension(270, 30));
    	
    	// set buttons properties
    	buttonFollowUser.setPreferredSize(new Dimension(100, 30));
    	buttonFollowUser.setFocusable(false);
    	buttonFollowUser.addActionListener(this);
    	buttonPostTweet.setPreferredSize(new Dimension(100, 30));
    	buttonPostTweet.setFocusable(false);
    	buttonPostTweet.addActionListener(this);
    	
    	// set panels properties
    	panelTop.setBackground(new Color(29, 161, 242));
    	panelTop.setBounds(0, 0, 400, 200);
    	panelTop.setLayout(new FlowLayout(FlowLayout.LEFT));
    	panelTop.add(textFollowUser);
    	panelTop.add(buttonFollowUser);
    	panelTop.add(panelFollow);
    	
    	panelBottom.setBackground(new Color(225, 232, 237));
    	panelBottom.setBounds(0, 200, 400, 200);
    	panelBottom.setLayout(new FlowLayout(FlowLayout.LEFT));
    	panelBottom.add(textPostTweet);
    	panelBottom.add(buttonPostTweet);
    	panelBottom.add(panelTweet);
    	
    	panelFollow.setBackground(new Color(255, 255, 255));
    	panelFollow.setPreferredSize(new Dimension(375, 155));
    	
    	panelTweet.setBackground(new Color(255, 255, 255));
    	panelTweet.setPreferredSize(new Dimension(375, 115));

    	// set frame properties
    	//frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frameMain.setResizable(false);
    	frameMain.setSize(400, 400);
    	frameMain.setLayout(null);
    	frameMain.add(panelTop);
    	frameMain.add(panelBottom);
    	frameMain.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
