package pl.training.shop;

import org.javamoney.moneta.FastMoney;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.training.shop.payments.*;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
@ExtendWith(MockitoExtension.class)
public class PaymentRepositoryHashMapTest {

    private static final String PAYMENT_ID = "1";
    private static final Payment PAYMENT = Payment.builder()
            .id(PAYMENT_ID)
            .build();
    private final PaymentRepositoryHashMap paymentRepository = new PaymentRepositoryHashMap();

    @Mock
    private Map<String, Payment> payments;


    @BeforeEach
    void setUp() {
        paymentRepository.setPaymentMap(payments);
    }

    @Test
    void shouldSavePayment(){
        paymentRepository.save(PAYMENT);
        Mockito.verify(payments).put(PAYMENT_ID, PAYMENT);
    }
}
