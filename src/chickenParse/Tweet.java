package chickenParse;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tweet {

	private String tweetstring;
	private ArrayList<String> mentions;
	private ArrayList<String> hashtags;
	private ArrayList<String> urls;

	public Tweet(String tweetstring) {
		this.tweetstring = tweetstring;
		this.mentions = this.parseMentions();
		this.hashtags = this.parseHashtags();
		this.urls = new ArrayList<String>();
	}
	
	public ArrayList<String> parseMentions() {
		
		String tweet = this.tweetstring;
		Pattern MY_PATTERN = Pattern.compile("(?:\\s|\\A)[@]+([A-Za-z0-9-_]+)");
		Matcher match = MY_PATTERN.matcher(tweet);
		ArrayList<String> mentions=new ArrayList<String>();
		while (match.find()) {
		  //System.out.println(match.group(1));
		  mentions.add(match.group(1));
		}
		if (mentions.size() > 0) {
			return mentions;
		}
		else {
			return null;
		}
		
	}
	
	public ArrayList<String> parseHashtags() {
		
		String tweet = this.tweetstring;
		Pattern MY_PATTERN = Pattern.compile("(?:\\s|\\A)[#]+([A-Za-z0-9-_]+)");
		Matcher match = MY_PATTERN.matcher(tweet);
		ArrayList<String> hashtags=new ArrayList<String>();
		while (match.find()) {
		  //System.out.println(match.group(1));
		  hashtags.add(match.group(1));
		}
		if (hashtags.size() > 0) {
			return hashtags;
		}
		else {
			return null;
		}
		
	}
	
	/*
	public ArrayList<String> parseUrls() {
		
		String tweet = this.tweetstring;
		Pattern MY_PATTERN = Pattern.compile("(?:\\s|\\A)[#]+([A-Za-z0-9-_]+)");
		Matcher match = MY_PATTERN.matcher(tweet);
		ArrayList<String> urls=new ArrayList<String>();
		while (match.find()) {
		  //System.out.println(match.group(1));
		  urls.add(match.group(1));
		}
		if (urls.size() > 0) {
			return urls;
		}
		else {
			return null;
		}
		
	}
	*/
	
	
	// /[A-Za-z]+://[A-Za-z0-9-_]+.[A-Za-z0-9-_:%&~?/.=]+/g
	
	public ArrayList<String> addMentions() {
		ArrayList<String> mentions = new ArrayList<String>();
		mentions.add("cartfisk");
		mentions.add("hot");
		return mentions;
	}
	
	public boolean isMention(String mention){
		if (this.mentions.contains(mention)) {
			return true;
		}
		return false;
	}
	
	public boolean isHashtag(String hashtag){
		if (this.hashtags.contains(hashtag)) {
			return true;
		}
		return false;
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
