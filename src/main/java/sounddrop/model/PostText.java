package sounddrop.model;

import java.sql.Time;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "posttext")
public class PostText {

	
	private long postTextId;



	private String content;
	
	private Date publishTime;
	
	private User user;
	
	private List<Comment> comments;
	
	public PostText(){
		
	}
	
	public PostText(String content, Date publishTime, User user) {
		super();
		this.content = content;
		this.publishTime = publishTime;
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getPostTextId() {
		return postTextId;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public void setPostTextId(long postTextId) {
		this.postTextId = postTextId;
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

	@OneToMany(mappedBy = "postText", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	 
	


	
}
