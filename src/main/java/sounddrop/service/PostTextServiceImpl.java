package sounddrop.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sounddrop.model.Post;
import sounddrop.model.PostText;
import sounddrop.model.User;
import sounddrop.repository.PostTextRepository;
import sounddrop.repository.UserRepository;

@Service
public class PostTextServiceImpl implements PostTextService {

    @Autowired
    private PostTextRepository postTextRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserService userService;
    

    @Autowired
    private PostService postService;
  
    //Save PostText
    @Override
    public void save(PostText postText, String name) {
		User user = userRepository.findByUsername(name);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        postText.setContent(postText.getContent()); 
        postText.setPublishTime(timestamp);
		postText.setUser(user);
		postText.setComments(postText.getComments());
		postTextRepository.save(postText);
		postService.save(postText, null);
        
    }

 //Update PostText
    @Override
    public void update(PostText postText) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        postText.setContent(postText.getContent()); 
        postText.setPublishTime(timestamp);
		postText.setUser(postText.getUser());
		postText.setComments(postText.getComments());
		postTextRepository.save(postText);
		Post post = postService.findByPostText(postText);
		postService.update(postText, null, post);
        
    }
    
    //Get all PostText
    @Override
	public List<PostText> getAllPostText() {
    	List<PostText> postTextList = postTextRepository.findAll();
    	
    	return postTextList;
	}
    
    //Find PostTexts by user
    @Override
    public List<PostText> findByUser(String username){
    	List<PostText> postTextList = postTextRepository.findByUser(userService.findByUsername(username));
    	return postTextList;
    }
    
    


    //Delete postText
	public void delete(PostText postText) {
			 postTextRepository.delete(postText);
	}
	
	//Find by id
	public PostText findByPostTextId(long id) {
		return postTextRepository.findByPostTextId(id);
	}


	
    
}

