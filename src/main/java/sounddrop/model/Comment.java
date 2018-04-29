package sounddrop.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//Comment on tracks or text posts
@Entity
@Table(name = "comment")
public class Comment {

	
	private Long commentId;

	private String content;
	
	private Date publishTime;
	
	private User user;
	
	private PostText postText;
	
	private Track track;
	
	public Comment(){
		
	}
	
	public Comment(String content, Date publishTime, User user) {
		super();
		this.content = content;
		this.publishTime = publishTime;
		this.user = user;
	}

	@Override
	public int hashCode() {
		
		return commentId.hashCode();
	}  

	@Override
	  public boolean equals(Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }

	    Comment comment = (Comment) o;

	    return commentId.equals(comment.commentId);
	  }
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getCommentId() {
		return commentId;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
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
	@JoinColumn(name="posttext_id")
	public PostText getPostText() {
		return postText;
	}
	
	
	public void setPostText(PostText postText) {
		this.postText = postText;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="track_id")
	public Track getTrack() {
		return track;
	}
	
	
	public void setTrack(Track track) {
		this.track = track;
	}
	
	
	 
	


	
}
