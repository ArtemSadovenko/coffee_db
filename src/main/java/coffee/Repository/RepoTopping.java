package coffee.Repository;

import coffee.Entity.Coffee;
import coffee.Entity.Topping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoTopping  extends JpaRepository<Topping, Long> {
}
