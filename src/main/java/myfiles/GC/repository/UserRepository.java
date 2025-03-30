package myfiles.GC.repository;

import myfiles.GC.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username); // Optional: Add a method to find a user by username
}