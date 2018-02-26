package sounddrop.model;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Track {
	private long id;
	private String trackName;
	private String fileName;
	private User user;
	private Genre genre;
	private Artist artist;
	private Date publishTime;
	private List<Playlist> playlists;
	
/*	public Track() {
		
	}

	public Track(String name, String track, User user, Date publishTime) {
		super();
		this.name = name;
		this.track = track;
		this.publishTime = publishTime;
		this.user = user;
	}*/
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "file_id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTrackName() {
		return trackName;
	}
	
	
	
	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	
	
	public void setUser(User user) {
		this.user = user;
	}
	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="genre_id")
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="artist_id")
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	@ManyToMany(mappedBy = "tracks")
	public List<Playlist> getPlaylists() {
		return playlists;
	}
	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}
	
	
	
	
	
	
}
