package pl.training.shop.training;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

@Configuration
@EnableAspectJAutoProxy
public class BeanConfig {


    @Bean
    public PersonComponent getPersonComponent(Person getPerson){
        System.out.println("utworzenie obiektu person Component");
        return new PersonComponent(getPerson);
    }

    @Bean
    public Person getPersonOne(){
        System.out.println("utworzenie obiektu Person One");
        return new Person();
    }




}
