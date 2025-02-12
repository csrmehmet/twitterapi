package Service;

import Entity.Retweet;

public interface RetweetService {
    Retweet createRetweet(Long tweetId,Long userId);
    void deleteRetweet(Long retweetId,Long userId);
}
