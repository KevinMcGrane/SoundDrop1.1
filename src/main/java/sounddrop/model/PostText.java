package sounddrop.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//A post containing just text
@Entity
@Table(name = "posttext")
public class PostText {

	
	private Long postTextId;



	private String content;
	
	private Date publishTime;
	
	private User user;
	
	private Set<Comment> comments;
	
	private Post post;
	
	public PostText(){
		
	}
	
	public PostText(String content, Date publishTime, User user) {
		super();
		this.content = content;
		this.publishTime = publishTime;
		this.user = user;
	}
	
	@Override
	public int hashCode() {
		
		return postTextId.hashCode();
	}  

	@Override
	  public boolean equals(Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }

	    PostText postText = (PostText) o;

	    return postTextId.equals(postText.postTextId);
	  }

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getPostTextId() {
		return postTextId;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public void setPostTextId(Long postTextId) {
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
	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@OneToOne
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	 
	


	
}
