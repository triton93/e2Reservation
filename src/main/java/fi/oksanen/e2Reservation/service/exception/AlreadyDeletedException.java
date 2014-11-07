
package fi.oksanen.e2Reservation.service.exception;

/**
 *
 * @author Toni Oksanen
 */
public class AlreadyDeletedException extends Exception {
  public AlreadyDeletedException( String message ) {
    super( message );
  }
}
