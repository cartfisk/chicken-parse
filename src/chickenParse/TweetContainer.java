package chickenParse;

import java.util.ArrayList;

public class TweetContainer {

	private ArrayList<Tweet> tweets;
	private ArrayList<String> mentions;
	private ArrayList<String> hashtags;
	private ArrayList<String> urls;
	
	public TweetContainer() {
		this.tweets = new ArrayList<>();
	}
	
	public void addTweet(Tweet tweet) {
		this.tweets.add(tweet);
	}
	
	public int getSize() {
		return this.tweets.size();
	}
	
	public ArrayList<Tweet> getTweets() {
		return this.tweets;
	}
	
	public ArrayList<String> getAllMentions() {
		for (Tweet tweet : this.getTweets()) {
			for (String mention : tweet.getMentions()){
				this.mentions.add(mention);
			}
		}
		return this.mentions;
	}
	public ArrayList<String> getAllHashtags() {
		for (Tweet tweet : this.getTweets()) {
			for (String hashtag : tweet.getHashtags()){
				this.hashtags.add(hashtag);
			}
		}
		return this.hashtags;
	}

	public ArrayList<String> getAllUrls() {
		for (Tweet tweet : this.getTweets()) {
			for (String url : tweet.getUrls()){
				this.hashtags.add(url);
			}
		}
		return this.urls;
	}
}

