package pl.training.shop;

import lombok.extern.java.Log;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.training.shop.orders.Order;
import pl.training.shop.payments.*;
import pl.training.shop.products.Product;
import pl.training.shop.products.ProductType;


import java.awt.print.Book;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Log
public class Application {

    private static final String BASE_PACKAGE = "pl.training.shop";
    private static final String CONFIG_LOCATION = "beans.xml";
    private static final Product VIDEO_PRODUCT = Product.builder()
            .name("Spring masterclass")
            .description("Sprint masterclass course")
            .type(ProductType.VIDEO)
            .price(LocalMoney.of(799))
            .build();

    private static final Product BOOK_PRODUCT = Product.builder()
            .name("Spring guide")
            .description("cwiczenia")
            .type(ProductType.BOOK)
            .price(LocalMoney.of(200))
            .build();


    public static void main(String[] args) {



        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BASE_PACKAGE)){

            System.out.println("===== Beans list: ==== >>");
            System.out.println("bean counter: " + applicationContext.getBeanDefinitionCount());
            Arrays.stream(applicationContext.getBeanDefinitionNames())
                    .forEach(System.out::println);
            System.out.println("<< ===== Beans list ====");


            var shopService = applicationContext.getBean(ShopService.class);
            shopService.addProduct(VIDEO_PRODUCT);
            shopService.addProduct(BOOK_PRODUCT);
            log.info(shopService.getProducts(0, 100).toString());

            var order = new Order(List.of(VIDEO_PRODUCT, BOOK_PRODUCT));
            //var order = new Order(Collections.emptyList());
            shopService.placeOrder(order);
            var payment = shopService.payForOrder(order.getId());
            log.info(payment.getId());


  //      try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(CONFIG_LOCATION)){

      //      var paymentService = applicationContext.getBean(PaymentService.class);
        //    var paymentRequest = PaymentRequest.builder()
          //          .money(LocalMoney.of(1_000))
            //        .build();
            //var payment = paymentService.process(paymentRequest);
            //log.info(payment.toString());
        }
        //var paymentGenerator = new IncrementalPaymentIdGenerator();
        //var fakepaymentService = new FakePaymentService(paymentGenerator);
        //var paymentService = new LoggingPaymentService(fakepaymentService);



    }
}
