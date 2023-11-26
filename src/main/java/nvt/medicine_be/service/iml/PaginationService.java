package nvt.medicine_be.service.iml;

import lombok.RequiredArgsConstructor;
import nvt.medicine_be.dto.ProductDTO;
import nvt.medicine_be.model.Product;
import nvt.medicine_be.repository.ProductRepository;
import nvt.medicine_be.service.Pagination;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaginationService implements Pagination {
    @Autowired
    private ProductRepository productRepository;
    private final ModelMapper modelMapper;
    // Default constructor for Spring to instantiate the service
    public PaginationService() {
        this.modelMapper = new ModelMapper();
    }
    @Override
    public nvt.medicine_be.dto.Pagination<ProductDTO> paginationForProduct(Integer page, Integer limit) {
        nvt.medicine_be.dto.Pagination<ProductDTO> pg = new nvt.medicine_be.dto.Pagination<>();
        List<Product> prs = productRepository.findAll(PageRequest.of(page-1, limit)).getContent();
        List<ProductDTO> prdto = new ArrayList<>();
        for (Product product : prs) {
            prdto.add(modelMapper.map(product, ProductDTO.class));
        }
        pg.setListResult(prdto);
        pg.setTotalItem((int)productRepository.count());
        pg.setLimit(limit);
        pg.setPage(page);
        pg.setTotalPage((int) Math.ceil((double) pg.getTotalItem() / pg.getLimit()));
        return pg;
    }
}
