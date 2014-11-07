
package fi.oksanen.e2Reservation.service.exception;

/**
 *
 * @author Toni Oksanen
 */
public class DoesNotExistException extends Exception {
  public DoesNotExistException( String message ) {
    super( message );
  }
}
