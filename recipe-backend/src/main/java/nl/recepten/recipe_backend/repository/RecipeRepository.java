package nl.recepten.recipe_backend.repository;

import nl.recepten.recipe_backend.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    // define custom sql logic
}