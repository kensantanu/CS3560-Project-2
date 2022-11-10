import java.util.Enumeration;
import java.util.Vector;

import javax.swing.tree.TreeNode;

public class TweetVisitor implements Visitor {
	
	// local variables
	private double messageCount;
	private double positiveMessageCount;
	
	@Override
	public int visit(Node root) {
		
		Enumeration<TreeNode> enumRoot = root.breadthFirstEnumeration();
		 
		while (enumRoot.hasMoreElements())
		{		 
			Node i = (Node) enumRoot.nextElement();
			 
			if (i instanceof User)
			{
				Vector<String> tweets = ((User) i).getTweets();				
				
				for (String s: tweets)
				{
					messageCount ++;
					
					if (s.contains("good") || s.contains("great") || s.contains("excellent"))
					{
						positiveMessageCount++;
					}
				}
			}
			 
		}
				
		return (int) ((positiveMessageCount / messageCount) * 100);
	}

}