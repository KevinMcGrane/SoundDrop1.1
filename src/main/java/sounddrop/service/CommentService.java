package sounddrop.service;

import sounddrop.model.Comment;
import sounddrop.model.PostText;

public interface CommentService {
	
	 void save(Comment comment, String name, PostText post);

}
