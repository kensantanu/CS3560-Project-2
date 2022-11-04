import java.util.*;

import GUI.*;

public class AdminControlPanel {
	
	// create singleton object
	private static AdminControlPanel obj;	
	
	// local variables
	Vector<User> userData = new Vector<User>();
	
	
	// private constructor
    AdminControlPanel()
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
