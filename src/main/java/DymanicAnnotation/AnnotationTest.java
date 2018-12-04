package DymanicAnnotation;

import java.lang.reflect.Method;

public class AnnotationTest {
    public static void main(String[] args) {
         for(Method m:AnnotationTest.class.getDeclaredMethods()){
               if (m.isAnnotationPresent(DyAnnotation.UserAU.class)){
                   System.out.println(m.getAnnotation(DyAnnotation.UserAU.class).AuPre().length);
               }
         }

    }
    /*
    *设想：自定义注解，aop搭配，redis  实现权限管理
    * */
    @DyAnnotation.UserAU(id="47",description = "a",AuPre = {1,2,3})
    public static boolean validatePassword(String password) {

        return (password.matches("\\w*\\d\\w*"));
    }
}
