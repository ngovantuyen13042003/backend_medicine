package nvt.medicine_be.service.iml;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import nvt.medicine_be.dto.CartDTO;
import nvt.medicine_be.model.Cart;
import nvt.medicine_be.model.Product;
import nvt.medicine_be.repository.CartRepository;
import nvt.medicine_be.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService implements nvt.medicine_be.service.CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    private final ModelMapper modelMapper;
    // Default constructor for Spring to instantiate the service
    public CartService() {
        this.modelMapper = new ModelMapper();
    }
    @Override
    public List<CartDTO> getCart(Integer idUser) {
        List<Cart> carts = cartRepository.findByIdUser(idUser);
        List<CartDTO> cartDtos = new ArrayList<>();
        for (Cart c : carts) {
            cartDtos.add(modelMapper.map(c, CartDTO.class));
        }
        return cartDtos;
    }
    @Transactional
    @Override
    public CartDTO addToCart(CartDTO cartDTO) {
        Cart cartOld = cartRepository.findByIdUserAndIdProduct(cartDTO.getIdUser(), cartDTO.getIdProduct());
        if(cartOld!=null) {
            cartOld.setQuantity((short)(cartOld.getQuantity()+1));
            cartOld.setPrice(cartOld.getPrice().add(cartOld.getPrice()));
            return modelMapper.map(cartRepository.save(cartOld), CartDTO.class);
        }else {
            Cart cart =  new Cart();
            Product product = productRepository.findById(cartDTO.getIdProduct()).get();
            cart.setIdUser(cartDTO.getIdUser());
            cart.setIdProduct(cartDTO.getIdProduct());
            cart.setQuantity((short)1);
            cart.setImgurl(product.getImage());
            cart.setTotalPrice(product.getPrice() );
            cart.setName(product.getName());
            cart.setPrice(product.getPrice());
            cartRepository.save(cart);
            return modelMapper.map(cart, CartDTO.class);
        }
    }
    @Transactional
    @Override
    public void updateQuantity(Short quantity, Integer idUser, Integer idProduct) {
        Product product = productRepository.findById(idProduct).get();
        Cart cartOld = cartRepository.findByIdUserAndIdProduct(idUser, idProduct);
        cartOld.setQuantity(quantity);
        cartOld.setPrice(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
        cartRepository.save(cartOld);
    }
    @Override
    public void deleteCart(Integer[] ids) {
        // TODO Auto-generated method stub
        for (int i=0;i<ids.length;i++) {
            cartRepository.deleteById(ids[i]);
        }
    }

    public void deleteCart(Integer id) {
        // TODO Auto-generated method stub
        cartRepository.deleteById(id);
    }
}
