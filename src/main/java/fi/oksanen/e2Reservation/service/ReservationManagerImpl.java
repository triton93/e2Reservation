
package fi.oksanen.e2Reservation.service;

import fi.oksanen.e2Reservation.domain.Reservation;
import fi.oksanen.e2Reservation.repository.ReservationRepository;
import fi.oksanen.e2Reservation.service.exception.AlreadyDeletedException;
import fi.oksanen.e2Reservation.service.exception.AlreadyExistsException;
import fi.oksanen.e2Reservation.service.exception.DoesNotExistException;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Toni Oksanen
 */
@Service
public class ReservationManagerImpl implements ReservationManager {
  
  private ReservationRepository reservationRepository;
  
  @Autowired
  public ReservationManagerImpl( ReservationRepository reservationRepository ) {
    this.reservationRepository = reservationRepository;
  }
  
  @Override
  public List<Reservation> findAll() {
    return this.reservationRepository.findByRemovedFalse();
  }

  @Override
  public Reservation findById( Long id ) {
    return this.reservationRepository.findOne( id );
  }

  @Override
  @Transactional
  public void createReservation( Reservation reservation ) throws AlreadyExistsException {
    
    if ( !reservation.isNew() ) {
      throw new AlreadyExistsException( "Try to add reservation, which already exists!" );
    }
    
    this.reservationRepository.save( reservation );
  
  }

  @Override
  @Transactional
  public void updateReservation( Reservation reservation ) throws DoesNotExistException {
    
    if ( reservation.isNew() ) {
      throw new DoesNotExistException( "Try to update reservation, which does not exist!" );
    }
    
    this.reservationRepository.save( reservation );
    
  }

  @Override
  @Transactional
  public void deleteReservation( Long id ) throws AlreadyDeletedException {
    
    Reservation r = this.reservationRepository.findOne( id );
    
    if ( r.isRemoved() ) {
      throw new AlreadyDeletedException( "Try to delete already deleted reservation!" );
    }
    
    r.setRemoved( true );
    this.reservationRepository.save( r );
  
  }
  
}
