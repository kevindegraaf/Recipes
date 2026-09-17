package nl.recepten.recipe_backend.dto;

import java.util.List;

public class RecipeDTO {
    private String name;
    private String preparation;
    private List<Long> ingredientIds;
    private String image;
    private Long owner;

    public RecipeDTO(String name, String preparation, List<Long> ingredientIds, String image, Long owner) {
        this.name = name;
        this.preparation = preparation;
        this.ingredientIds = ingredientIds;
        this.image = image;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public List<Long> getIngredientIds() {
        return ingredientIds;
    }

    public void setIngredientIds(List<Long> ingredientIds) {
        this.ingredientIds = ingredientIds;
    }

    public String getImageUrl() {
        return image;
    }

    public void setImageUrl(String imageUrl) {
        this.image = image;
    }

    public Long getOwnerId() {
        return owner;
    }

    public void setOwnerId(Long userId) {
        this.owner = userId;
    }
}