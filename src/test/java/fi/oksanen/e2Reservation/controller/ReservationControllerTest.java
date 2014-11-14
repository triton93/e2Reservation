
package fi.oksanen.e2Reservation.controller;

import fi.oksanen.e2Reservation.Application;
import fi.oksanen.e2Reservation.domain.Reservation;
import fi.oksanen.e2Reservation.repository.ReservationRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Toni Oksanen
 */

@WebAppConfiguration
@RunWith( SpringJUnit4ClassRunner.class )
@SpringApplicationConfiguration( classes = Application.class )
public class ReservationControllerTest {
    
  public static final String API_URI = "/reservations";
  
  @Autowired
  private ReservationRepository reservationRepository;
  
  @Autowired
  private WebApplicationContext webAppContext;
  
  private MockMvc mockMvc;
  
  @Before
  public void setUp() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup( this.webAppContext ).build();
  }
  
  @After
  public void tearDown() {
    this.reservationRepository.deleteAll();
  }
  
  @Test
  public void statusNotFound() throws Exception {
    
    this.mockMvc
        .perform( get( API_URI + "/1000" ) )
        .andExpect( status().isNotFound() ); 
  
  }
  
  @Test
  public void statusFoundAndMediaTypeJson() throws Exception {
    
    Reservation r = new Reservation();
    
    r.setStartDate( new java.util.Date() );
    r.setEndDate( new java.util.Date() ); 
    
    this.reservationRepository.save( r );
    
    this.mockMvc
        .perform( get( API_URI + "/" + r.getId() )  )
        .andExpect( status().isFound() )
        .andExpect( content().contentType( "application/json;charset=UTF-8" ) ); 
    
 
  }
  
  @Test
  public void deleteReservationAndStatusIsOk() throws Exception {
    
    Reservation r = new Reservation();
    
    r.setStartDate( new java.util.Date() );
    r.setEndDate( new java.util.Date() ); 
    
    this.reservationRepository.save( r );
    
    this.mockMvc
        .perform( delete( API_URI + "/" + r.getId() ) )
        .andExpect( status().isOk() ); 
  
  }
  
  @Test
  public void statusNotFoundWhenReservationDeleted() throws Exception {
    
    Reservation r = new Reservation();
    
    r.setStartDate( new java.util.Date() );
    r.setEndDate( new java.util.Date() ); 
    
    this.reservationRepository.save( r );
    
    this.mockMvc
        .perform( delete( API_URI + "/" + r.getId() ) )
        .andExpect( status().isOk() ); 
    
    this.mockMvc
        .perform( get( API_URI + "/" + r.getId() ) )
        .andExpect( status().isNotFound() );
  
  }
  
  @Test
  public void statusConflictWhenAlreadyDeleted() throws Exception {
    
    Reservation r = new Reservation();
    
    r.setStartDate( new java.util.Date() );
    r.setEndDate( new java.util.Date() ); 
    
    this.reservationRepository.save( r );
    
    this.mockMvc
        .perform( delete( API_URI + "/" + r.getId() ) )
        .andExpect( status().isOk() ); 
    
    this.mockMvc
        .perform( delete( API_URI + "/" + r.getId() ) )
        .andExpect( status().isConflict() ); 
    
    
  }
  
  
}
