package DymanicAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
* https://www.cnblogs.com/huojg-21442/p/7239846.html
*
* */
public class DyAnnotation {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)   //自定义注解在运行时保留
    public  @interface UserAU{
        public String id();
        public String description() default "no description";
        public  int [] AuPre();
    }
}

