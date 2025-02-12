package Service;

import Entity.Tweet;

import java.util.List;

public interface TweetService {
    Tweet createTweet(Tweet tweet);
    void deleteTweet(Long tweetId,Long userId);
    Tweet updateTweet(Long tweetId,Tweet tweet,Long userId);
    List<Tweet> getTweetsByUserId(Long userId);
    Tweet getTweetById(Long tweetId);
}
