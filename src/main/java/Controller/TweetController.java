package Controller;

import Entity.Tweet;
import Service.TweetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweet")
public class TweetController {

    private final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @PostMapping
    public ResponseEntity<Tweet> createTweet(@RequestBody Tweet tweet) {
        return ResponseEntity.ok(tweetService.createTweet(tweet));
    }

    @GetMapping("/findByUserId")
    public ResponseEntity<List<Tweet>> getTweetsByUserId(@RequestParam Long userId) {
        return ResponseEntity.ok(tweetService.getTweetsByUserId(userId));
    }

    @GetMapping("/findById")
    public ResponseEntity<Tweet> getTweetById(@RequestParam Long tweetId) {
        return ResponseEntity.ok(tweetService.getTweetById(tweetId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tweet> updateTweet(@PathVariable Long id, @RequestBody Tweet tweet) {
        return ResponseEntity.ok(tweetService.updateTweet(id, tweet));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTweet(@PathVariable Long id, @RequestParam Long userId) {
        tweetService.deleteTweet(id, userId);
        return ResponseEntity.ok("Tweet deleted");
    }
}

