package sounddrop.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import sounddrop.model.Post;
import sounddrop.model.PostText;
import sounddrop.model.Track;
import sounddrop.model.User;

public interface PostRepository extends JpaRepository<Post, Long>{
	
List<Post> findByUser(User user);
	
	List<Post> findByUserIn(Set<User> friends);
	
	Post findByPostText(PostText postText);
	Post findById(Long id);
	
	Post findByTrack(Track track);

}
