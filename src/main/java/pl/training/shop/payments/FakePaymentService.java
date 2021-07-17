package pl.training.shop.payments;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.Instant;

@Log
@RequiredArgsConstructor
//@Scope(BeanDefinition.SCOPE_SINGLETON)
//@Service("paymentService")
public class FakePaymentService implements PaymentService {

    private final PaymentIdGenerator paymentIdGenerator;
    private final  PaymentRepository paymentRepository;



    @LogPayments
    @Override
    public Payment process(PaymentRequest paymentRequest){
        var payment = Payment.builder()
                .id(paymentIdGenerator.getNext())
                .money(paymentRequest.getMoney())
                .timestamp(Instant.now())
                .status(PaymentStatus.STARTED)
                .build();
        return paymentRepository.save(payment);

    }

   //@PostConstruct
    public void init(){
        log.info("init function");
    }

    //@PreDestroy
    public void destroy(){
        log.info("destroy function");
    }



}