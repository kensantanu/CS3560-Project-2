import java.util.Vector;

public class User extends Node implements Subject, Observer{
	
	// local variables
	private String userID;
	private Vector<User> follower = new Vector<User>();
	private Vector<User> following = new Vector<User>();
	private Vector<String> feeds = new Vector<String>();
	
	public User(String iD) {
		userID = iD;
	}
	
	// getters & setters
	public Vector<User> getFollower() {
		return follower;
	}
	
	public Vector<User> getFollowing() {
		return following;
	}
	
	public Vector<String> getFeeds() {
		return feeds;
	}
	
	@Override
	public String getID() {
		return userID;
	}

	@Override
	public void setID(String iD) {
		userID = iD;
		
	}
	
	@Override
	public String toString() {
		return userID;
	}
	
	// methods
	public String getLastTweet()
	{
		return feeds.lastElement();
	}
	
	@Override
	public void follow(Observer observer) {
		if (observer instanceof User)
		{
			following.add((User) observer);
			((User) observer).getFollower().add(this);
		}
	}

	@Override
	public void notifyTweet() {
		for (User u: follower)
		{
			u.update(this);
		}
		
	}

	@Override
	public void update(Subject subject) {
		if (subject instanceof User)
		{
			User followed = (User) subject;
			feeds.add(followed.getLastTweet());
			
		}
		
	}

}
