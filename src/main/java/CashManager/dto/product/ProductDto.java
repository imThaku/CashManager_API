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

    public ProductDto() {}

    public ProductDto(Integer id, String libelle, String description, Double prix, Double poid, ProductTypeDto productTypeDto) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.prix = prix;
        this.poid = poid;
        this.productTypeDto = productTypeDto;
    }
}
