package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * A User.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@Column(name = "facebook_id", nullable = false, unique = true)
	private String facebookId;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "picture_url")
    private String pictureURL;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<TokenMapping> tokenMappings;

	public User(){

	}

	public User(String facebookId, String name, String email, String pictureURL){
		if(facebookId == null || facebookId.isEmpty()){
			throw new IllegalArgumentException("User cannot be created with NULL or empty facebook ID.");
		}

		if(name == null || name.isEmpty()){
			throw new IllegalArgumentException("User cannot be created with NULL or empty name.");
		}

		this.facebookId = facebookId;
		this.name = name;
		this.email = email;
		this.pictureURL = pictureURL;
	}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

	public String getFacebookId(){
		return facebookId;
	}

	public List<TokenMapping> getTokenMappings() {
		return tokenMappings;
	}

	public void setTokenMappings(List<TokenMapping> tokenMappings) {
		this.tokenMappings = tokenMappings;
	}

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", email='" + email + "'" +
            ", pictureURL='" + pictureURL + "'" +
            '}';
    }
}
