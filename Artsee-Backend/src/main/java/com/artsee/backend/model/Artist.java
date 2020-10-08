package com.artsee.backend.model;
import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.Id;

@Entity
public class Artist extends User{
private String artistDescription;
   
   public void setArtistDescription(String value) {
this.artistDescription = value;
    }
public String getArtistDescription() {
return this.artistDescription;
    }
private float rating;

public void setRating(float value) {
this.rating = value;
    }
public float getRating() {
return this.rating;
    }
private Set<Review> reviews;

@OneToMany(cascade={CascadeType.ALL})
public Set<Review> getReviews() {
   return this.reviews;
}

public void setReviews(Set<Review> reviewss) {
   this.reviews = reviewss;
}

private String artist_email;

public void setArtist_email(String value) {
this.artist_email = value;
    }
@Id
public String getArtist_email() {
return this.artist_email;
       }
   }
