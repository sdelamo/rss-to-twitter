package com.softamo.rssToSocial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Tweet {
	private Twitter twitter;	
	public Tweet() {		
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File("config.properties")));
			String consumerKey = prop.getProperty("oauth.consumerKey").toString();
			String consumerSecret = prop.getProperty("oauth.consumerSecret").toString();
			String accessToken = prop.getProperty("oauth.accessToken").toString();
			String accessTokenSecret = prop.getProperty("oauth.accessTokenSecret").toString();
			ConfigurationBuilder cb = new ConfigurationBuilder();
			//setDebugEnabled(true).
			cb.setOAuthConsumerKey(consumerKey)
			.setOAuthConsumerSecret(consumerSecret)
			.setOAuthAccessToken(accessToken)
			.setOAuthAccessTokenSecret(accessTokenSecret);
			TwitterFactory tf = new TwitterFactory(cb.build());
			twitter = tf.getInstance();
		} catch (FileNotFoundException e) {
			System.out.println( " " + e.getMessage());
		} catch (IOException e) {
			System.out.println( " " + e.getMessage());
		}		
	}

	public void tweet(String message) {
		try {
			twitter.updateStatus(message);
		} catch (TwitterException e) {
			System.out.println( " " + e.getMessage());
		}		
	}
}