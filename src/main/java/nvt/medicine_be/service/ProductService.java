package nvt.medicine_be.service;

import nvt.medicine_be.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll(Integer id);
    ProductDTO Save(ProductDTO product);
    void delete(Integer[] ids);
    List<ProductDTO> findAllByCategory(Integer id);
}
