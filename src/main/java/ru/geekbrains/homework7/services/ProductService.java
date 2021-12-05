package ru.geekbrains.homework7.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework7.entities.Product;
import ru.geekbrains.homework7.repositories.ProductRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
@Slf4j
@AllArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	@Transactional
	public Optional<Product> deleteById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		product.ifPresent(p-> productRepository.deleteById(p.getId()));
		return product;

	}

	public Product save(Product product) {
		return productRepository.save(product);

	}

	public List<Product> filter(Integer min, Integer max) {
		return productRepository.findByCostBetween(min, max);
	}
}
