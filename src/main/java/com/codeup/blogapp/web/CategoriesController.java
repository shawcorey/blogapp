package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Category;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api/categories", headers = "Accept=application/json")
  public class CategoriesController<CategoryRepository> {

     private final CategoryRepository categoryRepository;

     public CategoriesController(CategoryRepository categoryRepository){
       this.categoryRepository = categoryRepository;
     }




  @GetMapping
    private List<Category> getCategories(){
        return categoryRepository.findAll();

    }

  @GetMapping("/{id}")
  private Category getPostsByCategory(@PathVariable Long id){

      return categoryRepository.getById(id);
  }

}

//public class CategoriesController {
//
//    private Object Category;
//
//    private Object getPostsByCategory(@RequestParam String categoryName){
//        return Category;
//    }
//
//    public CategoriesController(Object category) {
//        Category = category;
//    }
//}
