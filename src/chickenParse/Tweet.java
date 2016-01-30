package chickenParse;

import java.util.ArrayList;

public class Tweet {

	private String tweetstring;
	private ArrayList<String> mentions;
	private ArrayList<String> hashtags;
	private ArrayList<String> urls;

	public Tweet(String tweetstring) {
		this.tweetstring = tweetstring;
		this.mentions = new ArrayList<>();
		this.hashtags = new ArrayList<>();
		this.urls = new ArrayList<>();
	}
	
	public void parseTweet() {
		
	}

	public String getString() {
		return this.tweetstring;
	}

	public ArrayList<String> getMentions() {
		return this.mentions;
	}
	
	public ArrayList<String> getHashtags() {
		return this.hashtags;
	}
	
	public ArrayList<String> getUrls() {
		return this.urls;
	}
	
}
