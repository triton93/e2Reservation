
package fi.oksanen.e2Reservation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author Toni Oksanen
 */
@Entity
@Table( name = "users" )
public class User extends AbstractPersistable<Long> {
  
  @NotBlank
  @Length( min = 2, max = 50 )
  private String lastName;
  
  @NotBlank
  @Length( min = 2, max = 20 )
  private String firstName;
  
  @NotBlank
  @Length( max = 50 )
  private String address;
  
  @NotBlank
  @Length( min = 5, max = 5 )
  private String postcode;
  
  @NotBlank
  @Length( min = 3, max = 15 )
  private String city;
  
  @NotBlank
  @Length( min = 6, max = 15 )
  private String telephone;
  
  @Email
  private String email;
  
  @NotBlank
  @Column( unique = true )  
  private String username;
  
  @NotBlank
  @Length( min = 8 )
  private String password;
  
  @NotBlank
  private String salt;

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName( String lastName ) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName( String firstName ) {
    this.firstName = firstName;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress( String address ) {
    this.address = address;
  }

  public String getPostcode() {
    return this.postcode;
  }

  public void setPostcode( String postcode ) {
    this.postcode = postcode;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getTelephone() {
    return this.telephone;
  }

  public void setTelephone( String telephone ) {
    this.telephone = telephone;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername( String username ) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword( String password ) {
    this.password = password;
  }

  public String getSalt() {
    return this.salt;
  }

  public void setSalt( String salt ) {
    this.salt = salt;
  }
  
}
