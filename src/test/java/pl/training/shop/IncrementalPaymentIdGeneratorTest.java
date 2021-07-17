package pl.training.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.training.shop.payments.IncrementalPaymentIdGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IncrementalPaymentIdGeneratorTest {

    private static final String ID_FORMAT = "\\d{10}";
    private final IncrementalPaymentIdGenerator paymentIdGenerator = new IncrementalPaymentIdGenerator();

    @DisplayName("Should generate valid id")
    @Test
    void shouldGenerateValidId(){
        String id = paymentIdGenerator.getNext();
        assertTrue(id.matches(ID_FORMAT));
    }

    @DisplayName("Should generate id by incrementing value of previous one")
    @Test
    void shouldGenerateIdByIncrementingValue(){
        long firstValue = Long.parseLong(paymentIdGenerator.getNext());
        long nextValue = Long.parseLong(paymentIdGenerator.getNext());
        assertEquals(nextValue, firstValue+1);
    }

}


