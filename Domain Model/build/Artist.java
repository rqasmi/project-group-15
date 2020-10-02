/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4607.2d2b84eb8 modeling language!*/


import java.util.*;
import java.sql.Date;

// line 25 "ArtGalleryApplication.ump"
public class Artist extends User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Artist Attributes
  private String firstname;
  private String lastname;
  private String phoneNumber;
  private String artistDescription;

  //Artist Associations
  private List<Review> reviews;
  private List<Art> artWorks;
  private List<Order> orders;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Artist(String aEmail, String aPassword, Application aApplication, String aFirstname, String aLastname, String aPhoneNumber)
  {
    super(aEmail, aPassword, aApplication);
    firstname = aFirstname;
    lastname = aLastname;
    phoneNumber = aPhoneNumber;
    artistDescription = null;
    reviews = new ArrayList<Review>();
    artWorks = new ArrayList<Art>();
    orders = new ArrayList<Order>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setFirstname(String aFirstname)
  {
    boolean wasSet = false;
    firstname = aFirstname;
    wasSet = true;
    return wasSet;
  }

  public boolean setLastname(String aLastname)
  {
    boolean wasSet = false;
    lastname = aLastname;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhoneNumber(String aPhoneNumber)
  {
    boolean wasSet = false;
    phoneNumber = aPhoneNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setArtistDescription(String aArtistDescription)
  {
    boolean wasSet = false;
    artistDescription = aArtistDescription;
    wasSet = true;
    return wasSet;
  }

  public String getFirstname()
  {
    return firstname;
  }

  public String getLastname()
  {
    return lastname;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public String getArtistDescription()
  {
    return artistDescription;
  }
  /* Code from template association_GetMany */
  public Review getReview(int index)
  {
    Review aReview = reviews.get(index);
    return aReview;
  }

  public List<Review> getReviews()
  {
    List<Review> newReviews = Collections.unmodifiableList(reviews);
    return newReviews;
  }

  public int numberOfReviews()
  {
    int number = reviews.size();
    return number;
  }

  public boolean hasReviews()
  {
    boolean has = reviews.size() > 0;
    return has;
  }

  public int indexOfReview(Review aReview)
  {
    int index = reviews.indexOf(aReview);
    return index;
  }
  /* Code from template association_GetMany */
  public Art getArtWork(int index)
  {
    Art aArtWork = artWorks.get(index);
    return aArtWork;
  }

  public List<Art> getArtWorks()
  {
    List<Art> newArtWorks = Collections.unmodifiableList(artWorks);
    return newArtWorks;
  }

  public int numberOfArtWorks()
  {
    int number = artWorks.size();
    return number;
  }

  public boolean hasArtWorks()
  {
    boolean has = artWorks.size() > 0;
    return has;
  }

  public int indexOfArtWork(Art aArtWork)
  {
    int index = artWorks.indexOf(aArtWork);
    return index;
  }
  /* Code from template association_GetMany */
  public Order getOrder(int index)
  {
    Order aOrder = orders.get(index);
    return aOrder;
  }

  public List<Order> getOrders()
  {
    List<Order> newOrders = Collections.unmodifiableList(orders);
    return newOrders;
  }

  public int numberOfOrders()
  {
    int number = orders.size();
    return number;
  }

  public boolean hasOrders()
  {
    boolean has = orders.size() > 0;
    return has;
  }

  public int indexOfOrder(Order aOrder)
  {
    int index = orders.indexOf(aOrder);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfReviews()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Review addReview(float aRating, String aComment, boolean aWouldReccomend, Customer aCustomer)
  {
    return new Review(aRating, aComment, aWouldReccomend, aCustomer, this);
  }

  public boolean addReview(Review aReview)
  {
    boolean wasAdded = false;
    if (reviews.contains(aReview)) { return false; }
    Artist existingArtist = aReview.getArtist();
    boolean isNewArtist = existingArtist != null && !this.equals(existingArtist);
    if (isNewArtist)
    {
      aReview.setArtist(this);
    }
    else
    {
      reviews.add(aReview);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeReview(Review aReview)
  {
    boolean wasRemoved = false;
    //Unable to remove aReview, as it must always have a artist
    if (!this.equals(aReview.getArtist()))
    {
      reviews.remove(aReview);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addReviewAt(Review aReview, int index)
  {  
    boolean wasAdded = false;
    if(addReview(aReview))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReviews()) { index = numberOfReviews() - 1; }
      reviews.remove(aReview);
      reviews.add(index, aReview);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveReviewAt(Review aReview, int index)
  {
    boolean wasAdded = false;
    if(reviews.contains(aReview))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReviews()) { index = numberOfReviews() - 1; }
      reviews.remove(aReview);
      reviews.add(index, aReview);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addReviewAt(aReview, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfArtWorks()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Art addArtWork(String aName, String aDescription, float aPrice, Date aDateOfCreation, boolean aIsSold, int aArtwork_id, Application aApplication)
  {
    return new Art(aName, aDescription, aPrice, aDateOfCreation, aIsSold, aArtwork_id, this, aApplication);
  }

  public boolean addArtWork(Art aArtWork)
  {
    boolean wasAdded = false;
    if (artWorks.contains(aArtWork)) { return false; }
    Artist existingArtist = aArtWork.getArtist();
    boolean isNewArtist = existingArtist != null && !this.equals(existingArtist);
    if (isNewArtist)
    {
      aArtWork.setArtist(this);
    }
    else
    {
      artWorks.add(aArtWork);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeArtWork(Art aArtWork)
  {
    boolean wasRemoved = false;
    //Unable to remove aArtWork, as it must always have a artist
    if (!this.equals(aArtWork.getArtist()))
    {
      artWorks.remove(aArtWork);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addArtWorkAt(Art aArtWork, int index)
  {  
    boolean wasAdded = false;
    if(addArtWork(aArtWork))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfArtWorks()) { index = numberOfArtWorks() - 1; }
      artWorks.remove(aArtWork);
      artWorks.add(index, aArtWork);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveArtWorkAt(Art aArtWork, int index)
  {
    boolean wasAdded = false;
    if(artWorks.contains(aArtWork))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfArtWorks()) { index = numberOfArtWorks() - 1; }
      artWorks.remove(aArtWork);
      artWorks.add(index, aArtWork);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addArtWorkAt(aArtWork, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOrders()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Order addOrder(float aTotalPrice, Date aDatePlaced, Order.DeliveryMethod aDeliveryMethod, Order.OrderStatus aOrderStatus, Customer aCustomer, Application aApplication, Art... allArtWorks)
  {
    return new Order(aTotalPrice, aDatePlaced, aDeliveryMethod, aOrderStatus, aCustomer, this, aApplication, allArtWorks);
  }

  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    Artist existingArtist = aOrder.getArtist();
    boolean isNewArtist = existingArtist != null && !this.equals(existingArtist);
    if (isNewArtist)
    {
      aOrder.setArtist(this);
    }
    else
    {
      orders.add(aOrder);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrder(Order aOrder)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrder, as it must always have a artist
    if (!this.equals(aOrder.getArtist()))
    {
      orders.remove(aOrder);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addOrderAt(Order aOrder, int index)
  {  
    boolean wasAdded = false;
    if(addOrder(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderAt(Order aOrder, int index)
  {
    boolean wasAdded = false;
    if(orders.contains(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderAt(aOrder, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while (reviews.size() > 0)
    {
      Review aReview = reviews.get(reviews.size() - 1);
      aReview.delete();
      reviews.remove(aReview);
    }
    
    for(int i=artWorks.size(); i > 0; i--)
    {
      Art aArtWork = artWorks.get(i - 1);
      aArtWork.delete();
    }
    for(int i=orders.size(); i > 0; i--)
    {
      Order aOrder = orders.get(i - 1);
      aOrder.delete();
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "firstname" + ":" + getFirstname()+ "," +
            "lastname" + ":" + getLastname()+ "," +
            "phoneNumber" + ":" + getPhoneNumber()+ "," +
            "artistDescription" + ":" + getArtistDescription()+ "]";
  }
}