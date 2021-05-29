package seanlindev.springframework.services;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import seanlindev.springframework.commands.RecipeCommand;
import seanlindev.springframework.converters.RecipeCommandToRecipe;
import seanlindev.springframework.converters.RecipeToRecipeCommand;
import seanlindev.springframework.domain.Recipe;
import seanlindev.springframework.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceImplTest {

    @Mock
    RecipeRepository recipeRepository;
    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;
    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    RecipeServiceImpl recipeService;

    @BeforeEach
    void setUp() {
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    void getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipe.setDescription("Pizza");
        recipeSet.add(recipe);
        when(recipeRepository.findAll()).thenReturn(recipeSet);

        Assertions.assertEquals(recipeService.getRecipes(), recipeSet);
    }

    @Test
    void findById() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipe.setDescription("Pizza");
        when(recipeRepository.findById(1L)).thenReturn(Optional.ofNullable(recipe));

        Assertions.assertEquals(recipeService.findById(1L), recipe);
    }
}
