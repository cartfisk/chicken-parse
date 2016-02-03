package chickenParse;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tweet {

	private String tweetstring;
	private ArrayList<String> mentions;
	private ArrayList<String> hashtags;
	private ArrayList<String> urls;
	private String regexMention = "(?:\\s|\\A)[@]+([A-Za-z0-9-_]{1,15})"; 
	private String regexHashtag = "(?:\\s|\\A)[#]+([A-Za-z0-9-_]+)";
	private String regexUrl = "\\(?\\b(http://|www[.])[-A-Za-z0-9+&amp;@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&amp;@#/%=~_()|]";

	public Tweet(String tweetstring) {
		this.tweetstring = tweetstring;
		this.mentions = this.parse(regexMention);
		this.hashtags = this.parse(regexHashtag);
		this.urls = this.parse(regexUrl);
		//this could probably be reworked so that the tweet doesn't need to be parsed three times
	}
	
	//called during construction of a Tweet obj.
	//parses mentions, hashtags and urls out one at a time based on the regex string passed to it
	//this could be optimized. should only pose a problem with significant scaling.
	public ArrayList<String> parse(String regex) {
		int group = 1;
		if (regex.equals(regexUrl)) {
			group = 0;
		}
		String tweet = this.tweetstring;
		Pattern MY_PATTERN = Pattern.compile(regex);
		Matcher match = MY_PATTERN.matcher(tweet);
		ArrayList<String> data = new ArrayList<String>();
		while (match.find()) {
		  data.add(match.group(group));
		}
		if (data.size() > 0) {
			return data;
		}
		else {
			return null;
		}
	}

	//checker methods. determines whether a Tweet contains an input string as a mention/hashtag/url
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
	
	public boolean isUrl(String url){
		if (this.urls.contains(url)) {
			return true;
		}
		return false;
	}
	
	
	//getter methods
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
	
	//setter methods (takes in preformed ArrayLists<string> of Tweet data.
	//for testing and perceived use case of inputting pre-parsed data
	public void setString(String tweetstring) {
		this.tweetstring = tweetstring;
	}

	public void setMentions(ArrayList<String> mentions) {
		this.mentions = mentions;
	}
	
	public void getHashtags(ArrayList<String> hashtags) {
		this.hashtags = hashtags;
	}
	
	public void getUrls(ArrayList<String> urls) {
		this.urls = urls;
	}
	
	//adder methods (add a specific piece of data to a certain Tweet) to be added as needed

}
