package pl.training.shop.payments;

import lombok.extern.java.Log;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Log
public class PaymentStatusChangeListener {

    @Async
    @EventListener
    public void onPaymentStatusChange(PaymentsStatusChangedEvent statusChangedEvent){
        log.info("Payment statuss " + statusChangedEvent.getPayment());
    }

}
