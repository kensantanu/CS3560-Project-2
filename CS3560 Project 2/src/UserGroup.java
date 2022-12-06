public class UserGroup extends Node implements Visitable {
	
	// local variables
	private String groupID;
	private long creationTime;
	
	// constructor
	public UserGroup(String ID)
	{
		groupID = ID;
		creationTime = System.currentTimeMillis();
	}

	// getters & setters
	@Override
	public String getID() {
		return groupID;
	}
	
	@Override
	public long getCreationTime() {
		return creationTime;
	}

	@Override
	public void setID(String iD) {
		groupID = iD;
		
	}
	
	@Override
	public String toString() {
		return groupID;
	}
	
	@Override
	public int accept(Visitor visitor) {
		return visitor.visit(this);		
	}

}
