
package fi.oksanen.e2Reservation.service;

import fi.oksanen.e2Reservation.service.reservation.ReservationManager;
import fi.oksanen.e2Reservation.Application;
import fi.oksanen.e2Reservation.domain.Reservation;
import fi.oksanen.e2Reservation.domain.Room;
import fi.oksanen.e2Reservation.domain.User;
import fi.oksanen.e2Reservation.repository.ReservationRepository;
import fi.oksanen.e2Reservation.repository.RoomRepository;
import fi.oksanen.e2Reservation.repository.UserRepository;
import fi.oksanen.e2Reservation.service.exception.AlreadyDeletedException;
import fi.oksanen.e2Reservation.service.exception.AlreadyExistsException;
import fi.oksanen.e2Reservation.service.exception.DoesNotFoundException;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Toni Oksanen
 */

@RunWith( SpringJUnit4ClassRunner.class )
@SpringApplicationConfiguration( classes = Application.class )
public class ReservationManagerImplTest {
  
  @Autowired
  private ReservationRepository reservationRepository;
  
  @Autowired
  private ReservationManager manager;
  
  @Autowired
  private RoomRepository roomRepository;
  
  @Autowired
  private UserRepository userRepository;
  
  private User user;
  private Room room;
  
  @Before
  public void setup() {
    
    User u = new User();
    
    u.setLastName( "Oksanen" );
    u.setFirstName( "Toni" );
    
    u.setAddress( "Hannankatu 6 D 37" );
    u.setPostcode( "03100" );
    u.setCity( "Nummela" ); 
    
    u.setTelephone( "0504080027" ); 
    u.setEmail( "toni.oksanen@cs.helsinki.fi" ); 
    
    u.setUsername( "oksanto" ); 
    u.setPassword( "toni1234" );
    u.setSalt( "dksjfldsjfjdsfljlfdsjfslkfjdlfjl" );
    
    this.user = this.userRepository.save( u );
    
    Room r = new Room();
    
    r.setName( "Neuvotteluhuone I" );
    r.setDescription( "Tilava neuvotteluhuone 5 - 10 hengelle." ); 
    r.setArea( 50.5 ); 
    
    this.roomRepository.save( r );
    
  }
  
  @After
  public void tearDown() {
    
    this.reservationRepository.deleteAll();
    this.userRepository.deleteAll();
    this.roomRepository.deleteAll();
  
  }
  
  
  public Reservation newInstance() {
    
    Reservation r = new Reservation();
    
    r.setUser( this.user );
    r.setRoom( this.room );
    r.setStartDate( new java.util.Date() );
    r.setEndDate( new java.util.Date() );
    
    return r;
    
  }
  
  @Test
  public void testCreatedReservationFoundInRepository() throws Exception {
    
    Reservation r = this.newInstance();
    this.manager.createReservation( r ); 
    
    assertEquals( r, this.reservationRepository.findOne( r.getId() ) ); 
  
  }
  
  @Test( expected = AlreadyExistsException.class )
  public void testCannotAddAlreadyCreatedReservation() throws Exception {
    
    Reservation r = this.reservationRepository.save( this.newInstance() );
    this.manager.createReservation( r );
  
  }
  
  @Test
  public void testUpdatedReservationFoundInRepository() throws Exception {
    
    Reservation r = this.newInstance();
    
    r = this.reservationRepository.save( r );
    r.setEndDate( new java.util.Date() );
    
    this.manager.updateReservation( r );
    
    assertEquals( r, this.reservationRepository.findOne( r.getId() ) ); 
    
  }
  
  @Test( expected = DoesNotFoundException.class )
  public void testCannotUpdateReservationWhichDoesNotExist() throws Exception {
    this.manager.updateReservation( this.newInstance() ); 
  }
  
  @Test
  public void testReservationDoesNotReallyRemove() throws Exception {
    
    Reservation r = this.reservationRepository.save( this.newInstance() );
    this.manager.deleteReservation( r.getId() );
    
    assertNotNull( this.reservationRepository.findOne( r.getId() ) );
  
  }
  
  @Test
  public void testReservationHasMarkedToRemoved() throws Exception {
    
    Reservation r = this.reservationRepository.save( this.newInstance() );
    this.manager.deleteReservation( r.getId() );
    
    assertTrue( this.reservationRepository.findOne( r.getId() ).isRemoved() );
    
  }
  
  @Test
  public void testReservationManagerDoesNotFindRemovedReservations() throws Exception {
    
    Reservation r = this.reservationRepository.save( this.newInstance() );
    this.manager.deleteReservation( r.getId() ); 
    
    List<Reservation> reservations = this.manager.findAll();
    
    assertFalse( reservations.contains( r ) ); 
  
  }
  
  @Test( expected = AlreadyDeletedException.class )
  public void testCannotDeleteAlreadyRemovedReservation() throws Exception {
    
    Reservation r = this.reservationRepository.save( this.newInstance() );
    
    this.manager.deleteReservation( r.getId() ); 
    this.manager.deleteReservation( r.getId() ); 
    
  }
  
  @Test
  public void testReservationFoundById() throws Exception {
    
    Reservation r = this.reservationRepository.save( this.newInstance() );
    assertEquals( r, this.manager.findById( r.getId() ) ); 
  
  }
  
  @Test( expected = DoesNotFoundException.class )
  public void testReservationDoesNotFoundById() throws Exception {
    this.manager.findById( 10000L );
  }
  
  
  
}
