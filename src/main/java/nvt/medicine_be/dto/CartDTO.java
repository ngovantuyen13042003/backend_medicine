package nvt.medicine_be.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class CartDTO {
    private Integer idCart;
    private Integer idUser;
    private Integer idProduct;
    private String name;
    private Integer price;
    private short quantity;
    private Integer totalPrice;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private String imgurl;
    private Integer[] ids;
}
