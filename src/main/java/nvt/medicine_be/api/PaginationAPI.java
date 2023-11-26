package nvt.medicine_be.api;

import nvt.medicine_be.dto.Pagination;
import nvt.medicine_be.dto.ProductDTO;
import nvt.medicine_be.service.iml.PaginationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaginationAPI {
    @Autowired
    private PaginationService paginationService;
    @GetMapping("/api/pagination")
    public Pagination<ProductDTO> paginationProduct(@RequestParam(value = "page",required = false) int page, @RequestParam(value = "limit",required = false) int limit){
        return paginationService.paginationForProduct(page, limit);
    }

}
