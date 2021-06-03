package seanlindev.springframework.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import seanlindev.springframework.domain.Recipe;
import seanlindev.springframework.repositories.RecipeRepository;

import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void saveImageFile(Long recipeId, MultipartFile file) {
        log.debug("save a image for recipe");
        try {
            Recipe recipe = recipeRepository.findById(recipeId).get();
            Byte[] byteObjects = new Byte[file.getBytes().length];
            int i = 0;
            for (byte b : file.getBytes()) {
                byteObjects[i++] = b;
            }
            recipe.setImage(byteObjects);
            recipeRepository.save(recipe);
        } catch (IOException exception) {
            log.error("Failed to read file data");
            exception.printStackTrace();
        }

    }
}
