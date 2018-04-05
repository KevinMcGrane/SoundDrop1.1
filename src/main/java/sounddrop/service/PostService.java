package sounddrop.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import sounddrop.model.Post;
import sounddrop.model.PostText;
import sounddrop.model.Track;
import sounddrop.model.User;

public interface PostService {

	void save(PostText postText, Track track);

	List<Post> findByUser(User user);

	List<Post> findByUserIn(Set<User> friends);

	List<Post> getFeed(Set<User> friends, User user);

	Post findById(Long id);

}
