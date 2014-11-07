
package fi.oksanen.e2Reservation.repository;

import fi.oksanen.e2Reservation.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Toni Oksanen
 */
public interface RoomRepository extends JpaRepository<Room, Long> {
  
}
