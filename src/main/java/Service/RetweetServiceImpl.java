package Service;

import Entity.Retweet;
import Entity.Tweet;
import Entity.User;
import Repository.RetweetRepository;
import Repository.TweetRepository;
import Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RetweetServiceImpl implements RetweetService{

    private final RetweetRepository retweetRepository;
    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    public RetweetServiceImpl(RetweetRepository retweetRepository, TweetRepository tweetRepository, UserRepository userRepository) {
        this.retweetRepository = retweetRepository;
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Retweet createRetweet(Long tweetId, Long userId) {
        Tweet tweet = tweetRepository.findById(tweetId)
                .orElseThrow(()->new RuntimeException("Tweet Not Found"));
        User user = userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User Not Found"));
    if (retweetRepository.findByTweetIdAndUserId(tweetId,userId).isPresent()){
        throw new RuntimeException("Alreadt retweet");
    }
    Retweet retweet = new Retweet();
    retweet.setTweet(tweet);
    retweet.setUser(user);
    return retweetRepository.save(retweet);
    }

    @Override
    public void deleteRetweet(Long retweetId, Long userId) {
        Retweet retweet = retweetRepository.findById(retweetId)
                .orElseThrow(() -> new RuntimeException("Retweet not found"));
        if(!retweet.getUser().getId().equals(userId)) {
            throw new RuntimeException("Unauthorized removal");
        }
        retweetRepository.delete(retweet);
    }
}
