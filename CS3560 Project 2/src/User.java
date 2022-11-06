import java.util.Vector;

public class User{
	
	// local variables
	private String userID;
	private Vector<User> follower = new Vector<User>();
	private Vector<User> following = new Vector<User>();
	private Vector<String> feeds = new Vector<String>();
	
	// getters & setters
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public Vector<User> getFollower() {
		return follower;
	}
	public void setFollower(Vector<User> follower) {
		this.follower = follower;
	}
	public Vector<User> getFollowing() {
		return following;
	}
	public void setFollowing(Vector<User> following) {
		this.following = following;
	}
	public Vector<String> getFeeds() {
		return feeds;
	}
	public void setFeeds(Vector<String> feeds) {
		this.feeds = feeds;
	}

}
