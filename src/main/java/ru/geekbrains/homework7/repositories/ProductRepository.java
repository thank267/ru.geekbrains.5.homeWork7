package ru.geekbrains.homework7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.homework7.entities.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

	List<Product> findByCostBetween(Integer min, Integer max);
}
