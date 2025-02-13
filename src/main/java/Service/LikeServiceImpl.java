package Service;

import Entity.Like;
import Entity.Tweet;
import Entity.User;
import Repository.LikeRepository;
import Repository.TweetRepository;
import Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService{

    private final LikeRepository likeRepository;
    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    public LikeServiceImpl(LikeRepository likeRepository, TweetRepository tweetRepository, UserRepository userRepository) {
        this.likeRepository = likeRepository;
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Like addLike(Long tweetId, Long userId) {
        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(
                ()-> new RuntimeException("Tweet not found")
        );
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new RuntimeException("User not Found")
        );
        if (likeRepository.findByTweetIdAndUserId(tweetId,userId).isPresent()){
            throw new RuntimeException("tweet already liked");
        }
        Like like = new Like();
        like.setTweet(tweet);
        like.setUser(user);
        return likeRepository.save(like);
    }

    @Override
    public void removeLike(Long tweetId, Long userId) {
        Like like = likeRepository.findByTweetIdAndUserId(tweetId,userId).orElseThrow(
                ()-> new RuntimeException("Like not Found")
        );
        likeRepository.delete(like);
    }
}
