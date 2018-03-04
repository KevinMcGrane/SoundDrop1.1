package sounddrop.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sounddrop.model.Comment;
import sounddrop.model.PostText;
import sounddrop.model.User;
import sounddrop.repository.CommentRepository;
import sounddrop.repository.PostTextRepository;
import sounddrop.repository.UserRepository;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
    private PostTextService postTextService;

    @Autowired
    private CommentRepository commentRepository;
    
    @Autowired
    private UserService userService;
    
	
	@Override
    public void save(Comment comment, String name, PostText post) {
		User user = userService.findByUsername(name);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        comment.setContent(comment.getContent()); 
        comment.setPublishTime(timestamp);
		comment.setUser(user);
        commentRepository.save(comment);
    }

}