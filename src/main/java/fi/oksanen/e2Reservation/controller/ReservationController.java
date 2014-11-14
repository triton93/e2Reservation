
package fi.oksanen.e2Reservation.controller;

import fi.oksanen.e2Reservation.domain.Reservation;
import fi.oksanen.e2Reservation.service.exception.AlreadyDeletedException;
import fi.oksanen.e2Reservation.service.exception.AlreadyExistsException;
import fi.oksanen.e2Reservation.service.exception.DoesNotFoundException;
import fi.oksanen.e2Reservation.service.reservation.ReservationManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Toni Oksanen
 */
@RestController
@RequestMapping( "/reservations" )
public class ReservationController {
  
  @Autowired
  private ReservationManager reservationManager;
  
  @ResponseStatus( HttpStatus.CREATED )
  @RequestMapping( method = RequestMethod.PUT )
  public void addReservation( @RequestBody Reservation reservation ) throws AlreadyExistsException {
    this.reservationManager.createReservation( reservation ); 
  }
  
  @ResponseStatus( HttpStatus.OK )
  @RequestMapping( method = RequestMethod.POST )
  public void updateReservation( @RequestBody Reservation reservation ) throws DoesNotFoundException {
    this.reservationManager.updateReservation( reservation ); 
  }
  
  @ResponseStatus( HttpStatus.FOUND )
  @RequestMapping( value = "/{id}", method = RequestMethod.GET )
  public Reservation findReservationById( @PathVariable Long id ) throws DoesNotFoundException {
    return this.reservationManager.findById( id );
  }
  
  @ResponseStatus( HttpStatus.FOUND )
  @RequestMapping( method = RequestMethod.GET )
  public List<Reservation> findAllReservations() {
    return this.reservationManager.findAll();
  }
  
  @ResponseStatus( HttpStatus.OK )
  @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
  public void deleteReservation( @PathVariable Long id ) throws AlreadyDeletedException {
    this.reservationManager.deleteReservation( id ); 
  }

}
