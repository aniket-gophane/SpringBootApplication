package com.test.MachineTestPro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
//@Controller
//@RequestMapping("/api/categories") 
public class CategoryController { 
	
	@Autowired 
	CategoryRepository categoryRepository;

	@GetMapping("/api/categories")
	public List<Category> getAllCategories() {
	    return categoryRepository.findAll();
	}
	
	@PostMapping("/api/categories")
	public String createCategory(Category category)
	{
		System.out.println("Category add successful");
		categoryRepository.save(category);
		return "Data Added";
	}
	
//	@PostMapping
//	public Category createCategory(@RequestBody Category category) {
//	    return categoryRepository.save(category);
//	}
	
	@GetMapping("/api/categories/{id}")
	public Category getCategoryById(@PathVariable Long id) {
	    return categoryRepository.findById(id).orElse(null);
	}
	
	@PutMapping("/api/categories/{id}")
	public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
	    category.setId(id);
	    return categoryRepository.save(category);
	}
	
	@DeleteMapping("/api/categories/{id}")
	public void deleteCategory(@PathVariable Long id) {
	    categoryRepository.deleteById(id);
	}
	
}
