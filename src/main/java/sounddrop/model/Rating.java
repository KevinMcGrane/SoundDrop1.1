package sounddrop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="taste_preferences")
public class Rating {
private long id;
	
private User user;

private Track Track;

private float rating;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id")
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="user_id")
public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="item_id")
public Track getTrack() {
	return Track;
}

public void setTrack(Track track) {
	Track = track;
}

@Column(name = "preference")
public float getRating() {
	return rating;
}

public void setRating(float rating) {
	this.rating = rating;
}
	
}
