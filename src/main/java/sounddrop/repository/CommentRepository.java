package sounddrop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sounddrop.model.Comment;
import sounddrop.model.PostText;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	List<Comment> findByPostText(PostText postText);

}
