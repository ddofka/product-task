package lt.projectx.producttask.repository;

import lt.projectx.producttask.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> id(Long id);

    Optional<Product> findById(Long id);

    void deleteById(Long id);

}
