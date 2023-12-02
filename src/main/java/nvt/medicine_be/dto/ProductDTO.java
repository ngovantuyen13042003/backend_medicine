package nvt.medicine_be.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Integer id;
    private String name;
    private BigDecimal price;
    private String description;
    private float vote;
    private String image;
    private short quantity;
    private int categoryId;
    private Integer[] ids;
}
