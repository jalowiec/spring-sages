package pl.training.shop;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ResourceBundleMessageSource;
import pl.training.shop.common.ContextListener;
import pl.training.shop.orders.OrderRepository;
import pl.training.shop.orders.OrderRepositoryHashMap;
import pl.training.shop.orders.OrderService;
import pl.training.shop.payments.*;
import pl.training.shop.products.ProductRepository;
import pl.training.shop.products.ProductRepositoryHashMap;
import pl.training.shop.products.ProductService;

@Configuration
@EnableAspectJAutoProxy
public class ShopConfig {





    @Bean
    public ShopService shopService(ProductService productService, OrderService orderService, PaymentService paymentService){
        return new ShopService(productService, orderService, paymentService);
    }

    @Bean
    public ContextListener contextListener(){
        return new ContextListener();
    }




}
