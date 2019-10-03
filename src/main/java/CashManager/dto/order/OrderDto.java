package CashManager.dto.order;

import CashManager.dto.payement.PayementDto;
import CashManager.dto.product.ProductDto;
import CashManager.dto.user.SupplierDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class OrderDto {

    private Integer id;

    private Double total;

    private Double poid;

    private Date payementDate;

    private OrderStatusDto orderStatusDto;

    private PayementDto payementDto;

    private SupplierDto supplierDto;

    private List<ProductDto> productDtos;
}
