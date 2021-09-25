package pl.training.shop.payments;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;


@Configuration
public class PaymentsConfig {


    @Bean
    public PaymentIdGenerator UUIDPaymentIdGenerator(){
        return new UUIDPaymentIdGenerator();
    }

   // @Bean
   // public PaymentRepository paymentRepository(){
     //   return new PaymentRepositoryHashMap();
    //
    // }
   // public PaymentRepository paymentRepository(){
     //   return new JpaPaymentRepository();
    //}

    @Bean
    public PaymentService fakePaymentService(PaymentIdGenerator paymentIdGenerator, PaymentRepository paymentRepository, ApplicationEventPublisher eventPublisher){
        return new FakePaymentService(paymentIdGenerator, paymentRepository, eventPublisher);
    }



    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public PaymentConsoleLogger paymentConsoleLogger(MessageSource messageSource){
        return new PaymentConsoleLogger(messageSource);
    }


}
