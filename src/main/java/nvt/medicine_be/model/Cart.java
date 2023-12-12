package nvt.medicine_be.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name ="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "tinyint")
    private Integer id;
    @Column
    private String name;
    @Column
    private BigDecimal price;
    @Column
    private short quantity;
    @Column
    private Integer idProduct;
    @Column
    private Integer idUser;
    @Column
    private String imgurl;
    @Column
    private BigDecimal totalPrice;
}
