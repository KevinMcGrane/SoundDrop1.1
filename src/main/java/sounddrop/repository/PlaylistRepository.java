package sounddrop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sounddrop.model.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

}
