package in.rajeshit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.rajeshit.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
