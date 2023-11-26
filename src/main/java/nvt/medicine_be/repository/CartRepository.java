package nvt.medicine_be.repository;


import java.util.List;

import nvt.medicine_be.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CartRepository extends JpaRepository<Cart, Integer>{
    List<Cart> findByIdUser(Integer id);
    Cart findByIdUserAndIdProduct(Integer idUser,Integer idProduct);
}
