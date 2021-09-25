package pl.training.shop.payments;

import lombok.*;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.TypeDef;
import org.javamoney.moneta.FastMoney;
import pl.training.shop.common.FastMoneyUserType;

import javax.persistence.*;
import java.time.Instant;

@TypeDef(name = "fastMoney", typeClass = FastMoneyUserType.class, defaultForType = FastMoney.class)
@Table(name="payments", indexes = @Index(name="payment_status", columnList = "status"))
@Data
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Table - opcjonalna - gdy chcemy swoja nazwe tabeli ustawic

@EqualsAndHashCode(exclude = "id")
public class Payment {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Columns(columns = {
            @Column(name = "currency", length = 3),
            @Column(name = "value")
    })
    private FastMoney money;
    private Instant timestamp;

    @Enumerated(EnumType.STRING)
    //albo EnumType.Ordinal - nr.kolejnosci
    private PaymentStatus status;



}
