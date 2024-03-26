package co.istad.jbsdemo.springjba.repository;

import co.istad.jbsdemo.springjba.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
