package chickenParse;

import java.util.ArrayList;

public class Tweet {

	private String tweetstring;
	private ArrayList<String> mentions;
	private ArrayList<String> hashtags;
	private ArrayList<String> urls;

	public Tweet(String tweetstring) {
		this.tweetstring = tweetstring;
		this.mentions = this.addMentions();
		this.hashtags = new ArrayList<>();
		this.urls = new ArrayList<>();
	}
	
	public ArrayList<String> parseMentions() {
		int length = this.tweetstring.length();
		char[] tweet = this.tweetstring.toCharArray();
		ArrayList<String> mentions = new ArrayList<>();
		
		
		/* for (int i=0; i>length; i++){
			if (tweet[i] == '@') {	
				char[] mention = {};
				int j = 1;
				while (tweet[i+j] != ' ' || tweet[i+j] != '.' || tweet[i+j] != ','){
					mention[j--] = tweet[i+j];
					i++;
				}
				mentions.add(mention.toString());
			}
		}
		return mentions; */
	}
	
	public ArrayList<String> addMentions() {
		ArrayList<String> mentions = new ArrayList<>();
		mentions.add("cartfisk");
		mentions.add("hot");
		return mentions;
	}
	
	public boolean isMention(String mention){
		for (int i=0; i<this.mentions.size(); i++) {
			if (mentions.contains(mention)) {
				return true;
			}
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
