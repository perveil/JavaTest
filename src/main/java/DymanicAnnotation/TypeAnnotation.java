package DymanicAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)   //自定义注解在运行时保留
public @interface TypeAnnotation {
   String name() default  "ww";

}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)   //自定义注解在运行时保留
 @interface FiledAnnotation {
    String Sex() default  "男";

}

@TypeAnnotation(name = "www")
class Test{
    @FiledAnnotation(Sex = "女")
    private static String Sex;

    public static void main(String[] args) {
        TypeAnnotation ca = (TypeAnnotation) Test.class.getAnnotation(TypeAnnotation.class);
        System.out.println(ca.name());

        Field[] field = Test.class.getDeclaredFields();
        FiledAnnotation fileds=field[0].getAnnotation(FiledAnnotation.class);
        Test.Sex=fileds.Sex();
        System.out.println(Test.Sex);

    }
}
