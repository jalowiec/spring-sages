package pl.training.shop.products;

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
import pl.training.shop.payments.*;

@Configuration
public class ProductsConfig {


    @Bean(name = "productRepository")
    public ProductRepository getProductRepository(){
        return new ProductRepositoryHashMap();
    }

    @Bean(name = "productService")
    public ProductService getProductService(ProductRepository productRepository){
        return new ProductService(productRepository);
    }



}
