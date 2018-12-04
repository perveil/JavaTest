package ArrayTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class aapple{
    @Override
    public String toString() {
        return "apple";
    }
}
public class ArrayTest<T> {
    public static void main(String[] args) {
        int a[]={
                1,2,3
        };
        aapple aapples[]={
                new aapple(),
                new aapple(),
        };
        List<aapple> list=main1(aapples);
        System.out.println(list);

    }

    @SuppressWarnings("varargs")
    public static <T> List<T>   main1(T... args) {

         return Arrays.asList(args);

    }
}
