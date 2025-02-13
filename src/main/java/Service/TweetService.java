package Service;

import Entity.Tweet;

import java.util.List;

public interface TweetService {
    Tweet createTweet(Tweet tweet);
    void deleteTweet(Long tweetId,Long userId);
    Tweet updateTweet(Long tweetId,Tweet tweet);
    List<Tweet> getTweetsByUserId(Long userId);
    Tweet getTweetById(Long tweetId);
}
