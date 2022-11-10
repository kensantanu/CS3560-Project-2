import java.util.Enumeration;

import javax.swing.tree.TreeNode;

public class GroupVisitor implements Visitor {
	
	// local variables
	private int userGroupCount;
	
	@Override
	public int visit(Node root) {
		
		Enumeration<TreeNode> enumRoot = root.breadthFirstEnumeration();
		 
		while (enumRoot.hasMoreElements())
		{		 
			Node i = (Node) enumRoot.nextElement();
			 
			if (i instanceof UserGroup)
			{
				userGroupCount++;
			}
			 
		}
		
		return userGroupCount;
	}

}
