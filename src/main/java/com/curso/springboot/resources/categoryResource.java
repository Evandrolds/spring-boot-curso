
package com.curso.springboot.resources;

import com.curso.springboot.entities.Category;
import com.curso.springboot.services.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Evandro
 */
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> cat = categoryService.findAll();
        return ResponseEntity.ok().body(cat);
    }
   @GetMapping(value = "/{id}") //paramentro que será usado na requisição HTTP do postman
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category or = categoryService.findById(id);
        return ResponseEntity.ok().body(or);
    }
}
