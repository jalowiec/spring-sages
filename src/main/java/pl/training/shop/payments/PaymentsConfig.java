package pl.training.shop.payments;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ResourceBundleMessageSource;
import pl.training.shop.ShopService;
import pl.training.shop.common.ContextListener;
import pl.training.shop.orders.OrderRepository;
import pl.training.shop.orders.OrderRepositoryHashMap;
import pl.training.shop.orders.OrderService;
import pl.training.shop.products.ProductRepository;
import pl.training.shop.products.ProductRepositoryHashMap;
import pl.training.shop.products.ProductService;

@Configuration
public class PaymentsConfig {


    @Bean
    public PaymentIdGenerator UUIDPaymentIdGenerator(){
        return new UUIDPaymentIdGenerator();
    }

    @Bean
    public PaymentRepository paymentRepository(){
        return new PaymentRepositoryHashMap();
    }

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
