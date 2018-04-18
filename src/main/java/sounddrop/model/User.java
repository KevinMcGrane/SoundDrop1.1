package sounddrop.model;


import javax.persistence.*;

import sounddrop.model.PostText;

import java.util.Set;
import java.util.HashSet;
import java.util.List;


@Entity
@Table(name = "user")
public class User {
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    private String fname;
    private String lname;
	private Set<Role> roles;
    private List<PostText> postTexts;
    private String bio;
    private List<Track> tracks;
    private List<Playlist> playlist;
    private ProfilePic profilePic;
    private List<Comment> comments;
    private List<Post> post;

    private List<Rating> rating;

	private Set<User> friends;
	private Set<User> incomingFriendRequests;
	private Set<User> outgoingFriendRequests;
	


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
    
    public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}


    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    public List<PostText> getPostTexts() {
		return postTexts;
	}

	public void setPostTexts(List<PostText> postTexts) {
		this.postTexts = postTexts;
	}
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	@OneToOne
	public ProfilePic getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(ProfilePic profilePic) {
		this.profilePic = profilePic;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
	
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
	
	
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "friends",
			joinColumns = @JoinColumn(name = "userId"),
			inverseJoinColumns = @JoinColumn(name = "friendId"))
	public Set<User> getFriends(){
    	return friends;
    }
    
    public void setFriends(Set<User> friends) {
    	this.friends = friends;
    }
    
    @ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "friend_requests",
			joinColumns = @JoinColumn(name = "userId"),
			inverseJoinColumns = @JoinColumn(name = "friendId"))
    public Set<User> getIncomingFriendRequests(){
    	return incomingFriendRequests;
    }
    
    public void setIncomingFriendRequests(Set<User> incomingFriendRequests) {
    	this.incomingFriendRequests = incomingFriendRequests;
    }
    
    @ManyToMany(mappedBy = "incomingFriendRequests", fetch=FetchType.EAGER)
   		public Set<User> getOutgoingFriendRequests() {
		return outgoingFriendRequests;
	}

	public void setOutgoingFriendRequests(Set<User> outgoingFriendRequests) {
		this.outgoingFriendRequests = outgoingFriendRequests;
	}
	
	
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	public List<Playlist> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(List<Playlist> playlist) {
		this.playlist = playlist;
	}

	public boolean hasFriend(User friend) {
		return friends.contains(friend);
	}

	public void addFriend(User newFriend) {
		this.getFriends().add(newFriend);
		newFriend.getFriends().add(this);
	}

	public void removeFriend(User friendNoMore) {
		this.getFriends().remove(friendNoMore);
		friendNoMore.getFriends().remove(this);
	}

	public boolean isFriendOf(User person) {
		return this.getFriends().contains(person);
	}
    
	@Override
	  public boolean equals(Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }

	    User user = (User) o;

	    return id.equals(user.id);
	  }

	
	  
    
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    public List<Rating> getRating() {
		return rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}

	public String toString()
    {
    	return "User [id=" + id + ", name = " + username + ", password= " + password + ", password confirmed " + passwordConfirm + ",Bio " + bio +"]";
    }

 

}
