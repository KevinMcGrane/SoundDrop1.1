package sounddrop.repository;

import sounddrop.model.PostText;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sounddrop.model.User;


public interface PostTextRepository extends JpaRepository<PostText, Long>{
	List<PostText> findByUser(User user);
	
	List<PostText> findByUserIn(Set<User> friends);
	
	PostText findByPostTextId(long id);


}
