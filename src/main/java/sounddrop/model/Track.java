package sounddrop.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
//Track which users can upload
@Entity
public class Track {
	private Long id;
	private String trackName;
	private String fileName;
	private User user;
	private Genre genre;
	private String artist;
	private Date publishTime;
	private List<Playlist> playlists;
	private Set<Comment> comments;
	private List<Rating> rating;
	private Post post;

	/*
	 * public Track() {
	 * 
	 * }
	 * 
	 * public Track(String name, String track, User user, Date publishTime) {
	 * super(); this.name = name; this.track = track; this.publishTime =
	 * publishTime; this.user = user; }
	 */
	@Override
	public int hashCode() {
		
		return id.hashCode();
	}  

	@Override
	  public boolean equals(Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }

	    Track track = (Track) o;

	    return id.equals(track.id);
	  }

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
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
	@JoinColumn(name = "genre_id")
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@OneToMany(mappedBy = "track", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "track_playlist", joinColumns = @JoinColumn(name = "playlist_id"), inverseJoinColumns = @JoinColumn(name = "track_id"))
	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}

	@OneToOne
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@OneToMany(mappedBy = "track", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	public List<Rating> getRating() {
		return rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}

}
