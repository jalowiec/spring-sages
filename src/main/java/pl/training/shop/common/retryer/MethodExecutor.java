package pl.training.shop.common.retryer;

import lombok.Setter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MethodExecutor {

    @Setter
    private int attemps = 3;


    @Around("@annotation(Retry)")
    public Object afterThrowing(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        int currentAttempt = 0;
        Throwable throwable = new Throwable();
        do{
            System.out.println("###############ADD AROUND");
            currentAttempt++;
            try {
                proceedingJoinPoint.proceed();
            } catch(Throwable t){
                throwable = t;
            }
        } while(currentAttempt <= attemps);
        throw new TooManyAttemps();

    }


}
