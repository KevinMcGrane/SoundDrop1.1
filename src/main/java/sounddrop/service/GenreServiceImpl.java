package sounddrop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sounddrop.model.Genre;
import sounddrop.model.User;
import sounddrop.repository.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService {
	@Autowired
	GenreRepository genreRepository;

	//Save Genre
	@Override
	public void save(String name) {
		Genre newGenre = new Genre();
		newGenre.setName(name);
		genreRepository.save(newGenre);
		
	}
	
	//List all genres
	@Override
	public List<Genre> getAllGenre(){
		return genreRepository.findAll();
	}
	
	//Find Genre by name
	@Override
	 public Genre findByName(String name) {
	    	return genreRepository.findByName(name);
	    }
	
	//Test if genre contains name
	@Override
	public boolean containsName(final List<Genre> list, final String name){
	    return list.stream().filter(o -> o.getName().equals(name)).findFirst().isPresent();
	}

}
