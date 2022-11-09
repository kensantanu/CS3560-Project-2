public class UserGroup extends Node {
	
	// local variables
	private String groupID;
	
	// constructor
	public UserGroup(String ID)
	{
		groupID = ID;
	}

	// getters & setters
	@Override
	public String getID() {
		return groupID;
	}

	@Override
	public void setID(String iD) {
		groupID = iD;
		
	}
	
	@Override
	public String toString() {
		return groupID;
	}

}
