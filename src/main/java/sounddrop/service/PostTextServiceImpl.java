package sounddrop.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sounddrop.model.Post;
import sounddrop.model.PostText;
import sounddrop.model.Track;
import sounddrop.model.User;
import sounddrop.repository.PostTextRepository;
import sounddrop.repository.TrackRepository;
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
    private TrackRepository trackRepository;
    
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
    public void update(PostText postText, String name) {
		User user = userRepository.findByUsername(name);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        postText.setContent(postText.getContent()); 
        postText.setPublishTime(timestamp);
		postText.setUser(user);
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
    
    
//    @Override
//    public List<PostText> getFeed(Set<User> friends, User user){
//    	List<PostText> postTextList = postTextRepository.findByUserIn(friends);
//    	List<Track> trackList = trackRepository.findByUserIn(friends);
//    	List<PostText> myPosts = postTextRepository.findByUser(user);
//    	List<Track> myTracks = trackRepository.findByUser(user);
//    	List<PostText> newList = new ArrayList<PostText>();
//    	newList.addAll(myPosts);
//    	newList.addAll(postTextList);
//    	class OutcomeAscComparator implements Comparator<PostText>
//	    {
//	        public int compare(PostText left, PostText right) {
//	            return right.getPublishTime().compareTo(left.getPublishTime());
//	        }
//	    }
//    	
//    	Collections.sort(newList, new OutcomeAscComparator());
//    	
//    	
//    	return newList;
//    }


    //Delete postText
	public void delete(PostText postText) {
			 postTextRepository.delete(postText);
	}
	
	//Find by id
	public PostText findByPostTextId(long id) {
		return postTextRepository.findByPostTextId(id);
	}


	
    
}

