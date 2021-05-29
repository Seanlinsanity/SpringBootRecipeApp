package seanlindev.springframework.services;

import seanlindev.springframework.commands.RecipeCommand;
import seanlindev.springframework.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
