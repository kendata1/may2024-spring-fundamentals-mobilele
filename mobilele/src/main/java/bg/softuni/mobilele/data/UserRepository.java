package bg.softuni.mobilele.data;

import bg.softuni.mobilele.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUsername (String username);
}
