package CashManager.dto.user;

import CashManager.dto.adresse.AdresseDto;
import CashManager.dto.order.OrderDto;
import CashManager.dto.payement.PayementDto;
import CashManager.dto.product.ProductDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerDto extends UserDto {

    private PayementDto payementDto;

    private List<ProductDto> cart;

    private OrderDto orderDto;

    @Builder
    public CustomerDto(Integer id, String username, String password, String Email, String firstName, String lastName, AdresseDto adresseDto, PayementDto payementDto, List<ProductDto> cart, OrderDto orderDto) {
        super(id, username, password, Email, firstName, lastName, adresseDto);
        this.payementDto = payementDto;
        this.cart = cart;
        this.orderDto = orderDto;
    }
}
