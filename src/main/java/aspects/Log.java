package aspects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // This annotation applies to methods
@Retention(RetentionPolicy.RUNTIME) // Retain annotation at runtime
public @interface Log {
}
