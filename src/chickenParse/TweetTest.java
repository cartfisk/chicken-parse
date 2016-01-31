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

	private String testTweet = "new york, the. #art.maxx http://cartfisk.com/resume.pdf @hot #hashtog @ @.cgjas http://google.com @cartfisk";
	
	@Test
	public void TestTweet() {
		Tweet tweet = new Tweet(testTweet);
		assertEquals(tweet.getString(), testTweet);
	}
	
	@Test
	public void TestIsMention() {
		Tweet tweet = new Tweet(testTweet);
		assertEquals(true, tweet.isMention("hot"));
		assertEquals(true, tweet.isMention("cartfisk"));
	}
	
	@Test
	public void TestIsHashtag() {
		Tweet tweet = new Tweet(testTweet);
		assertEquals(true, tweet.isHashtag("art"));
		assertEquals(true, tweet.isHashtag("hashtog"));
	}
	
	@Test
	public void TestIsUrl() {
		Tweet tweet = new Tweet(testTweet);
		assertEquals(true, tweet.isUrl("http://cartfisk.com/resume.pdf"));
		assertEquals(true, tweet.isUrl("http://google.com"));
	}
	
	@Test
	public void TestGetMentions() {
		ArrayList<String> expectedMentions = new ArrayList<>();
		expectedMentions.add("hot");
		expectedMentions.add("cartfisk");
		Tweet tweet = new Tweet(testTweet);
		assertEquals(tweet.getMentions(), expectedMentions);
	}
	
	@Test
	public void TestGetHashtags() {
		ArrayList<String> expectedHashtags = new ArrayList<>();
		expectedHashtags.add("art");
		expectedHashtags.add("hashtog");
		Tweet tweet = new Tweet(testTweet);
		assertEquals(tweet.getHashtags(), expectedHashtags);
	}
	
	@Test
	public void TestGetUrls() {
		ArrayList<String> expectedUrls = new ArrayList<>();
		expectedUrls.add("http://cartfisk.com/resume.pdf");
		expectedUrls.add("http://google.com");
		Tweet tweet = new Tweet(testTweet);
		assertEquals(tweet.getUrls(), expectedUrls);
	}

}
