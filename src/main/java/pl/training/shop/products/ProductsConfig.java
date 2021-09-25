package pl.training.shop.products;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductsConfig {


     @Bean(name = "productService")
    public ProductService getProductService(ProductRepository productRepository){
        return new ProductService(productRepository);
    }



}
