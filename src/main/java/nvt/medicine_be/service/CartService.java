package nvt.medicine_be.service;

import nvt.medicine_be.dto.CartDTO;

import java.util.List;

public interface CartService {
    List<CartDTO> getCart(Integer idUser);
    CartDTO addToCart (Integer idUser, Integer idProduct);
    void updateQuantity(Short quantity, Integer idUser, Integer idProduct);
    void deleteCart(Integer[] ids);
}
