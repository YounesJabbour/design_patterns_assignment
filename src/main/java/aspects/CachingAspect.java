package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class CachingAspect {

    private final Map<String, Object> cache = new HashMap<>();

    @Around("@annotation(aspects.Cachable)")
    public Object cacheMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        Object result = joinPoint.proceed();
        cache.put(key, result);

        return result;
    }
}