package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

    @Around("@annotation(aspects.Log)") // Pointcut for methods with @Log annotation
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed(); // Execute the method

        long duration = System.currentTimeMillis() - startTime;
        System.out.println(
                "Method " + joinPoint.getSignature() + " executed in " + duration + " ms"
        );

        return result;
    }
}
