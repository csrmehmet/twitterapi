package Service;

import Entity.Tweet;
import Repository.TweetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TweetServiceImpl implements TweetService{

    private final TweetRepository tweetRepository;

    public TweetServiceImpl(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }


    @Override
    public Tweet createTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    @Override
    public void deleteTweet(Long tweetId, Long userId) {
        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(()->
                new RuntimeException("Tweet nof found"));
        if (tweet.getUser().getId().equals(userId)){
            tweetRepository.delete(tweet);
        }
        else {
            throw new RuntimeException("login");

        }
    }

    @Override
    public Tweet updateTweet(Long tweetId, Tweet tweet) {
        Tweet existTweet = tweetRepository.findById(tweetId).orElseThrow(()->
                new RuntimeException("Tweet not found")) ;
        existTweet.setContent(tweet.getContent());
        return tweetRepository.save(existTweet);
    }

    @Override
    public List<Tweet> getTweetsByUserId(Long userId) {
        return tweetRepository.findByUserId(userId);
    }

    @Override
    public Tweet getTweetById(Long tweetId) {
        return tweetRepository.findById(tweetId).orElseThrow(
                ()-> new RuntimeException("Tweet not found")
        );
    }
}
