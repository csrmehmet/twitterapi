package Controller;

import Entity.Retweet;
import Service.RetweetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/retweet")
public class RetweetController {

    private final RetweetService retweetService;

    public RetweetController(RetweetService retweetService) {
        this.retweetService = retweetService;
    }

    @PostMapping
    public ResponseEntity<Retweet> createRetweet(@RequestParam Long tweetId, @RequestParam Long userId) {
        return ResponseEntity.ok(retweetService.createRetweet(tweetId, userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRetweet(@PathVariable Long id, @RequestParam Long userId) {
        retweetService.deleteRetweet(id, userId);
        return ResponseEntity.ok("Retweet removed");
    }
}
