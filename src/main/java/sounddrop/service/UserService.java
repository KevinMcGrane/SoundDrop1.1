package sounddrop.service;

import java.util.List;
import java.util.Set;

import sounddrop.model.User;

public interface UserService {
    void save(User user);
    void update(User user);
    public User findByUsername(String username);
    public List<User> getAllUser();
    public User findById(Long id);
    public List<User> findUserByLname(String lname);
    public void addFriend(User user, User friend);
	//public List<User> findFriends(String lname);
	public void removeFriendRequests(User user1, User user2);
	public void addFriendRequest(User asker, User potentialFriend);
	public void removeFriends(User user1, User user2);
	public User find(User user);
	public List<User> findAll();
	boolean isUserFollowedBy(User userMe, String username);
	

}
