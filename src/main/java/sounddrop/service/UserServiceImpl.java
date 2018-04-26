package sounddrop.service;

import sounddrop.model.Post;
import sounddrop.model.PostText;
import sounddrop.model.Track;
import sounddrop.model.User;
import sounddrop.repository.PostTextRepository;
import sounddrop.repository.RoleRepository;
import sounddrop.repository.TrackRepository;
import sounddrop.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private PostTextRepository postTextRepository;
    @Autowired
    private TrackRepository trackRepository;
    @Autowired
    TrackService trackService;
    @Autowired
    PostTextService postTextService;
    @Autowired
    PostService postService;
    
    //Save user
    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        user.setFname(user.getFname());
        user.setLname(user.getLname());
        userRepository.save(user);
    }
    
    //Update user
    @Override
    public void update(User user) {
        user.setPassword(user.getPassword());
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        user.setFname(user.getFname());
        user.setLname(user.getLname());
        user.setFriends(user.getFriends());
        user.setIncomingFriendRequests(user.getIncomingFriendRequests());
        user.setOutgoingFriendRequests(user.getOutgoingFriendRequests());
        user.setProfilePic(user.getProfilePic());
        user.setComments(user.getComments());
        user.setPost(user.getPost());
        userRepository.save(user);
    }


    //Find user by username
    @Override
    public User findByUsername(String username) {
    	return userRepository.findByUsername(username);
    }
    
    @Override
    public User find(User user) {
        return findByUsername(user.getUsername());
      }
    
    //Get all user
    @Override
    public List<User> getAllUser() {
    	List<User> userList = userRepository.findAll();
    	
    	return userList;
	}
    
    //Find user by last name
    @Override
    public List<User> findUserByLname(String lname){
    	List<User> userList = userRepository.findUserByLname(lname);	
    	return userList;
    }
	
    //Confirm friend request method
    @Override
	public void addFriend(User userMe, User userFriend) {
		userMe = find(userMe);
		userFriend = find(userFriend);
		 userMe.getFriends().add(userFriend);
		    userFriend.getFriends().add(userMe);
		    userMe.getIncomingFriendRequests().remove(userFriend);
		    userFriend.getOutgoingFriendRequests().remove(userMe);

		    update(userMe);
		    update(userFriend);
		    
	}
	
	@Override
	public boolean isUserFollowedBy(User userMe, String username) {
		
		//If the method is invoked for myself, return false.
		if(userMe.getUsername().equals(username)) {
			return false;
		}

		//Check each person that I follow whether they use searched username.
		for(User item : userMe.getFriends()) {
			if(item.getUsername().equals(username)) {
				return true;
			}
		}

		//None of the people I follow use given username, hence return false.
		return false;
	}

    //Cancel friend request
	@Override
	public void removeFriendRequests(User user1, User user2) {
	    user1 = find(user1);
	    user2 = find(user2);

	    user1.getOutgoingFriendRequests().remove(user2);
	    user2.getIncomingFriendRequests().remove(user1);

	    update(user1);
	    update(user2);
	  }
	
	//Add friend request
	@Override
	public void addFriendRequest(User asker, User potentialFriend) {
	    asker = find(asker);
	    potentialFriend = find(potentialFriend);

	    potentialFriend.getIncomingFriendRequests().add(asker);
	    asker.getOutgoingFriendRequests().add(potentialFriend);

	    update(potentialFriend);
	    update(asker);
	  }

//	//
//	@Override
//	public List<User> findFriends(String lname) {
//    	List<User> userList = userRepository.findFriendsByLname(lname);	
//		return userList;
//	}

	

	//Remove friend
	@Override
	public void removeFriends(User user1, User user2) {
	    user1 = find(user1);
	    user2 = find(user2);

	    user1.getFriends().remove(user2);
	    user2.getFriends().remove(user1);

	    update(user1);
	    update(user2);
	  }
	
	
	//Find user by id
	@Override
	public User findById(Long id) {
		return userRepository.findOne(id);
	}
	
	//Find all user
	@Override
	public List<User> findAll(){
		return userRepository.findAll();
	}
	

}
