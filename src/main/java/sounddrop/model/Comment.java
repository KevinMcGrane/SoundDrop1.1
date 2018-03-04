package sounddrop.model;

import java.sql.Time;
import java.util.Comparator;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {

	
	private long commentId;



	private String content;
	
	private Date publishTime;
	
	private User user;
	
	private PostText postText;
	
	public Comment(){
		
	}
	
	public Comment(String content, Date publishTime, User user) {
		super();
		this.content = content;
		this.publishTime = publishTime;
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getCommentId() {
		return commentId;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public void setCommentId(long commentId) {
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
	
	 
	


	
}
