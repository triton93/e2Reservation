
package fi.oksanen.e2Reservation.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author Toni Oksanen
 */

@Entity
@Table( name = "reservations" )
public class Reservation extends AbstractPersistable<Long> {
  
  @OneToOne
  private User user;
  
  @OneToOne
  private Room room;
  
  @Temporal( TemporalType.TIMESTAMP )
  private Date startDate;
  
  @Temporal( TemporalType.TIMESTAMP )
  private Date endDate;
  
  private Boolean removed = false;
  
  public User getUser() {
    return this.user;
  }

  public void setUser( User user ) {
    this.user = user;
  }

  public Room getRoom() {
    return this.room;
  }

  public void setRoom( Room room ) {
    this.room = room;
  }

  public Date getStartDate() {
    return this.startDate;
  }

  public void setStartDate( Date startDate ) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return this.endDate;
  }

  public void setEndDate( Date endDate ) {
    this.endDate = endDate;
  }

  public Boolean isRemoved() {
    return removed;
  }

  public void setRemoved( Boolean removed ) {
    this.removed = removed;
  }
  
}
