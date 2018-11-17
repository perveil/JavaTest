package GenericTest;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
* 异构容器
* */
public class Favorites {
    Map<Class<?>, Object> favorites=new HashMap<>();
    public <T> void putFa(@NonNull Class<T> type, T a){
            favorites.put(type,type.cast(a));
    }
    public <T> T getFa(Class<T> type){
        return  type.cast(favorites.get(type));
    }

    public static void main(String[] args) {
        Favorites favorites =new Favorites();
        favorites.putFa(Integer.class,12);

        List apples=new ArrayList();
        apples.add("asd");

        favorites.putFa(List.class,apples);

       System.out.println(favorites.getFa(List.class).toString());
    }
}
