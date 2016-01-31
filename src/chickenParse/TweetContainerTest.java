package chickenParse;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TweetContainerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestTweetContainer() {
		Tweet tweet1 = new Tweet("new york, the. #art.maxx http://cartfisk.com/resume.pdf @hot #hashtog @ @.cgjas http://google.com @cartfisk");
		//mentions: hot, cartfisk | hashtags: art hashtog | urls: http://cartfisk.com/resume.pdf, http://google.com
		Tweet tweet2 = new Tweet("#thishashtagshouldendhere,nothere @tweet2");
		//mentions: tweet2 | hashtags: thishashtagshouldendhere | urls: 
		Tweet tweet3 = new Tweet("test @cartfisk @doitbig.swag .@.sghain http://zombo.com/ #new");
		//mentions: cartfisk, doitbig | hashtags: new | urls: https://zombo.com/ 
		TweetContainer tweets = new TweetContainer();
		tweets.addTweet(tweet1);
		tweets.addTweet(tweet2);
		tweets.addTweet(tweet3);
		assertEquals(3, tweets.getSize());
	}
	
	@Test
	public void TestGetAllMentions() {
		Tweet tweet1 = new Tweet("@cartfisk");
		//mentions: hot, cartfisk | hashtags: art hashtog | urls: http://cartfisk.com/resume.pdf, http://google.com
		Tweet tweet2 = new Tweet("@cartfisk1");
		//mentions: tweet2 | hashtags: thishashtagshouldendhere | urls: 
		Tweet tweet3 = new Tweet("@cartfisk2");
		//mentions: cartfisk, doitbig | hashtags: new | urls: https://zombo.com/ 
		TweetContainer tweets2 = new TweetContainer();
		tweets2.addTweet(tweet1);
		tweets2.addTweet(tweet2);
		tweets2.addTweet(tweet3);
		ArrayList<String> expectedMentions = new ArrayList<String>();
		expectedMentions.add("cartfisk");
		expectedMentions.add("cartfisk1");
		expectedMentions.add("cartfisk2");
		for (String mention : expectedMentions) {
			assertEquals(true, tweets2.getAllMentions().contains(mention));
		}
	}

}
