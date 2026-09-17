package nl.recepten.recipe_backend.controller;

import nl.recepten.recipe_backend.dto.RecipeDTO;
import nl.recepten.recipe_backend.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<RecipeDTO> createRecipe(@RequestBody RecipeDTO recipeDTO) {
        RecipeDTO savedRecipe = recipeService.createRecipe(recipeDTO);
        return new ResponseEntity<>(savedRecipe, HttpStatus.CREATED);
    }
}
