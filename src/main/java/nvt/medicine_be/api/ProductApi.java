package nvt.medicine_be.api;

import nvt.medicine_be.dto.ProductDTO;
import nvt.medicine_be.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "Product")
public class ProductApi {
    @Autowired
    private ProductService productService;
    @PostMapping("/api/product")
    public ProductDTO createProduct(@RequestBody ProductDTO dto) {
        ProductDTO savedProduct = productService.Save(dto);
        return savedProduct;
    }
    @PutMapping("/api/product")
    public ProductDTO updateProduct(@RequestBody ProductDTO dto) {
        ProductDTO updatedProduct = productService.Save(dto);
        return updatedProduct;
    }
    @DeleteMapping("/api/product")
    public void deleteProduct(@RequestBody ProductDTO dto) {
        productService.delete(dto.getIds());
    }
    @GetMapping("/api/product")
    public List<ProductDTO> getProduct(@RequestParam(value = "id",required = false) Integer id) {
        return productService.findAll(id);
    }
    @GetMapping("/api/product/{idcategory}")
    public List<ProductDTO> getProductByCategory(@PathVariable("idcategory") Integer id){
        return productService.findAllByCategory(id);
    }
}
