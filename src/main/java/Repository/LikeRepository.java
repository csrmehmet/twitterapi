package Repository;

import Entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    boolean existsByUserIdTweetId(Long userId,Long tweetId);
    void deleteByUserIdTweetId(Long userId,Long tweetId);

}
