
package fi.oksanen.e2Reservation.service.reservation;

import fi.oksanen.e2Reservation.domain.Reservation;
import fi.oksanen.e2Reservation.service.exception.AlreadyDeletedException;
import fi.oksanen.e2Reservation.service.exception.AlreadyExistsException;
import fi.oksanen.e2Reservation.service.exception.DoesNotFoundException;
import java.util.List;

/**
 *
 * @author Toni Oksanen
 */
public interface ReservationManager {
  
  public List<Reservation> findAll();
  
  public Reservation findById( Long id ) throws DoesNotFoundException;
  
  public void createReservation( Reservation reservation ) throws AlreadyExistsException;
  
  public void updateReservation( Reservation reservation ) throws DoesNotFoundException;
  
  public void deleteReservation( Long id ) throws AlreadyDeletedException;
  
}
