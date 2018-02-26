package sounddrop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sounddrop.model.Genre;
import sounddrop.model.PostText;

public interface GenreRepository extends JpaRepository<Genre, Long>{
	
}
