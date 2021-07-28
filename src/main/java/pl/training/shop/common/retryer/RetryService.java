package pl.training.shop.common.retryer;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class RetryService {

    //@AfterThrowing("@annotation(Retry)")
    @Before("@annotation(Retry)")
    public void afterThrowing(){
        System.out.println("AFTER THROWING");
    }

}
