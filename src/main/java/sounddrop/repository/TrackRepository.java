package sounddrop.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import sounddrop.model.Track;
import sounddrop.model.User;

public interface TrackRepository extends JpaRepository<Track, Long>{

	Set<Track> findByUser(User user);
	Set<Track> findByUserIn(Set<User> friends);
	Track findById(long id);

}
