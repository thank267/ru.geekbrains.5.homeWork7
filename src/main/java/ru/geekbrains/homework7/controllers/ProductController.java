package ru.geekbrains.homework7.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.homework7.entities.Product;
import ru.geekbrains.homework7.exceptions.ResourceNotFoundException;
import ru.geekbrains.homework7.services.ProductService;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@Slf4j
@Validated
public class ProductController {

	private final ProductService service;

	@GetMapping
	public List<Product> index(Model model) {
		return service.findAll();
	}

	@PostMapping( consumes = "application/json", produces = "application/json")
	public Product save(@RequestBody Product product) {
		return service.save(product);
	}

	@GetMapping("/{id}")
	public Product findById(@PathVariable("id") Long id) {
		return service.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product Not Found id: "+ id ));

	}

	@GetMapping("/delete/{id}")
	public Product delete(@PathVariable("id") long id) {
		return service.deleteById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Unable delete Product by id: "+ id ));

	}

	@GetMapping("/filter")
	public List<Product> filter(@RequestParam(defaultValue = "0") @PositiveOrZero() Integer min, @RequestParam(defaultValue = Integer.MAX_VALUE + "") @PositiveOrZero() Integer max) {
		return service.filter(min, max);

	}
}
