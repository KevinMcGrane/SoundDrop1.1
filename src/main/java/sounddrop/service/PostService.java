package sounddrop.service;

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

	void delete(Post post);
	void update(PostText postText, Track track, Post post);

	Post findByTrack(Track track);

	Post findByPostText(PostText postText);

}
