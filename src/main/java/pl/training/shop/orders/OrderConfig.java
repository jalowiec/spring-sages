package pl.training.shop.orders;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ResourceBundleMessageSource;
import pl.training.shop.common.ContextListener;
import pl.training.shop.payments.*;
import pl.training.shop.products.ProductRepository;
import pl.training.shop.products.ProductRepositoryHashMap;
import pl.training.shop.products.ProductService;

@Configuration
public class OrderConfig {


    @Bean
    public OrderService orderService(OrderRepository orderRepository){
        return new OrderService(orderRepository);
    }


}
