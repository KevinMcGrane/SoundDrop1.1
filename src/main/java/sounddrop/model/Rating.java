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
//Users rating of songs, used then to make recommendations to users
@Entity
@Table(name="taste_preferences")
public class Rating {
private Long id;
	
private User user;

private Track Track;

private float rating;

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

    Rating rating = (Rating) o;

    return id.equals(rating.id);
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
