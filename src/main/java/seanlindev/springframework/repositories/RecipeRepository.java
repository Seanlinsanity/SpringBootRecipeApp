package seanlindev.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import seanlindev.springframework.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
