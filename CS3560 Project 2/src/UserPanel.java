import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.*;
import javax.swing.tree.TreeNode;

public class UserPanel implements ActionListener{
	
	// local variables
	private User user;
	
	// create Java swing components
	private JFrame frameMain = new JFrame();
	
	private JPanel panelTop = new JPanel();
	private JPanel panelBottom = new JPanel();
	private JPanel panelFollow = new JPanel();
	private JPanel panelTweet = new JPanel();
	
	private JTextField textFollowUser = new JTextField();
	private JTextField textPostTweet = new JTextField();
	
	private JButton buttonFollowUser = new JButton("Follow User");
	private JButton buttonPostTweet = new JButton("Post Tweet");
	
	// constructor
	public UserPanel(User node)
	{    	
		user = node;
		
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
    	
    	panelFollow.setLayout(new BoxLayout (panelFollow, BoxLayout.Y_AXIS));
    	//updatePanelFollow();
    	
    	panelBottom.setBackground(new Color(225, 232, 237));
    	panelBottom.setBounds(0, 200, 400, 200);
    	panelBottom.setLayout(new FlowLayout(FlowLayout.LEFT));
    	panelBottom.add(textPostTweet);
    	panelBottom.add(buttonPostTweet);
    	panelBottom.add(panelTweet);
    	
    	panelTweet.setLayout(new BoxLayout (panelTweet, BoxLayout.Y_AXIS));
		//updatePanelTweet();
    	
    	panelFollow.setBackground(new Color(255, 255, 255));
    	panelFollow.setPreferredSize(new Dimension(375, 155));
    	
    	panelTweet.setBackground(new Color(255, 255, 255));
    	panelTweet.setPreferredSize(new Dimension(375, 115));

    	// set frame properties
    	//frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frameMain.setTitle(user.getID());
    	frameMain.setResizable(false);
    	frameMain.setSize(400, 400);
    	frameMain.setLayout(null);
    	frameMain.add(panelTop);
    	frameMain.add(panelBottom);
    	frameMain.setTitle(user.getID());
    	
	}
	
	public void refreshPanel()
	{
		updatePanelFollow();
		updatePanelTweet();
		frameMain.setTitle(user.getID());	
	}
	
	public void showPanel()
	{
		updatePanelFollow();
		updatePanelTweet();
		frameMain.setTitle(user.getID());
		frameMain.setVisible(true);
	}
	
	private void updatePanelFollow()
	{
		panelFollow.removeAll();
		
		for (User i : user.getFollowing()) {
			panelFollow.add(new JLabel(i.getID()));
        }
		
		panelFollow.revalidate();
		
	}
	
	public void updatePanelTweet()
	{
		panelTweet.removeAll();
		
		for (String i : user.getFeeds()) {
			panelTweet.add(new JLabel(i));
        }
		
		panelTweet.revalidate();
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == buttonFollowUser)
		{
			 Node root = (Node) user.getRoot();
			 
			 Enumeration<TreeNode> enumRoot = root.breadthFirstEnumeration();
			 
			 while (enumRoot.hasMoreElements())
			 {		 
				 Node i = (Node) enumRoot.nextElement();
				 
				 if (i.getID().equals(textFollowUser.getText()))
				 {
					if (i instanceof User)
					{
						 user.follow((User) i);
						 updatePanelFollow();
						 frameMain.setVisible(true);
					}
					
					if (i instanceof UserGroup)
					{
						JOptionPane.showMessageDialog(null, i + " is not a user!", "ERROR",JOptionPane.WARNING_MESSAGE);
					}
					 
				 }
				 
			 }
			 
			 textFollowUser.setText(null);
		}
		
		if (e.getSource() == buttonPostTweet)
		{
			user.getTweets().add(textPostTweet.getText());
			user.getFeeds().add("@" + user.getID() + ": " + textPostTweet.getText());
			panelTweet.add(new JLabel(user.getLastTweet()));
			updatePanelTweet();
			frameMain.setVisible(true);
			textPostTweet.setText(null);
			
			// notify all followers (Observer)
			user.notifyTweet();
			
		}
		
	}
}
