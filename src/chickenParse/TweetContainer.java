package chickenParse;

import java.util.ArrayList;

//this class is semi-useless in its current state but, at scalel, this project will benefit from an organized class to deal with collections of Tweets

//TODO: add methods to return all Tweets that mention a specific username, or contain a specific hashtag/url.
//TODO: add methods to return the number of Tweets containing a specific piece of data (rather than the tweets themselves)
//TODO: add methods to sort data within a TweetContainer
//TODO: add methods to compare two or more tweet containers

public class TweetContainer {

	private ArrayList<Tweet> tweets;
	private ArrayList<String> mentions;
	private ArrayList<String> hashtags;
	private ArrayList<String> urls;

	
	//right now there's not much more to this class than just being a simple ArrayList
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
	
	//getAll methods. currently sets the container's attributes to the same thing as what it returns, depending on usage this behavior can be eliminated
	public ArrayList<String> getAllMentions() {
		this.mentions = new ArrayList<String>();
		for (Tweet tweet : this.getTweets()) {
			for (String mention : tweet.getMentions()){
				this.mentions.add(mention);
			}
		}
		return this.mentions;
	}
	public ArrayList<String> getAllHashtags() {
		this.hashtags = new ArrayList<String>();
		for (Tweet tweet : this.getTweets()) {
			for (String hashtag : tweet.getHashtags()){
				this.hashtags.add(hashtag);
			}
		}
		return this.hashtags;
	}

	public ArrayList<String> getAllUrls() {
		this.urls = new ArrayList<String>();
		for (Tweet tweet : this.getTweets()) {
			for (String url : tweet.getUrls()){
				this.urls.add(url);
			}
		}
		return this.urls;
	}
	
	
	
}

