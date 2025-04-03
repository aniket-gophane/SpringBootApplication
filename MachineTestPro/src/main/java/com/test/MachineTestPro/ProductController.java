package com.test.MachineTestPro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController 
@RequestMapping("/api/products") 
public class ProductController { 
	
	@Autowired 
	ProductRepository productRepository;

	@GetMapping("/api/products")
	public List<Product> getAllProducts() {
	    return productRepository.findAll();
	}
	
	@PostMapping("/api/products")
	public String createProduct(Product product)
	{
		System.out.println("Product Successfully Add");
		productRepository.save(product);
		return "Product Added ";
	}
	
//	@PostMapping("/products")
//	public Product createProduct(@RequestBody Product product) {
//	    return productRepository.save(product);
//	}
	
	@GetMapping("/api/products/{pId}")
	public Product getProductById(@PathVariable Long pId) {
	    return productRepository.findById(pId).orElse(null);
	}
	
	@PutMapping("/api/products/{pId}")
	public Product updateProduct(@PathVariable Long pId, @RequestBody Product product) {
	    product.setpId(pId);
	    return productRepository.save(product);
	}
	
	@DeleteMapping("/api/products/{pId}")
	public void deleteProduct(@PathVariable Long pId) {
	    productRepository.deleteById(pId);
	}

}
