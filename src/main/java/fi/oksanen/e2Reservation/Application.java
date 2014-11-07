package fi.oksanen.e2Reservation;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Toni Oksanen
 */

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
  
  public static void main( String[] args ) {
    SpringApplication.run( Application.class, args );
  }
  
}
