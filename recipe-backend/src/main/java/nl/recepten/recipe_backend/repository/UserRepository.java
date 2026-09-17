package nl.recepten.recipe_backend.repository;

import nl.recepten.recipe_backend.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
}