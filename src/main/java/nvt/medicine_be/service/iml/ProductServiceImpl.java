package nvt.medicine_be.service.iml;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import nvt.medicine_be.dto.ProductDTO;
import nvt.medicine_be.model.Category;
import nvt.medicine_be.model.Product;
import nvt.medicine_be.repository.CategoryRepository;
import nvt.medicine_be.repository.ProductRepository;
import nvt.medicine_be.service.ICloudinaryService;
import nvt.medicine_be.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ICloudinaryService cloudinaryService;

    private final ModelMapper modelMapper;
    // Default constructor for Spring to instantiate the service
    public ProductServiceImpl() {
        this.modelMapper = new ModelMapper();
    }
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductDTO> findAll(Integer id) {
        List<ProductDTO> productsDTO = new ArrayList<>();
        if(id!=null) {
            productsDTO.add(modelMapper.map(productRepository.findById(id).get(), ProductDTO.class));
        }else {
            List<Product> products = productRepository.findAll();
            for (Product product : products) {
                productsDTO.add(modelMapper.map(product, ProductDTO.class));
            }
        }
        return productsDTO;
    }

    @Override
    @Transactional
    public ProductDTO Save(ProductDTO dto) {
        Category category = categoryRepository.findById(dto.getCategoryId()).get();
        Product newProduct = new Product();
        if(dto.getId()!=null) {
            Product oldProduct = productRepository.findById(dto.getId()).get();
            oldProduct = modelMapper.map(dto, Product.class);
            oldProduct.setCategory(category);
            return modelMapper.map(productRepository.save(oldProduct), ProductDTO.class);
        }else {
            newProduct = modelMapper.map(dto, Product.class);
            newProduct.setCategory(category);
            return modelMapper.map(productRepository.save(newProduct), ProductDTO.class);
        }
    }


    @Override
    public ProductDTO SaveWithImg(ProductDTO dto) {
        Product newP = modelMapper.map(dto, Product.class);
        String urlImg = cloudinaryService.upload(dto.getFileImg(), "images_medicine");
        newP.setImage(urlImg);
        Product savedProduct = productRepository.save(newP);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    @Override
    @Transactional
    public void delete(Integer[] ids) {
        for(int i=0;i<ids.length;i++) {
            productRepository.deleteById(ids[i]);
        }
    }

    @Override
    public  List<ProductDTO> findAllByCategory(Integer id) {
        Category cate = categoryRepository.findById(id).get();
        List<Product> prs = cate.getProducts();
        List<ProductDTO> prdto = new ArrayList<>();
        for (Product pr : prs) {
            prdto.add(modelMapper.map(pr, ProductDTO.class));
        }
        return prdto;
    }
}
