package sounddrop.service;
import java.util.List;
import java.util.Set;

import sounddrop.model.PostText;
import sounddrop.model.User;


public interface PostTextService {

	void save(PostText postText, String name);
	void delete(PostText postText);
	
	public List<PostText> getAllPostText();


	List<PostText> getFeed(Set<User> friends, String username);

	List<PostText> findByUser(String username);
	public PostText findByPostTextId(long id);
	
}
