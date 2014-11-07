
package fi.oksanen.e2Reservation.service.exception;

/**
 *
 * @author Toni Oksanen
 */
public class AlreadyExistsException extends Exception {
  public AlreadyExistsException( String message ) {
    super( message );
  }
}
