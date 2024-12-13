package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;
import java.util.List;

@Aspect
public class SecurityAspect {

    private final String username = "admin";
    private final String password = "password";
    private final List<String> userRoles = Arrays.asList("role1", "role2");

    @Pointcut("@annotation(securedBy) && execution(* *(..))")
    public void securedMethod(SecuredBy securedBy) {
    }

    @Around("securedMethod(securedBy)")
    public Object secure(ProceedingJoinPoint joinPoint, SecuredBy securedBy) throws Throwable {
        // Simulate authentication
        if (!authenticate()) {
            throw new SecurityException("Authentication failed");
        }
        // Check roles
        for (String role : securedBy.roles()) {
            if (!userRoles.contains(role)) {
                throw new SecurityException("Authorization failed: missing role " + role);
            }
        }

        return joinPoint.proceed();
    }
    private boolean authenticate() {
        // Simulate authentication logic
        return "user".equals(username) && "password".equals(password);
    }
}