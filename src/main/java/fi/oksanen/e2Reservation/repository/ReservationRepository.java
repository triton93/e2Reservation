
package fi.oksanen.e2Reservation.repository;

import fi.oksanen.e2Reservation.domain.Reservation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Toni Oksanen
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
  public List<Reservation> findByRemovedFalse();
}
