package pl.training.shop.training;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import pl.training.shop.payments.PaymentService;

import java.util.Arrays;

@EnableAspectJAutoProxy
public class Main {


    private static final String BASE_PACKAGE = "pl.training.shop.training";

    public static void main(String[] args){




        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BASE_PACKAGE)) {

            System.out.println("przed var person1");
            var person1 = applicationContext.getBean(Person.class);
            System.out.println("po var person1");
            System.out.println("przed var person2");
            var person2 = applicationContext.getBean(Person.class);
            System.out.println("po var person2");

            System.out.println("===== Beans list: ==== >>");
            System.out.println("bean counter: " + applicationContext.getBeanDefinitionCount());
            Arrays.stream(applicationContext.getBeanDefinitionNames())
                    .forEach(System.out::println);
            System.out.println("<< ===== Beans list ====");
            var person = new Person();
            person.test();
        }

    }
}
