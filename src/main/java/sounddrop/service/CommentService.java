package sounddrop.service;

import sounddrop.model.Comment;
import sounddrop.model.PostText;
import sounddrop.model.User;

public interface CommentService {
	
	 void save(Comment comment, User user, PostText post);

}
