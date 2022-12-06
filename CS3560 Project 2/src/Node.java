import javax.swing.tree.DefaultMutableTreeNode;

// composite pattern for User and UserGroup
public abstract class Node extends DefaultMutableTreeNode {

	public abstract String getID();

	public abstract void setID(String iD);
	
	public abstract long getCreationTime();
	
}
