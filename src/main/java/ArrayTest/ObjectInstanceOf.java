package ArrayTest;
public class ObjectInstanceOf {
    public static void main(String[] args) {
        Object c1=new int[]{};
        Object c2=new int[][]{};
        Object c3=new String[]{};

        System.out.println(c1 instanceof  Object[]);  //false
        System.out.println(c2 instanceof  Object[]);  //true
        System.out.println(c3 instanceof  Object[]);  //true

    }
}
