package coffee.Repository;

import coffee.Entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoCoffee extends JpaRepository<Coffee, Long> {

}
