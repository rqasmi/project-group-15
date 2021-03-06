package com.artsee.backend.utility;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.artsee.backend.dto.AddressDto;
import com.artsee.backend.dto.ArtistDto;
import com.artsee.backend.dto.ArtworkDto;
import com.artsee.backend.dto.ArtworkOrderDto;
import com.artsee.backend.dto.CustomerDto;
import com.artsee.backend.dto.DeliveryMethodDto;
import com.artsee.backend.dto.OrderStatusDto;
import com.artsee.backend.model.*;


public class TestUtility {


    // ---------- Artist Methods ----------------------------------------------------------------------------------------------------------------------------------
    public static Artist createArtist(String artistID, String email, String password, String firstName, String lastName, String phoneNumber,  String artistDescription, String profilePictureURL) {
        Artist artist = new Artist(); 
        artist.setUserID(artistID);
		artist.setEmail(email);
		artist.setPassword(password);
		artist.setFirstName(firstName);
		artist.setLastName(lastName);
		artist.setArtistDescription(artistDescription);
		artist.setPhoneNumber(phoneNumber);
		artist.setProfilePictureURL(profilePictureURL);
		return artist;
    }
 // ---------- Customer Methods ----------------------------------------------------------------------------------------------------------------------------------
    public static Customer createCustomer(String customerID, String email, String password, String firstName, String lastName, String phoneNumber,  Address customerAddress) {
    	Customer customer = new Customer();
    	customer.setUserID(customerID);
		customer.setEmail(email);
		customer.setPassword(password);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setAddress(customerAddress);
		customer.setPhoneNumber(phoneNumber);
		return customer;
		
		
    }
 // ---------- Admin Methods ----------------------------------------------------------------------------------------------------------------------------------
    public static Administrator createAdmin(String administratorID, String email, String password, String firstName, String lastName, String phoneNumber) { 
        Administrator administrator = new Administrator();

        administrator.setUserID(administratorID);
		administrator.setEmail(email);
		administrator.setPassword(password);
		administrator.setFirstName(firstName);
		administrator.setLastName(lastName);
		administrator.setPhoneNumber(phoneNumber);
		return administrator;
    }
 // ---------- Address Methods ----------------------------------------------------------------------------------------------------------------------------------
    public static Address createAddress(int id, String addressLine1, String addressLine2, String city, String province, String postalCode, String country) {
        Address address = new Address();
		address.setAddressLine1(addressLine1);
		address.setAddressLine2(addressLine2);
		address.setCity(city);
		address.setProvince(province);
		address.setPostalCode(postalCode);
        address.setCountry(country);
        address.setAddressID(id);
		return address;
    }
 // ---------- Artwork Methods ----------------------------------------------------------------------------------------------------------------------------------
    public static Artwork createArtwork(int id, String name, int price, String description, Date dateCreated, int numInStock, Artist artist, String imageURL) {
        Artwork artwork = new Artwork();
        artwork.setName(name);
        artwork.setDescription(description);
        artwork.setPrice(price);
        artwork.setDateOfCreation(dateCreated);
        artwork.setNumInStock(numInStock);
        artwork.setArtist(artist);
        artwork.setArtworkID(id);
        artwork.setImageURL(imageURL);
        
        return artwork;
    }
 // ---------- Review Methods ----------------------------------------------------------------------------------------------------------------------------------
    public static Review createReview(Integer id, Integer rating, String comment, Boolean wouldRecommend, Customer customer, Artist artist){
    	Review review = new Review();
    	review.setRating(rating);
    	review.setComment(comment);
    	review.setWouldRecommend(wouldRecommend);
    	review.setCustomer(customer);
    	review.setArtist(artist);
    	review.setReviewID(id);
    	return review;
    	
    }
    // ---------- ArtworkOrder Methods ----------------------------------------------------------------------------------------------------------------------------------
    public static ArtworkOrder createArtworkOrder(int id, DeliveryMethod deliveryMethod, Customer customer, Set<Artwork> artList){
    	ArtworkOrder artworkOrder = new ArtworkOrder();
    	artworkOrder.setOrderID(id);
    	artworkOrder.setArtworks(artList);
    	artworkOrder.setDeliveryMethod(deliveryMethod);
    	artworkOrder.setCustomer(customer);
    	return artworkOrder;
    	
    }
    
    public static ArtistDto createArtistDto(String userID, String email, String password, String firstName, String lastName, String phoneNumber, String artistDescription, float rating, String profilePictureURL) {
    	return new ArtistDto(userID, email, password, firstName, lastName, phoneNumber, artistDescription, rating, profilePictureURL);
    }
    
    public static ArtworkDto createArtworkDto(Integer id, String name, String description, int price, Date date, int numInStock, String imageURL, ArtistDto aDto) {
    	return new ArtworkDto(id, name, description, price, date, numInStock, aDto, imageURL);
    }
    
    public static ArtworkOrderDto createArtworkOrderDto(Integer orderID, DeliveryMethodDto deliveryMethodDto, CustomerDto customer, List<ArtworkDto> artworks) {
    	return new ArtworkOrderDto(orderID, deliveryMethodDto, customer, artworks);
    }
    
    public static CustomerDto createCustomerDto(String userID, String email, String password, String firstName, String lastName, String phoneNumber, AddressDto address) {
    	return new CustomerDto(userID, email, password, firstName, lastName, phoneNumber, address);
    }
	
    public static AddressDto createAddressDto(Integer addressID, String addressLine1, String addressLine2, String city, String province, String postalCode, String country) {
    	return new AddressDto( addressID,  addressLine1,  addressLine2,  city,  province,  postalCode,  country);
    }
}
