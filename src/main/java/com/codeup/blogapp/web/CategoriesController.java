package com.codeup.blogapp.web;

import com.codeup.blogapp.data.CategoriesRepository;
import com.codeup.blogapp.data.Category;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api/categories", headers = "Accept=application/json")
  public class CategoriesController<CategoryRepository> {

     private final CategoriesRepository categoryRepository;

     public CategoriesController(CategoriesRepository categoryRepository){
       this.categoryRepository = categoryRepository;
     }




  @GetMapping
    private List<Category> getCategories(){
        return categoryRepository.findAll();

    }

  @GetMapping("/{id}")
  private Category getPostsByCategory(@PathVariable Long id){

      return categoryRepository.findById(id).get();
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
