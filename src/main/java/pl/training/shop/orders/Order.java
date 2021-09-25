package pl.training.shop.orders;

import lombok.*;
import org.javamoney.moneta.FastMoney;
import pl.training.shop.payments.LocalMoney;
import pl.training.shop.payments.Payment;
import pl.training.shop.products.Product;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.List;

@Table(name = "orders")
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class Order {


    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    @NonNull
    @ManyToMany
            //(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Product> products;

    @OneToOne(cascade = CascadeType.MERGE)
    private Payment payment;
    private Instant timestamp;

    public FastMoney getTotalPrice(){
        return  products.stream()
                .map(Product::getPrice)
                .reduce(LocalMoney.zero(), FastMoney::add);
    }
}
