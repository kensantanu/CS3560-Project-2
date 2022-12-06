import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.tree.TreeNode;

public class ValidateVisitor implements Visitor {
	
	// local variables
	private int invalidNode = 0;
	private Vector<String> userIDs = new Vector<String>();
	private Vector<String> groupIDs = new Vector<String>();
	private Vector<String> invalids = new Vector<String>(); 
	
	@Override
	public int visit(Node root) {
		
		Enumeration<TreeNode> enumRoot = root.breadthFirstEnumeration();
		 
		while (enumRoot.hasMoreElements())
		{		 
			Node i = (Node) enumRoot.nextElement();
			 
			if (i instanceof User)
			{
				String id = i.getID();
				
				if(userIDs.contains(id))
				{
					invalids.add(id + " (Duplicate user name)");				
					invalidNode++;
				}
				else if(id.contains(" "))
				{
					invalids.add(id + " (User name contains a space)");				
					invalidNode++;
				}
				else
				{
					userIDs.add(id);
				}
				
			}
			
			if (i instanceof UserGroup)
			{
				String id = i.getID();
				
				if(groupIDs.contains(id))
				{
					invalids.add(id + " (Duplicate group name)");				
					invalidNode++;
				}
				else if(id.contains(" "))
				{
					invalids.add(id + " (Group name contains a space)");				
					invalidNode++;
				}
				else
				{
					groupIDs.add(id);
				}
				
			}
			 
		}
		
		if (invalidNode == 0)
		{
			JOptionPane.showMessageDialog(null, "No invalid IDs", "Validation Result",JOptionPane.PLAIN_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, invalids, "Validation Result",JOptionPane.PLAIN_MESSAGE);
		}
		
		return invalidNode;
	}

}
