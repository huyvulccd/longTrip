package nhvu.xekhach.UserSite.logic.reposities;

import nhvu.xekhach.UserSite.logic.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
