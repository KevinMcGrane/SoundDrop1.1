package sounddrop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sounddrop.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long>{
	Genre findByName(String name);
	
}
