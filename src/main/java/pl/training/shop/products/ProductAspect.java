package pl.training.shop.products;

import lombok.extern.java.Log;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ProductAspect {

    //@Before("execution(* *(..))")

    @Before(value = "@annotation(PAA)")
    public void before(){
        System.out.println("-----------------------Before every function-------------------------");
    }


}
