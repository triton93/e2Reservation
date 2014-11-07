
package fi.oksanen.e2Reservation.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author Toni Oksanen
 */
@Entity
@Table( name = "rooms" )
public class Room extends AbstractPersistable<Long> {
  
  @NotBlank
  @Length( min = 5, max = 30 )
  private String name;
  
  @Length( max = 300 )
  private String description;
  
  private Double area;

  public String getName() {
    return this.name;
  }

  public void setName( String name ) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription( String description ) {
    this.description = description;
  }

  public Double getArea() {
    return this.area;
  }

  public void setArea( Double area ) {
    this.area = area;
  }
  
}
