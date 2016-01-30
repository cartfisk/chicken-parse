package chickenParse;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TweetContainerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestTweetContainer() {
		Tweet tweet1 = new Tweet("test @cartfisk @hot .@.sghain http://zombo.com/ #new");
		Tweet tweet2 = new Tweet("test @cartfisk @hot .@.sghain http://zombo.com/ #new");
		Tweet tweet3 = new Tweet("test @cartfisk @hot .@.sghain http://zombo.com/ #new");
		TweetContainer tweets = new TweetContainer();
		tweets.addTweet(tweet1);
		tweets.addTweet(tweet2);
		tweets.addTweet(tweet3);
		assertEquals(3, tweets.getSize());
	}

}
