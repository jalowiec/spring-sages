package pl.training.shop.payments;

import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

//@Repository("paymentRepository")
public class PaymentRepositoryHashMap{
    //implements } PaymentRepository{

    @Setter
    private Map<String, Payment> paymentMap = new HashMap<>();

    //@Override
    public Payment save(Payment payment) {
        paymentMap.put(payment.getId().toString(), payment);
        return payment;
    }
}
