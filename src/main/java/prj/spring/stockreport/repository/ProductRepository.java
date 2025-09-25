package prj.spring.stockreport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prj.spring.stockreport.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}