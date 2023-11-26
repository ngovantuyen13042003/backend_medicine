package nvt.medicine_be.repository;

import java.util.List;

import nvt.medicine_be.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    List<Product> findAll();
    List<Product> findAllByCategory_Id(Integer id);
}
