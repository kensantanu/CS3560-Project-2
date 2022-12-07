import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.tree.TreeNode;

public class LatestTweetVisitor implements Visitor {
	
	// local variables
	private long latestTweetTime = 0;
	private String latestTweetID;
	
	@Override
	public int visit(Node root) {
		
		Enumeration<TreeNode> enumRoot = root.breadthFirstEnumeration();
		 
		while (enumRoot.hasMoreElements())
		{		 
			Node i = (Node) enumRoot.nextElement();
			 
			if (i instanceof User)
			{
				String id = i.getID();
				long time = ((User) i).getLastUpdateTime();
				
				if( time > latestTweetTime)
				{
					latestTweetID = id;
					latestTweetTime = time;
				}
				
			}
			 
		}
		
		if (latestTweetTime == 0)
		{
			JOptionPane.showMessageDialog(null, "No one tweet anything yet", "Latest Tweet",JOptionPane.PLAIN_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Latest tweet by: " + latestTweetID, "Latest Tweet",JOptionPane.PLAIN_MESSAGE);
		}
		
		return 0;
	}

}
