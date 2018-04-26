package sounddrop.service;

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
import sounddrop.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	PostRepository postRepository;
	@Autowired
	TrackService trackService;
	@Autowired
	PostTextService postTextService;
	
	//Save post
	 	@Override
	    public void save(PostText postText, Track track) {
	 		Post post = new Post();
	 		post.setPostText(postText);
	 		post.setTrack(track);
	 		if (post.getPostText() == null) {
	 			post.setTypeTrack(true);
	 			post.setPublishTime(track.getPublishTime());
	 			post.setUser(track.getUser());
	 		}else {
	 			post.setTypeTrack(false);
	 			post.setPublishTime(postText.getPublishTime());
	 			post.setUser(postText.getUser());
	 		}
	 		postRepository.save(post);
	    }
	 	
	 	//update post
	 	@Override
	    public void update(PostText postText, Track track, Post post) {

	 		if (post.getPostText() == null) {
	 			
	 			post.setTypeTrack(true);
	 			post.setPublishTime(track.getPublishTime());
	 			post.setUser(track.getUser());
	 		}else {
	 			post.setTypeTrack(false);
	 			post.setPublishTime(postText.getPublishTime());
	 			post.setUser(postText.getUser());
	 		}
	 		postRepository.save(post);
	    }
	 	
	 	
	 	//Find post by user
	 	@Override
	 	public List<Post> findByUser(User user){
	 		return postRepository.findByUser(user);
	 	}
	 	
	 	//Find post by track
	 	@Override
	 	public Post findByTrack(Track track){
	 		return postRepository.findByTrack(track);
	 	}
	 	
	 	//Find post by posttext
	 	@Override
	 	public Post findByPostText(PostText postText){
	 		return postRepository.findByPostText(postText);
	 	}
	 	
	 	//Find posts belonging to friends
	 	@Override
	 	public List<Post> findByUserIn(Set<User> friends){
	 		return postRepository.findByUserIn(friends);
	 	}

	 	//Get posts belonging to me and my friends and combine and sort to create a "feed"
	 	@Override
	 	public List<Post> getFeed(Set<User> friends, User user){
	 		
	 		List<Post> PostList = postRepository.findByUserIn(friends);
	    	List<Post> myPosts = postRepository.findByUser(user);
	    	List<Post> newList = new ArrayList<Post>();
	    	newList.addAll(myPosts);
	    	newList.addAll(PostList);
	    	class OutcomeAscComparator implements Comparator<Post>
		    {
		        public int compare(Post left, Post right) {
		            return right.getPublishTime().compareTo(left.getPublishTime());
		        }
		    }
	    	
	    	Collections.sort(newList, new OutcomeAscComparator());
	    	
	    	
	    	return newList;
	 		
	 	}
	 	
	 	//Return post by id
	 	@Override
	 	public Post findById(Long id) {
	 		return postRepository.findById(id);
	 	}
	 	
	 	//Delete post
	 	@Override
	 	public void delete(Post post) {
	 		postRepository.delete(post);
	 		if (post.isTypeTrack()) {
	 			trackService.delete(post.getTrack());
	 		}else {
	 			postTextService.delete(post.getPostText());
	 		}
	 	}
}
