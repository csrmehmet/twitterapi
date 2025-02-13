package Controller;

import Entity.Comment;
import Service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.createComment(comment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment comment, @RequestParam Long userId) {
        return ResponseEntity.ok(commentService.updateComment(id, comment, userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id, @RequestParam Long userId) {
        commentService.deleteComment(id, userId);
        return ResponseEntity.ok("Comment deleted");
    }

    @GetMapping("/findById")
    public ResponseEntity<Comment> getCommentById(@RequestParam Long commentId) {
        return ResponseEntity.ok(commentService.getCommentById(commentId));
    }

    @GetMapping("/findByTweetId")
    public ResponseEntity<List<Comment>> getCommentsByTweetId(@RequestParam Long tweetId) {
        return ResponseEntity.ok(commentService.getCommentsByTweetId(tweetId));
    }
}
