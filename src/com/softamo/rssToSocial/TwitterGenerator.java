package com.softamo.rssToSocial;

public class TwitterGenerator extends SocialNetworkUpdater {
	Tweet tweet = new Tweet();

	public void publish(String message) {
		tweet.tweet(message);
	}
}
