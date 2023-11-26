package nvt.medicine_be.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CartDTO {
    private Integer idCart;
    private Integer idUser;
    private Integer idProduct;
    private String name;
    private BigDecimal price;
    private short quantity;
    private Integer[] ids;
}
