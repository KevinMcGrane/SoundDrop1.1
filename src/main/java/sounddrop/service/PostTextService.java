package sounddrop.service;
import java.util.List;
import sounddrop.model.PostText;


public interface PostTextService {

	void save(PostText postText, String name);
	void delete(PostText postText);
	
	public List<PostText> getAllPostText();


	List<PostText> findByUser(String username);
	public PostText findByPostTextId(long id);
	void update(PostText postText);
	
}
