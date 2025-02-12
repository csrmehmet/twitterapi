package Service;

import Entity.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Comment comment);
    Comment updateComment(Long commentId,Comment comment,Long userId);
    void deleteComment(Long commentId,Long userId);
    Comment getCommentById(Long commentId);
    List<Comment> getCommentsByTweetId(Long tweetId);
}
