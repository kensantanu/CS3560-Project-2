import javax.swing.tree.DefaultTreeModel;

public class AdminControlPanel {
	
	// create singleton object
	private static AdminControlPanel obj;	
	
	// local variables
	Node root = new Node("Root");
	DefaultTreeModel treeModel = new DefaultTreeModel(root);
		
	// private constructor
    private AdminControlPanel()
    {
    	new MainPanel();
    }
 
    // singleton object getter
    public static synchronized AdminControlPanel getAdminControlPanel()
    {
        if (obj==null)
            obj = new AdminControlPanel();
        return obj;
    }
	
}
