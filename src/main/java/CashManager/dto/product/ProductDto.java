package CashManager.dto.product;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDto {

    private Integer id;

    private String libelle;

    private String description;

    private Double prix;

    private Double poid;

    private ProductTypeDto productTypeDto;

}
