package Service;

import Entity.Like;

public interface LikeService {
    Like addLike(Long tweetId,Long userId);
    void removeLike(Long tweetId,Long userId);

}
