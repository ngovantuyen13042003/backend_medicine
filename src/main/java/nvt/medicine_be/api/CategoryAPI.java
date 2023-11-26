package nvt.medicine_be.api;

import nvt.medicine_be.dto.CategoryDTO;
import nvt.medicine_be.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryAPI {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/api/category")
    public List<CategoryDTO> getCategory(){
        return categoryService.findAll();
    }

}
