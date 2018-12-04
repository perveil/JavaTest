package CollectionTest;

import TestModel.Person;

import java.util.*;

public class ComparatorTest {


    public static void main(String[] args) {
        long a = 1;
        System.out.println(a + "");
        switch (a + "") {
            case "1":
                System.out.println("a");
                break;
            default:
                System.out.println("b");
                break;
        }

        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("a", 11));
        personList.add(new Person("a", 13));
        personList.add(new Person("b", 9));
        personList.add(new Person("b", 2));
        Person[] persons = {};
        persons = (Person[]) personList.toArray(persons);

        Arrays.sort(persons, comparator);
        //按照年纪大小排序
        System.out.println(persons[0].getAge());

        //按照名字分组
        Comparator<Person> Namecomparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };


        List<List<Person>> byName = divider(personList, Namecomparator);
        System.out.println(byName);
    }

    public static <T> List<List<T>> divider(Collection<T> datas, Comparator<? super T> c) {
        List<List<T>> result = new ArrayList<List<T>>();
        for (T t : datas) {
            boolean isSameGroup = false;
            for (int j = 0; j < result.size(); j++) {
                if (c.compare(t, result.get(j).get(0)) == 0) {
                    isSameGroup = true;
                    result.get(j).add(t);
                    break;
                }
            }
            if (!isSameGroup) {
                List<T> innerList = new ArrayList<T>();
                result.add(innerList);
                innerList.add(t);
            }

        }
        return result;
    }


}
