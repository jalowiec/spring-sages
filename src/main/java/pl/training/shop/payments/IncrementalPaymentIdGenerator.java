package pl.training.shop.payments;

import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@IdGenerator("incremental")
public class IncrementalPaymentIdGenerator implements PaymentIdGenerator{

    private static final String ID_FORMAT = "%010d";

    @Setter
    private long index;


    @Override
    public String getNext() {
        return String.format(ID_FORMAT, ++index);
    }
}
