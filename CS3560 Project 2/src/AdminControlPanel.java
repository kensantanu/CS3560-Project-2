public class AdminControlPanel {
	
	// create singleton object
	private static AdminControlPanel obj;	
		
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
