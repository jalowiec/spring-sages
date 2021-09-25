package pl.training.shop.products;

import lombok.*;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.TypeDef;
import org.javamoney.moneta.FastMoney;
import pl.training.shop.common.FastMoneyUserType;

import javax.persistence.*;

@NamedQuery(name = Product.SELECT_PRODUCTS, query = "select p from Product p")
@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@TypeDef(name = "fastMoney", typeClass = FastMoneyUserType.class, defaultForType = FastMoney.class)
@Table(name="products")
@EqualsAndHashCode(exclude = "id")

public class Product {

    public static final String SELECT_PRODUCTS = "selectProducts";

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @Columns(columns = {
            @Column(name = "currency", length = 3),
            @Column(name = "value")
    })
    private FastMoney price;
    @Enumerated(EnumType.ORDINAL)
    private ProductType type;
}
