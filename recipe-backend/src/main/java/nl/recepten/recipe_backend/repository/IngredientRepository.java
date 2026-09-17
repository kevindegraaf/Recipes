package nl.recepten.recipe_backend.repository;

import nl.recepten.recipe_backend.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    // Custom query methods for ingredients if needed
}