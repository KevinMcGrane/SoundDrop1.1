package sounddrop.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sounddrop.model.Comment;
import sounddrop.model.PostText;
import sounddrop.model.Track;
import sounddrop.model.User;
import sounddrop.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService{
	


    @Autowired
    private CommentRepository commentRepository;

    
	//Save comment on post
	@Override
    public void save(Comment comment, User user, PostText post) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        comment.setContent(comment.getContent()); 
        comment.setPublishTime(timestamp);
		comment.setUser(user);
		comment.setPostText(post);
        commentRepository.save(comment);
    }
	
	//Save comment on track
	@Override
    public void saveTrackComment(Comment comment, User user, Track track) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        comment.setContent(comment.getContent()); 
        comment.setPublishTime(timestamp);
		comment.setUser(user);
		comment.setTrack(track);
        commentRepository.save(comment);
    }
}
