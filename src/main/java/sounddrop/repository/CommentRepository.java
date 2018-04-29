package sounddrop.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import sounddrop.model.Comment;
import sounddrop.model.PostText;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	Set<Comment> findByPostText(PostText postText);

}
