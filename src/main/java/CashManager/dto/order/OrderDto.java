package CashManager.dto.order;

import CashManager.dto.payement.PayementDto;
import CashManager.dto.product.ProductDto;
import CashManager.dto.user.SupplierDto;
import jdk.nashorn.internal.objects.annotations.Constructor;
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

    public OrderDto() { }

    public OrderDto(Integer id, Double total, Double poid, Date payementDate, OrderStatusDto orderStatusDto, PayementDto payementDto, SupplierDto supplierDto, List<ProductDto> productDtos) {
        this.id = id;
        this.total = total;
        this.poid = poid;
        this.payementDate = payementDate;
        this.orderStatusDto = orderStatusDto;
        this.payementDto = payementDto;
        this.supplierDto = supplierDto;
        this.productDtos = productDtos;
    }
}
