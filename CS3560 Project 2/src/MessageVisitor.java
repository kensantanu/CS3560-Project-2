import java.util.Enumeration;
import java.util.Vector;

import javax.swing.tree.TreeNode;

public class MessageVisitor implements Visitor {
	
	// local variables
	private int messageCount;
	
	@Override
	public int visit(Node root) {
		
		Enumeration<TreeNode> enumRoot = root.breadthFirstEnumeration();
		 
		while (enumRoot.hasMoreElements())
		{		 
			Node i = (Node) enumRoot.nextElement();
			 
			if (i instanceof User)
			{
				Vector<String> tweets = ((User) i).getTweets();
				
				messageCount += tweets.size();
			}
			 
		}
		
		return messageCount;
	}

}
