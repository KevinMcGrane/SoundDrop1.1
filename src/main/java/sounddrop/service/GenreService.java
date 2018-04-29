package sounddrop.service;

import java.util.List;

import sounddrop.model.Genre;

public interface GenreService {

	void save(String genre);

	List<Genre> getAllGenre();
	
	boolean containsName(List<Genre> list, String name);

	Genre findByName(String name);
}
