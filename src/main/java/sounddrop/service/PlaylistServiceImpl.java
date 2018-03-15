package sounddrop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sounddrop.model.Playlist;
import sounddrop.model.User;
import sounddrop.repository.PlaylistRepository;

@Service
public class PlaylistServiceImpl implements PlaylistService{
	@Autowired
	PlaylistRepository playlistRepository;
	@Override
	public void save(Playlist playlist, User user) {
		playlist.setName(playlist.getName());
		playlist.setUser(user);
		playlistRepository.save(playlist);
	}

}
