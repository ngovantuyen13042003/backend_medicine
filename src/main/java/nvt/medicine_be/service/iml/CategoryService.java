package nvt.medicine_be.service.iml;

import lombok.RequiredArgsConstructor;
import nvt.medicine_be.dto.CategoryDTO;
import nvt.medicine_be.model.Category;
import nvt.medicine_be.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements nvt.medicine_be.service.CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    // Default constructor for Spring to instantiate the service
    public CategoryService() {
        this.modelMapper = new ModelMapper();
    }
    @Override
    public List<CategoryDTO> findAll() {
        // TODO Auto-generated method stub
        List<CategoryDTO> categoryDTOs = new ArrayList<>();
        List<Category> categories = categoryRepository.findAll();
        for (Category category : categories) {
            categoryDTOs.add(modelMapper.map(category, CategoryDTO.class));
        }
        return categoryDTOs;
    }
}
