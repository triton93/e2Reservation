
package fi.oksanen.e2Reservation.repository;

import fi.oksanen.e2Reservation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Toni Oksanen
 */
public interface UserRepository extends JpaRepository<User, Long> {
  
}
