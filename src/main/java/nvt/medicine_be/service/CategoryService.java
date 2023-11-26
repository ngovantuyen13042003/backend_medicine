package nvt.medicine_be.service;

import nvt.medicine_be.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> findAll();
}
