package pl.training.shop.products;


import lombok.Data;

import org.javamoney.moneta.FastMoney;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotEmpty;



@Data
public class ProductTransferObject extends RepresentationModel<ProductTransferObject> {


    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
   // @NotEmpty
    private String price;
   // @NotEmpty
    private ProductType type;

}
