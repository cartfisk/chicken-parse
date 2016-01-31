package chickenParse;

import java.util.ArrayList;

public class Tweet {

	private String tweetstring;
	private ArrayList<String> mentions;
	private ArrayList<String> hashtags;
	private ArrayList<String> urls;

	public Tweet(String tweetstring) {
		this.tweetstring = tweetstring;
		this.mentions = this.parseMentions();
		this.hashtags = new ArrayList<>();
		this.urls = new ArrayList<>();
	}
	
	public ArrayList<String> parseMentions() {
		String[] mentionsArray = this.tweetstring.split("(?:\\s|\\A)[@]+([A-Za-z0-9-_]+)");
		//String[] mentionsArray = {"hot", "cartfisk"};
		int length = mentionsArray.length;
		if (length > 0){
			ArrayList<String> mentions = new ArrayList<>();
			for (int i=0; i<length; i++){
				mentions.add(mentionsArray[i]);
			}
			return mentions;
		}
		else {
			ArrayList<String> mentions = new ArrayList<>();
			mentions.add("else");
			return mentions;
		}
		
	}
	
	
	
	public ArrayList<String> addMentions() {
		ArrayList<String> mentions = new ArrayList<>();
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
