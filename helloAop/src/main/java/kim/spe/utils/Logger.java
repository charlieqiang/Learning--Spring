package kim.spe.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author charlie
 * @date 2020/4/16 - 20:33
 * @description
 */
@Component("logger")
@Aspect
public class Logger {
    @Pointcut("execution(* kim.spe.service.*.*(..)))")
    private void logPointcut(){

    }

//    @Before("logPointcut()")
    public void beforePrintLog(){
        System.out.println("before logger start!");
    }

//    @AfterReturning("logPointcut()")
    public void afterReturningPrintLog(){
        System.out.println("after Returning logger start!");
    }

//    @AfterThrowing("logPointcut()")
    public void afterThrowingPrintLog(){
        System.out.println("Throwing!");
    }

//    @After("logPointcut()")
    public void afterPrintLog(){
        System.out.println("after logged!");
    }

    @Around("logPointcut()")
    public Object aroundPringLog(ProceedingJoinPoint pjp){
        Object rgValue = null;
        try {
            Object[] args = pjp.getArgs();
            System.out.println("befor the logger!");
            rgValue = pjp.proceed(args);
            System.out.println("after the logger!");
            return rgValue;
        } catch (Throwable throwable) {
            System.out.println("catch the logger!");
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("final the logger!");

        }

    }
}
