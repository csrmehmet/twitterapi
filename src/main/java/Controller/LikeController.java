package Controller;

import Entity.Like;
import Service.LikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/like")
    public ResponseEntity<Like> addLike(@RequestParam Long tweetId, @RequestParam Long userId) {
        return ResponseEntity.ok(likeService.addLike(tweetId, userId));
    }

    @PostMapping("/dislike")
    public ResponseEntity<String> removeLike(@RequestParam Long tweetId, @RequestParam Long userId) {
        likeService.removeLike(tweetId, userId);
        return ResponseEntity.ok("Like removed");
    }
}
