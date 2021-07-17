package pl.training.shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.training.shop.orders.OrderRepository;
import pl.training.shop.orders.OrderRepositoryHashMap;
import pl.training.shop.orders.OrderService;
import pl.training.shop.payments.*;
import pl.training.shop.products.ProductRepository;
import pl.training.shop.products.ProductRepositoryHashMap;
import pl.training.shop.products.ProductService;

@Configuration
public class ShopConfig {

    @Bean
    public OrderRepository orderRepository(){
        return new OrderRepositoryHashMap();
    }

    @Bean
    public OrderService orderService(OrderRepository orderRepository){
        return new OrderService(orderRepository);
    }

    @Bean(name = "productRepository")
    public ProductRepository getProductRepository(){
        return new ProductRepositoryHashMap();
    }

    @Bean(name = "productService")
    public ProductService getProductService(ProductRepository productRepository){
        return new ProductService(productRepository);
    }

    @Bean
    public PaymentIdGenerator UUIDPaymentIdGenerator(){
        return new UUIDPaymentIdGenerator();
    }

    @Bean
    public PaymentRepository paymentRepository(){
        return new PaymentRepositoryHashMap();
    }

    @Bean
    public PaymentService fakePaymentService(PaymentIdGenerator paymentIdGenerator, PaymentRepository paymentRepository){
        return new FakePaymentService(paymentIdGenerator, paymentRepository);
    }

    @Bean
    public ShopService shopService(ProductService productService, OrderService orderService, PaymentService paymentService){
        return new ShopService(productService, orderService, paymentService);
    }


    @Bean
    public PaymentConsoleLogger paymentConsoleLogger(){
        return new PaymentConsoleLogger();
    }

}
