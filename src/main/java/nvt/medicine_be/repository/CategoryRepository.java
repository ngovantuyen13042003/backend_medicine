package nvt.medicine_be.repository;

import java.util.List;

import nvt.medicine_be.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
    List<Category> findAll();
}
