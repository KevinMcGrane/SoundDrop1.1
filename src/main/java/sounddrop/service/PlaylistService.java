package sounddrop.service;

import java.util.List;

import sounddrop.model.Playlist;
import sounddrop.model.User;

public interface PlaylistService {

	void save(Playlist playlist, User user);

	List<Playlist> findByUser(User user);

	Playlist findByName(String name);

}
