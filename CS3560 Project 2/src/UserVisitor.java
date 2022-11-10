import java.util.Enumeration;
import javax.swing.tree.TreeNode;

public class UserVisitor implements Visitor {
	
	// local variables
	private int userCount;
	
	@Override
	public int visit(Node root) {
		
		Enumeration<TreeNode> enumRoot = root.breadthFirstEnumeration();
		 
		while (enumRoot.hasMoreElements())
		{		 
			Node i = (Node) enumRoot.nextElement();
			 
			if (i instanceof User)
			{
				userCount++;
			}
			 
		}
		
		return userCount;
	}

}
