
package fi.oksanen.e2Reservation.controller;

import fi.oksanen.e2Reservation.service.exception.AlreadyDeletedException;
import fi.oksanen.e2Reservation.service.exception.AlreadyExistsException;
import fi.oksanen.e2Reservation.service.exception.DoesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

// Lisätään tänne jossain välissä lokitukset ja virheilmoitusolioiden
// palautus jsonia rest-apin käyttäjälle. 

/**
 *
 * @author Toni Oksanen
 */
@ControllerAdvice
public class ExceptionHandlerController {
  
  @ResponseStatus( HttpStatus.CONFLICT )
  @ExceptionHandler( AlreadyExistsException.class )
  public void handleAlreadyExistsException( AlreadyExistsException e ) {
    System.out.println( "Tapahtui virhe: " + e.getMessage() );
  }
  
  @ResponseStatus( HttpStatus.CONFLICT )
  @ExceptionHandler( AlreadyDeletedException.class )
  public void handleAlreadyDeletedException( AlreadyDeletedException e ) {
    System.out.println( "Tapahtui virhe: " + e.getMessage() );
  }
  
  @ResponseStatus( HttpStatus.NOT_FOUND )
  @ExceptionHandler( DoesNotFoundException.class )
  public void handleDoesNotFoundException( DoesNotFoundException e ) {
    System.out.println( "Tapahtui virhe: " + e.getMessage() );
  }
  
}
