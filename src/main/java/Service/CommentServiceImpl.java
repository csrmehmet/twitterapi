package Service;

import Entity.Comment;
import Entity.Tweet;
import Repository.CommentRepository;
import Repository.TweetRepository;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    private  final CommentRepository commentRepository;
    private  final TweetRepository tweetRepository;
    public CommentServiceImpl(CommentRepository commentRepository, TweetRepository tweetRepository) {
        this.commentRepository = commentRepository;
        this.tweetRepository = tweetRepository;
    }

    @Override
    public Comment createComment(Comment comment) {
        Long tweetId = comment.getTweet().getId();
        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(
                ()-> new RuntimeException("Tweet not found")
        );
        comment.setTweet(tweet);
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Long commentId, Comment comment, Long userId) {
        Comment existComment = commentRepository.findById(commentId).orElseThrow(
                ()-> new RuntimeException("comment not found")
        );
        if (!existComment.getUser().getId().equals(userId)){
            throw new RuntimeException("LOGIN");
        }
        existComment.setText(comment.getText());
        return commentRepository.save(existComment);
    }

    @Override
    public void deleteComment(Long commentId, Long userId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                ()-> new RuntimeException("Comment not found")
        );
        if (comment.getUser().getId().equals(userId)||comment.getTweet().getUser().getId().equals(userId)) {
        commentRepository.delete(comment);
        }
        }


    @Override
    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(
                ()-> new RuntimeException("Comment not found")
        );
    }

    @Override
    public List<Comment> getCommentsByTweetId(Long tweetId) {
        return commentRepository.findByTweetId(tweetId);
    }
}
