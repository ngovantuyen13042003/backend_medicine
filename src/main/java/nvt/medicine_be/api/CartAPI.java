package nvt.medicine_be.api;

import nvt.medicine_be.dto.CartDTO;
import nvt.medicine_be.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

@RestController
public class CartAPI {
    @Autowired
    private CartService cartService;
    @GetMapping("/api/cart/{idCart}")
    public List<CartDTO> getCart(@PathVariable("idCart") Integer id){
        return cartService.getCart(id);
    }
    @PostMapping("/api/cart")
    public CartDTO addToCart(@RequestBody CartDTO dto) {
        return cartService.addToCart(dto);
    }
    @PutMapping("/api/cart")
    public void updateQuantity(@RequestBody CartDTO dto) {
        cartService.updateQuantity(dto.getQuantity(), dto.getIdUser(), dto.getIdProduct());
    }
    @DeleteMapping("/api/cart")
    public void deleteCart(@RequestBody CartDTO dto) {
        cartService.deleteCart(dto.getIds());
    }
    @DeleteMapping("/api/cart/{idCart}")
    public void deleteOneCart(@PathVariable("idCart") Integer idCart) {
        cartService.deleteCart(idCart);
    }
}
