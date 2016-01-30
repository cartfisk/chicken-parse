package chickenParse;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TweetTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestTweet() {
		String tweetstring= "new york, the. cartfisk.com/resume.pdf @hot #hastog @ @.cgjas http://google.com";
		Tweet tweet = new Tweet(tweetstring);
		assertEquals(tweet.getString(), tweetstring);
	}
	
	public void TestGetMentions() {
		String tweetstring = "new york, the. cartfisk.com/resume.pdf @hot #hashtog @ @.cgjas http://google.com @cartfisk";
		ArrayList<String> expectedMentions = new ArrayList<>();
		expectedMentions.add("hot");
		expectedMentions.add("cartfisk");

		Tweet tweet = new Tweet(tweetstring);
		assertEquals(tweet.getMentions(), tweetstring);
	}
	
	public void TestGetHashtags() {
		String tweetstring = "new york, the. cartfisk.com/resume.pdf @hot #hashtog @ @.cgjas http://google.com @cartfisk";
		ArrayList<String> expectedHashtags = new ArrayList<>();
		expectedHashtags.add("hashtag");
		Tweet tweet = new Tweet(tweetstring);
		assertEquals(tweet.getHashtags(), expectedHashtags);
	}
	
	public void TestGetUrls() {
		String tweetstring = "new york, the. cartfisk.com/resume.pdf @hot #hashtog @ @.cgjas http://google.com @cartfisk";
		ArrayList<String> expectedUrls = new ArrayList<>();
		expectedUrls.add("cartfisk.com/resume.pdf");
		expectedUrls.add("http://google.com");
		Tweet tweet = new Tweet(tweetstring);
		assertEquals(tweet.getHashtags(), expectedUrls);
	}
	
	public void TestTweetContainer() {

	}

}
