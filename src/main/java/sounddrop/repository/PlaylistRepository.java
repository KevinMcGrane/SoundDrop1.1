package sounddrop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sounddrop.model.Playlist;
import sounddrop.model.PostText;
import sounddrop.model.User;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
	List<Playlist> findByUser(User user);
	Playlist findByName(String name);

}
