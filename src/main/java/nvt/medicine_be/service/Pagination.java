package nvt.medicine_be.service;

import nvt.medicine_be.dto.ProductDTO;

public interface Pagination {
    nvt.medicine_be.dto.Pagination<ProductDTO> paginationForProduct(Integer page, Integer limit);
}
