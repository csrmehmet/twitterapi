package Repository;

import Entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TweetRepository extends JpaRepository<Tweet,Long> {
    List<Tweet> findByUserId(Long userId);
}
