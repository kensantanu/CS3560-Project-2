import javax.swing.tree.DefaultMutableTreeNode;

public class Node extends DefaultMutableTreeNode{
	
	// local variables
	private String name;

	public Node(String name)
	{
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
