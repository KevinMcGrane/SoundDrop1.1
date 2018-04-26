package sounddrop.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Post {
	private Long id;
	private PostText postText;
	private Track track;
	private Date publishTime;
	private boolean typeTrack;
	private User user;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	@OneToOne
	public PostText getPostText() {
		return postText;
	}
	
	public void setPostText(PostText postText) {
		this.postText = postText;
	}
	
	@OneToOne
	public Track getTrack() {
		return track;
	}
	public void setTrack(Track track) {
		this.track = track;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public boolean isTypeTrack() {
		return typeTrack;
	}

	public void setTypeTrack(boolean typeTrack) {
		this.typeTrack = typeTrack;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	


}