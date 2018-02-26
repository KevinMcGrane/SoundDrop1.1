package sounddrop.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import sounddrop.model.Track;
import sounddrop.model.User;

public interface TrackRepository extends JpaRepository<Track, Long>{

	List<Track> findByUser(User user);
	List<Track> findByUserIn(Set<User> friends);

}
