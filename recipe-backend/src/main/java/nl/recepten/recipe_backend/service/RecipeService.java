package nl.recepten.recipe_backend.service;

import nl.recepten.recipe_backend.dto.RecipeDTO;
import nl.recepten.recipe_backend.model.AppUser;
import nl.recepten.recipe_backend.model.Ingredient;
import nl.recepten.recipe_backend.model.Recipe;
import nl.recepten.recipe_backend.repository.IngredientRepository;
import nl.recepten.recipe_backend.repository.RecipeRepository;
import nl.recepten.recipe_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final UserRepository userRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, IngredientRepository ingredientRepository, UserRepository userRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.userRepository = userRepository;
    }

    public RecipeDTO createRecipe(RecipeDTO recipeDTO) {
        AppUser owner = userRepository.findById(recipeDTO.getOwnerId()).orElseThrow(() -> new RuntimeException("User not found"));
        List<Ingredient> ingredients = ingredientRepository.findAllById(recipeDTO.getIngredientIds());

        Recipe recipe = new Recipe();
        recipe.setName(recipeDTO.getName());
        recipe.setPreparation(recipeDTO.getPreparation());
        recipe.setIngredients(ingredients);
        recipe.setImage(recipeDTO.getImageUrl());
        recipe.setOwner(owner);

        Recipe savedRecipe = recipeRepository.save(recipe);

        List<Long> ingredientIds = savedRecipe.getIngredients().stream()
                .map(Ingredient::getId)
                .collect(Collectors.toList());

        return new RecipeDTO(
                savedRecipe.getName(),
                savedRecipe.getPreparation(),
                ingredientIds,
                savedRecipe.getImage(),
                savedRecipe.getOwner().getId()
        );
    }
}