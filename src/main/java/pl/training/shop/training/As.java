package pl.training.shop.training;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class As {

    @Before(value = "@annotation(BeforeAs)")
    public void asBefore(){
        System.out.println("###############");
    }

}
