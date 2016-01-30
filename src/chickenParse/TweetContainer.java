package chickenParse;

import java.util.ArrayList;

public class TweetContainer {

	private ArrayList<Tweet> tweets;
	
	public TweetContainer() {
		this.tweets = new ArrayList<>();
	}
	
	public void addTweet(Tweet tweet) {
		this.tweets.add(tweet);
	}
	
	public int getSize() {
		return this.tweets.size();
	}

	
	
}
