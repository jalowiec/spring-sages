package pl.training.shop.common.retryer;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class RetryService {

    //@AfterThrowing("@annotation(Retry)")
    @Before("@annotation(Retry)")
    public void afterThrowing(JoinPoint joinPoint){

        System.out.println(joinPoint.getTarget().toString());
        System.out.println(joinPoint.getThis().toString());
        joinPoint.
        System.out.println("AFTER THROWING");
    }

}
