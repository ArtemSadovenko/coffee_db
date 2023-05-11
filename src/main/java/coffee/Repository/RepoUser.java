package coffee.Repository;

import coffee.Entity.Coffee;
import coffee.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoUser  extends JpaRepository<User, Long> {
}
