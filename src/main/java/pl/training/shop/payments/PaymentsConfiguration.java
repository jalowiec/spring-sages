package pl.training.shop.payments;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

//@Configuration
@EnableAspectJAutoProxy
public class PaymentsConfiguration {

    @Bean(name = "paymentIdGenerator") //nazwa użyta w fakePaymentService
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public PaymentIdGenerator incrementalPaymentIdGenerator(){
        return new IncrementalPaymentIdGenerator();
    }

    @Bean
    public PaymentIdGenerator UUIDPaymentIdGenerator(){
        return new UUIDPaymentIdGenerator();
    }

    @Bean
    public PaymentRepository paymentRepository(){
        return new PaymentRepositoryHashMap();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public PaymentService fakePaymentService(PaymentIdGenerator paymentIdGenerator, PaymentRepository paymentRepository){
        return new FakePaymentService(paymentIdGenerator, paymentRepository);
    }

    @Bean
    public PaymentConsoleLogger paymentConsoleLogger(){
        return new PaymentConsoleLogger();
    }

}
